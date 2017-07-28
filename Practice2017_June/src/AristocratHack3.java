import java.util.Scanner;

/**
 * Created by Gaurav-PC on 22-07-2017.
 */
/*http://www.geeksforgeeks.org/combinatorial-game-theory-set-2-game-nim/
        1
        3 10
        1 2 3
        Input Format :
        The first line consists of a single integer
        T
        T denoting the number of test-cases in a single test file.
        The first line of each test case consists of a
        2 space separated integers
        N and X. The next line consists of N space separated integers, where the
        ith integer denotes
        A[i].

        Output Format :

        For each test case, print the winner of the game on a new line.*/
public class AristocratHack3 {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            int X = s.nextInt();
            int res = 0;
            for (int j = 0; j < N; j++) {
                res = res ^ s.nextInt();
            }
            if (res == 0) {
                System.out.println("BOB");
            } else {
                System.out.println("Alice");
            }
        }
    }
}
