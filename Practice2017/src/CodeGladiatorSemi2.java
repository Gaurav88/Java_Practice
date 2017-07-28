import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Gaurav-PC on 14-05-2017.
 */
public class CodeGladiatorSemi2 {

    static class Rectangele {
        int x1, y1, x2, y2;

        public Rectangele(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static int sum = 3;
    static List<Rectangele> set = new ArrayList<>();
    static int peri = Integer.MAX_VALUE;

    public static void findRectangles(int[][] mat, int row, int col) {
        for (int y = 0; y < row; y++) {
            findArray(mat, y, row, col);
        }
    }

    public static void findArray(int[][] mat, int start1, int row, int col) {
        int[] temp = new int[col];
        //
        for (int y = start1; y < row; y++) {
            temp = addMatrix(mat[y], temp);

            int curr_sum = temp[0], start = 0, i;

    /* Add elements one by one to curr_sum and if the curr_sum exceeds the
       sum, then remove starting element */
            for (i = 1; i <= col; i++) {
                // If curr_sum exceeds the sum, then remove the starting elements
                while (curr_sum > sum && start < i - 1) {
                    curr_sum = curr_sum - temp[start];
                    start++;
                }

                // If curr_sum becomes equal to sum, then return true
                if (curr_sum == sum && temp[i - 1] != 0) {
                    while (temp[start] == 0) {
                        start++;
                    }
                    Rectangele rect = findCorrectCoord(mat, temp, y, start, i - 1, start1);
                    findTopAndBootomRect(rect);
                }
                // Add this element to curr_sum
                if (i < col)
                    curr_sum = curr_sum + temp[i];
            }

        }
    }

    public static void findTopAndBootomRect(Rectangele rect) {
        int x1 = Integer.min(rect.x1, rect.x2);
        int y1 = -1 * Integer.min(rect.y1, rect.y2);

        int x2 = Integer.max(rect.x1, rect.x2);
        int y2 = -1 * Integer.max(rect.y1, rect.y2);
        Rectangele r = new Rectangele(x1, y1, x2, y2);
        set.add(r);
    }

    public static Rectangele findCorrectCoord(int[][] mat, int[] temp, int currentRow, int x1, int x2, int start1) {
        int min[] = new int[temp.length];
        int max[] = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < temp.length; i++) {
            max[i] = Integer.MIN_VALUE;
        }
        for (int i = x1; i <= x2; i++) {
            int val = temp[i];
            if (val != 0) {
                //for min
                for (int j = currentRow; j >= 0; j--) {
                    val = val - mat[j][i];
                    if (val == 0) {
                        min[i] = j;
                        break;
                    }
                }
                //for max
                int val1 = temp[i];
                for (int j = start1; j <= currentRow; j++) {
                    val1 = val1 - mat[j][i];
                    if (val1 == 0) {
                        max[i] = j;
                        break;
                    }
                }
            }
        }

        int y1 = minArray(min);
        int y2 = maxArray(max);
        Rectangele rect = new Rectangele(x1, y1, x2, y2);

        return rect;
    }

    public static int minArray(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int maxArray(int[] arr) {
        int min = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > min) {
                min = num;
            }
        }
        return min;
    }

    public static int[] addMatrix(int[] mat, int[] toAdd) {
        int[] temp = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            temp[i] = mat[i] + toAdd[i];
        }
        return temp;
    }

    public static int[][] createMatrix(int[][] arr, int row, int col, int count) {
        int[][] mat = new int[row][col];
        for (int i = 0; i < count; i++) {
            int one = row - arr[i][1];
            int zero = arr[i][0] - 1;
            mat[one][zero] = mat[one][zero] + 1;
        }

        return mat;
    }

    public static void nonOverlapping() {
        for (int i = 0; i < set.size(); i++) {
            for (int j = i + 1; j < set.size(); j++) {
                if (!doOverlap(set.get(i), set.get(j))) {
                    int num = findPerimeter(set.get(i)) + findPerimeter(set.get(j));
                    if (num < peri) {
                        peri = num;
                    }
                }
            }
        }
    }

    static int findPerimeter(Rectangele r1) {
        int num = (r1.x2 - r1.x1 + 1) + (r1.y1 - r1.y2 + 1);
        return num * 2;
    }

    // Returns true if two rectangles (l1, r1) and (l2, r2) overlap
    static boolean doOverlap(Rectangele r1, Rectangele r2) {
        // If one rectangle is on left side of other
        if (r1.x1 > r2.x2 || r2.x1 > r1.x2)
            return false;

        // If one rectangle is above other
        if (r1.y1 < r2.y2 || r2.y1 < r1.y2)
            return false;

        return true;
    }

    public static int homesteadThatDefinesANewLivingPlanet(int input1, int input2, int input3, int input4, int[][] input5) {
        int[][] mat = createMatrix(input5, input2, input1, input3);
        sum = input4;
        findRectangles(mat, input2, input1);

        nonOverlapping();
        if (peri == Integer.MAX_VALUE) {
            return 0;
        }
        return peri;
    }

    public static void main(String[] args) {
        int[][] arr = {{3, 4}, {3, 3}, {6, 1}, {1, 1}, {5, 5}, {5, 5}, {3, 1}};
        int row = 5;
        int col = 6;
        int totalIP = 7;
        int count = 3;
        int res = homesteadThatDefinesANewLivingPlanet(col, row, totalIP, count, arr);
        System.out.println(res);
        /*int[][] mat = createMatrix(arr, row, col, 7);
        findRectangles(mat, row, col);

        nonOverlapping();
        System.out.println(peri);*/
    }
}
