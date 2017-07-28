import java.util.*;

/**
 * Created by Gaurav-PC on 10-06-2017.
 */
//Find path in matrix from 0 to end ---> condition we can move only to prime numbers in matrix
    /*Input :-
3 3
2 3 7
5 4 2
3 7 11

O/P :-
4
1 1
2 1
3 2
3 3

Total number of paths and one path
*/
public class SamsungHackerEarth_2 {

    private static Stack<String> path = new Stack<String>();   // the current path
    private static Set<String> onPath = new HashSet<String>();
    static HashMap<Integer, Coordinates> hMap = new HashMap<>();
    static List<List<Coordinates>> superList = new ArrayList<List<Coordinates>>();

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
        int N = s.nextInt();
        int M = s.nextInt();
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.nextInt();
            }
        }

        int[][] temp = new int[N][M];
        int count = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = count;
                hMap.put(count, new Coordinates(i + 1, j + 1));
                count++;
            }
        }
        //Tobe corrected
        Graph g = new Graph();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j + 1 < M && isPrime(arr[i][j + 1])) {
                    g.addEdge(String.valueOf(temp[i][j]), String.valueOf(temp[i][j + 1]));
                }
                if (i + 1 < N && isPrime(arr[i + 1][j])) {
                    g.addEdge(String.valueOf(temp[i][j]), String.valueOf(temp[i + 1][j]));
                }
                if (j + 1 < M && i + 1 < N && isPrime(arr[i + 1][j + 1])) {
                    g.addEdge(String.valueOf(temp[i][j]), String.valueOf(temp[i + 1][j + 1]));
                }

            }
        }
        enumerate(g, "1", String.valueOf(N * M));

        int n = superList.size();
        System.out.println(superList.size());
        for (Coordinates l : superList.get(n - 1)) {
            System.out.println(l.x + " " + l.y);
        }
    }

    private static void enumerate(Graph G, String v, String t) {

        // add node v to current path from s
        path.push(v);
        onPath.add(v);

        // found path from s to t - currently prints in reverse order because of stack
        if (v.equals(t)) {
            List<Coordinates> list = new ArrayList<>();
            for (String str : path) {
                list.add(hMap.get(Integer.parseInt(str)));
            }
            superList.add(list);
            //System.out.println(path);
        }

        // consider all neighbors that would continue path with repeating a node
        else {
            for (String w : G.adjacentTo(v)) {
                if (!onPath.contains(w)) enumerate(G, w, t);
            }
        }

        // done exploring from v, so remove from path
        path.pop();
        onPath.remove(v);
    }

    //checks whether an int is prime or not.
    static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        //if not, then just check the odds
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

class Coordinates {
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Graph {
    //private int V;   // No. of vertices
// private LinkedList<Integer> adj[]; //Adjacency Lists

    private Map<String, Set<String>> st;

    // Constructor
    Graph() {

        st = new HashMap<String, Set<String>>();
    }

    // Function to add an edge into the graph
    public void addEdge(String v, String w) {
        if (!hasVertex(v)) addVertex(v);
        if (!hasVertex(w)) addVertex(w);
        //if (!hasEdge(v, w)) E++;
        st.get(v).add(w);
        //st.get(w).add(v);
    }

    public void addVertex(String v) {
        if (!hasVertex(v)) st.put(v, new HashSet<String>());
    }

    public boolean hasVertex(String v) {
        return st.containsKey(v);
    }

    public Iterable<String> adjacentTo(String v) {
        //validateVertex(v);
        return st.get(v);
    }
}