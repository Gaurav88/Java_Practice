import java.util.Scanner;

/**
 * Created by Gaurav-PC on 23-07-2017.
 */
public class IndiaHackRound_1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        int X = s.nextInt();
        int len = N;
        ListNode start = createCircularLinked(X - 1, N);
        while(true) {
            int mod = (start.val+1) % K;
            if(len < mod ){
                break;
            }
            while (true) {
                //start = start.next;
                if(mod ==0){
                    start = start.next;
                    break;
                }
                start.next = start.next.next;
                mod--;
                len--;
            }

        }
        System.out.println(start.val+1);
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


class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}