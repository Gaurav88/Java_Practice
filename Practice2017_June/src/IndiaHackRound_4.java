import java.util.*;

/**
 * Created by Gaurav-PC on 23-07-2017.
 */

/**
 * Input:

 First line of input contains an integer
 T, denoting the number of test cases. Each test case contains
 2 lines. First line of each test case contains a single integer
 N, denoting the number of elements in the permutation
 P. Next line of each test case contains
 N space separated integers denoting the permutation
 P.

 Output:

 For each testcase, print an integer, the bitwise XOR of the number of inversions in each permutation which are created by cyclic shifts on the initial permutation.

 SAMPLE INPUT
 1
 5
 1 5 2 4 3
 SAMPLE OUTPUT
 10

 Explanation
 The
 5 distinct permutations are:

 [1,5,2,4,3] - Inversions=4  (It means no on right less than current no ) and sum of all these after iteratin(e.g. 0+3+0+1+0 = 4)
 [5,2,4,3,1] - Inversions=8=8.
 [2,4,3,1,5] - Inversions=4=4.
 [4,3,1,5,2] - Inversions=6=6.
 [3,1,5,2,4] - Inversions=4=4.
 Final answer =4 XOR 8 XOR 4 XOR 6 XOR 4=10
 */
public class IndiaHackRound_4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            int arr[] = new int[N];
            int[] temp = new int[N];
            ListNode node = new ListNode(-1);
            ListNode start = node;
            for (int j = 0; j < N; j++) {
                int num = s.nextInt();
                node.next = new ListNode(num);
                node = node.next;
                arr[j] = num;
                //temp.add(num);
                temp[j] = num;
            }
            //Arrays.sort(temp);
            node.next = start.next;
            int fin = 0;
            for (int k = 0; k < N; k++) {
                // int res = countInver(arr, temp);
                int res = countInverNew(start.next, temp, N);
                fin = fin ^ res;
                //arr = rotate(arr);
                start = start.next;
            }
            System.out.println(fin);

        }
    }


    private static int countInverNew(ListNode node, int[] temp, int N) {
        int count = 0;
        /*for (int i = 0; i < N; i++) {
            //temp[node.val -1] = Integer.MAX_VALUE;
            count += getLength(temp, node.val);
            node = node.next;
        }*/
        ListNode current = node;
        ListNode Nex = current.next;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (Nex.val < current.val) {
                    count++;
                }
                Nex = Nex.next;
            }

            current = current.next;
            Nex = current.next;
        }
        return count;
    }

    private static int getLength(int[] arr, int n) {
        int len = 0;
        for (int num : arr) {
            if (num < n && num != Integer.MAX_VALUE) {
                len++;
            }
            if (num >= n && num != Integer.MAX_VALUE) {
                arr[n - 1] = Integer.MAX_VALUE;
                break;
            }
        }
        return len;
    }


}
