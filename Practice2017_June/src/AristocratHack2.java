import java.util.Scanner;

/**
 * Created by Gaurav-PC on 22-07-2017.
 */
public class AristocratHack2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        long arr[] = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }
        long Q = s.nextInt();
        for (long i = 0; i < Q; i++) {
            int op = s.nextInt();
            int a = s.nextInt();
            int b = s.nextInt();
            if (op == 0)
                System.out.println(Xor(arr, a, b));
            if (op == 1)
                arr[a-1] = arr[a-1] ^ b;
        }
    }

    static long Xor(long arr[], int a, int b) {

        long res = 0;
        for (int i = a-1; i < b; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

}
