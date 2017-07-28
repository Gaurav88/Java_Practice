import javax.swing.*;
import java.util.Scanner;

/**
 * Created by Gaurav-PC on 27-05-2017.
 */
/*All N friends are seated in a circle, and are numbered from 0 to N-1. Scooby is initially sitting beside the Ath friend. After greeting one friend, he goes clockwise to the Bth next friend, sits next to him and greets him. He repeats this till he returns to the Ath friend.

In his excitement, it is possible that Scooby misses out on greeting some friends. Your job is to find the number of friends (including A) that Scooby will have greeted before reaching back to A.

Input:

The first line contains T, the number of test cases.

Each of the next T lines contain three space-separated integers, the values of A, B and N for that test case.

Output:

For each test case, output the number of friends that Scooby will have greeted before reaching back to A.*/
public class AmazonHackEarth_1 {
    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        //Scanner
        Scanner s = new Scanner(System.in);
        int iter = s.nextInt();

        for (int i = 0; i < iter; i++) {
            int A = s.nextInt();
            int B = s.nextInt();
            int num = s.nextInt();
            countFriends(A, B, num);
        }

    }

    private static void countFriends(int A, int B, int num) {
        ListNode start = createCircularLinked(A, num);
        int counter = B;
        while (B != 0) {
            start = start.next;
            B--;
        }
        B = counter;
        int res = 1;
        while (start.val != A) {
            while (B != 0) {
                start = start.next;
                B--;
            }
            res++;
            B = counter;
        }
        System.out.println(res);
    }

    private static ListNode createCircularLinked(int A, int len) {
        int count = 0;
        ListNode temp = new ListNode(-1);
        ListNode start = temp;
        ListNode startNode = null;
        while (len > 0) {
            ListNode node = new ListNode(count);
            count++;
            temp.next = node;
            temp = node;
            len--;
            if (node.val == A) {
                startNode = node;
            }
        }
        start = start.next;
        temp.next = start;
        return startNode;
    }


}

/*class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}*/
