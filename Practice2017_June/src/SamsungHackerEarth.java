import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Gaurav-PC on 10-06-2017.
 */

//Find GCD of fibonacci numbers in ranges lets arr is 2,4,8 then find fibonnaci from arr[1] to arr[2]  --> GCD(Fib(4), fib(8)) --> Ans
public class SamsungHackerEarth {
    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line); */

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int Q = s.nextInt();
        int arr[] = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        long fib[] = fibonacci(max);

        for (int i = 0; i < Q; i++) {
            int x = s.nextInt();
            int y = s.nextInt();

            System.out.println(GCD(x - 1, y - 1, fib, arr));
        }


    }

    public static long[] fibonacci(int n) {
        long arr[] = new long[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public static long GCD(int x, int y, long[] fib, int arr[]) {
        long[] temp = new long[y - x + 1];
        for (int i = x, count = 0; i <= y; i++, count++) {
            temp[count] = fib[arr[i]];
        }
        long gcdRes = findGcd(temp);
        return gcdRes;
    }

    public static long findGcd(long[] num) {
        long s = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < s) {
                s = num[i];
            }
        }
        while (s > 1) {
            int count = 0;
            int mod = 0;
            while (count < num.length) {
                mod += num[count] % s;
                count++;
            }
            if (mod == 0) {
                return s;
            }
            s--;
        }
        return 1;
    }
}
