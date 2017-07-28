//import for Scanner and other utility classes

import java.util.*;

/*Given an array of 0s and 1s, find the only one 0 to be replaced with 1 to get longest continuous sequence of 1s.
Find max number of one after this replacement

13
1 1 0 0 1 0 1 1 1 0 1 1 1
o/p:- 7

5
1 1 1 0 1
o/p:- 4

http://www.geeksforgeeks.org/find-index-0-replaced-1-get-longest-continuous-sequence-1s-binary-array/
*/
public class IndiaHackPre_1 {

    static int maxOnesIndex(int arr[], int n) {
        int max_count = 0;  // for maximum number of 1 around a zero
        int max_index = 0;  // for storing result
        int prev_zero = -1;  // index of previous zero
        int prev_prev_zero = -1; // index of previous to previous zero

        // Traverse the input array
        for (int curr = 0; curr < n; ++curr) {
            // If current element is 0, then calculate the difference
            // between curr and prev_prev_zero
            if (arr[curr] == 0) {
                // Update result if count of 1s around prev_zero is more
                if (curr - prev_prev_zero > max_count) {
                    max_count = curr - prev_prev_zero;
                    max_index = prev_zero;
                }

                // Update for next iteration
                prev_prev_zero = prev_zero;
                prev_zero = curr;
            }
        }

        // Check for the last encountered zero
        if (n - prev_prev_zero > max_count)
            max_index = prev_zero;

        return max_index;
    }

    public static void main(String args[]) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }
        int pos = maxOnesIndex(arr, N);
        int count1 = checkOneLeft(arr, pos);
        int count2 = checkOneRight(arr, pos);
        if(extraOne){
            count1++;
        }
        System.out.println(count1 + count2);
    }

    static boolean extraOne = false;

    public static int checkOneRight(int[] arr, int i) {
        int res = 0;
        boolean test = false;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] == 0 && !test) {
                test = true;
                //break;
            }

            if (test) {
                if (arr[j] == 1) {
                    extraOne = true;
                }
            }
            if (!test) {
                res++;
            }
        }
        return res;
    }

    public static int checkOneLeft(int[] arr, int i) {
        int res = 0;
        boolean test = false;
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] == 0 && !test) {
                test = true;
                if(extraOne) {
                    break;
                }
            }
            if (test) {
                if (arr[j] == 1) {
                    extraOne = true;
                }
            }
            if (!test) {
                res++;
            }
        }
        return res;
    }
}
