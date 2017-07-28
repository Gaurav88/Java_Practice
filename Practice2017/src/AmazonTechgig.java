import java.util.*;

/**
 * Created by Gaurav-PC on 29-04-2017.
 */
//Not passing all the testcases
public class AmazonTechgig {

    private static Map<Integer, Set<Integer>> st = new HashMap<Integer, Set<Integer>>();
    static boolean visited[];

    public static void addEdge(int v, int w) {
        if (!hasVertex(v)) addVertex(v);
        if (!hasVertex(w)) addVertex(w);
        //if (!hasEdge(v, w)) E++;
        st.get(v).add(w);
        st.get(w).add(v);
    }

    public static void addVertex(int v) {
        if (!hasVertex(v)) st.put(v, new HashSet<Integer>());
    }

    public static boolean hasVertex(int v) {
        return st.containsKey(v);
    }

    public static Iterable<Integer> adjacentTo(int v) {

        return st.get(v);
    }

    public static int prisonEscape(int input1, int input2, int[] input3, String[] input4) {
        //Write code here

        for (String s : input4) {
            String str[] = s.split(" ");
            addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        }
        visited = new boolean[input1 + 1];
        visited[input2] = true;
        int res = 0;
        for (int num : input3) {
            int temp = BFS(input2, num);
            if (temp == -1) {
                res = -1;
                break;
            }
            if (temp > res) {
                res = temp;
            }
            visited = new boolean[input1 + 1];
        }
        return res;
    }

    static void addSet(Set<Integer> set, LinkedList<Node> queue, int dist) {
        for (int num : set) {
            if (visited[num] == false) {
                Node n = new Node(num, dist);
                queue.add(n);
                visited[num] = true;
            }
        }
    }

    static int BFS(int s, int k) {

        LinkedList<Node> queue = new LinkedList<Node>();
        Set<Integer> set = st.get(s);
        addSet(set, queue, 1);
        int count = 0;
        while (!queue.isEmpty()) {
            Node n = queue.pop();
            if (n.num == k) {
                return n.dist;
            }
            Set<Integer> tempSet = st.get(n.num);
            addSet(tempSet, queue, n.dist + 1);
            //count++;
        }


        return -1;
    }

    static class Node {
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    public static void main(String args[]) {
        //addEdge(0, 1);
        /*addEdge(3, 2);
        addEdge(2, 4);
        addEdge(2, 5);
        addEdge(4, 5);
        addEdge(1, 5);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");
        visited = new boolean[6];
        visited[4] = true;
        System.out.println(BFS(4, 3));*/
        Scanner in = new Scanner(System.in);
        int output = 0;
        int ip1 = Integer.parseInt(in.nextLine().trim());
        int ip2 = Integer.parseInt(in.nextLine().trim());
        int ip3_size = 0;
        ip3_size = Integer.parseInt(in.nextLine().trim());
        int[] ip3 = new int[ip3_size];
        int ip3_item;
        for(int ip3_i = 0; ip3_i < ip3_size; ip3_i++) {
            ip3_item = Integer.parseInt(in.nextLine().trim());
            ip3[ip3_i] = ip3_item;
        }
        int ip4_size = 0;
        ip4_size = Integer.parseInt(in.nextLine().trim());
        String[] ip4 = new String[ip4_size];
        String ip4_item;
        for(int ip4_i = 0; ip4_i < ip4_size; ip4_i++) {
            try {
                ip4_item = in.nextLine();
            } catch (Exception e) {
                ip4_item = null;
            }
            ip4[ip4_i] = ip4_item;
        }
        output = prisonEscape(ip1,ip2,ip3,ip4);
        System.out.println(String.valueOf(output));
    }

}

