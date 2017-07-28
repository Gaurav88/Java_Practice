import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Gaurav-PC on 13-05-2017.
 */
//Given a chess board, find the shortest distance (minimum number of steps)
// taken by a Knight to reach given destination from given source.
public class CodeGladiatorSemi1 {

    // Below arrays details all 8 possible movements
    // for a knight
    static int row[] = {2, 2, -2, -2, 1, 1, -1, -1};
    static int col[] = {-1, 1, 1, -1, 2, -2, 2, -2};

    // Check if (x, y) is valid chess board coordinates
    // Note that a knight cannot go out of the chessboard
    static boolean valid(int x, int y) {
        if (x < 1 || y < 1 || x > 8 || y > 8)
            return false;

        return true;
    }

    // Find minimum number of steps taken by the knight
    // from source to reach destination using BFS
    static int BFS(Node src, Node dest) {
        // map to check if matrix cell is visited before or not
        Map<Node, Boolean> visited = new HashMap<>();
        //visited.put(src, false);
        // create a queue and enqueue first node
        LinkedList<Node> q = new LinkedList<>();
        q.add(src);

        // run till queue is not empty
        while (!q.isEmpty()) {
            // pop front node from queue and process it
            Node node = q.poll();
            //q.pop();

            int x = node.x;
            int y = node.y;
            int dist = node.dist;

            // if destination is reached, return distance
            if (x == dest.x && y == dest.y)
                return dist;

            // Skip if location is visited before
            if (!visited.containsKey(node)) {
                // mark current node as visited
                visited.put(node, true);

                // check for all 8 possible movements for a knight
                // and enqueue each valid movement into the queue
                for (int i = 0; i < 8; ++i) {
                    // Get the new valid position of Knight from current
                    // position on chessboard and enqueue it in the
                    // queue with +1 distance
                    int x1 = x + row[i];
                    int y1 = y + col[i];

                    if (valid(x1, y1)) {
                        Node n = new Node(x1, y1, dist + 1);
                        if (!visited.containsKey(n))
                            q.add(n);
                    }
                }
            }
        }

        // return INFINITY if path is not possible
        return Integer.MAX_VALUE;
    }

    static class Node {
        int x, y, dist;

        public Node(int x1, int y1, int i) {
            this.x = x1;
            this.y = y1;
            this.dist = i;
        }
    }

    public static void main(String[] args) {
        int input1 = 2;
        int input2 = 1;
        int input3 = 6
                ;
        int input4 = 5;
        System.out.println(getStepCount(input1, input2, input3, input4));
    }

    public static int getStepCount(int input1, int input2, int input3, int input4) {
        Node src = new Node(input1, input2, 0);
        Node dest = new Node(input3, input4, 0);
        int res = BFS(src, dest);
        return res;
    }
}
