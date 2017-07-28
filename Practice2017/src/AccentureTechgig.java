import java.util.ArrayList;

/**
 * Created by Gaurav-PC on 26-03-2017.
 */
public class AccentureTechgig {
    static ArrayList<ArrayList> list = new ArrayList<ArrayList>();
    static ArrayList<Integer> temp = new ArrayList<Integer>();

    public static int ball_count(int[] input1, int input2, int input3) {
        //Write code here
        int result =Integer.MAX_VALUE;
        int n = input1.length;
        printCombination(input1, n, input3);
        for(ArrayList<Integer> tempList : list){
            int sum =0;
            for(int num : tempList){
                sum += num;
            }
            if(sum%input2 ==0 && sum < result){
                result = sum;
            }
        }
        if(result == Integer.MAX_VALUE){
            result = -1;
        }
        return result;
    }

    //Print all possible combinations of r elements in a given array of size n
    static void combinationUtil(int arr[], int n, int r, int index,
                                int data[], int i) {
        // Current combination is ready to be printed, print it
        if (index == r) {
            for (int j = 0; j < r; j++)
                temp.add(data[j]);
            list.add(temp);
            temp = new ArrayList<Integer>();
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= n)
            return;

        // current is included, put next at next location
        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1, data, i + 1);

        // current is excluded, replace it with next (Note that
        // i+1 is passed, but index is not changed)
        combinationUtil(arr, n, r, index, data, i + 1);
    }

    static void printCombination(int arr[], int n, int r) {
        // A temporary array to store all combination one by one
        int data[] = new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, n, r, 0, data, 0);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int input2=5;
        int input3 =3;
        System.out.println(ball_count(arr,input2,input3));
    }
}
