import java.util.*;

/**
 * Created by Gaurav-PC on 01-07-2017.
 */
public class GrouponHackerEarth3 {
    private static Stack<String> path = new Stack<String>();   // the current path
    private static Set<String> onPath = new HashSet<String>();
    static HashSet<Integer> set = new HashSet<Integer>();

    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        //Scanner
        allPrime(200000);
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        Graph g = new Graph();
        for (int i = 0; i < N - 1; i++) {
            String num1 = String.valueOf(s.nextInt());
            String num2 = String.valueOf(s.nextInt());
            g.addEdge(num1, num2);
            g.addEdge(num2, num1);
        }
        int M = s.nextInt();
        for (int i = 0; i < M; i++) {
            path = new Stack<String>();
            onPath = new HashSet<String>();
            enumerate(g, String.valueOf(s.nextInt()), String.valueOf(s.nextInt()));
        }



    }

    private static void enumerate(Graph G, String v, String t) {

        path.push(v);
        onPath.add(v);

        if (v.equals(t)) {
            int count = 0;
            for (String s : path) {
                if (set.contains(Integer.parseInt(s))) {
                    count++;
                }
            }
            System.out.println(count);
        } else {
            for (String w : G.adjacentTo(v)) {
                if (!onPath.contains(w)) enumerate(G, w, t);
            }
        }

        path.pop();
        onPath.remove(v);
    }

    static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static void allPrime(int n) {

        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                set.add(i);
        }
    }

}
