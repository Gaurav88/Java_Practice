import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by Gaurav-PC on 11-06-2017.
 */
/*There are given n ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. We need to connect the ropes with minimum cost.

For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We can connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
3) Finally connect the two ropes and all ropes have connected.

Total cost for connecting all ropes is 5 + 9 + 15 = 29.
*/
public class MinimumCostRope {
    static int minCost(PriorityQueue<Integer> pq) {
        int sum = 0;
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            sum = sum + num1 + num2;
            pq.add(num1 + num2);
        }
        return sum;
    }

    public static void main(String[] args) {
        Integer len[] = {4, 3, 2, 6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(len));
        pq.addAll(arr);
        System.out.println(minCost(pq));
    }
}
