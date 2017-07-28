import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Gaurav-PC on 01-07-2017.
 */
public class GrouponHackerEarth2 {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }

        long out_ = non_coprime_subarrays(arr);
        System.out.println(out_);

    }

    static long non_coprime_subarrays(int[] arr) {
        // Your Code Goes Here
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            long[] temp = new long[arr.length];
            for (int j = i; j < arr.length; j++) {
                temp[j] = arr[j];
                long gcd = findGcd(temp);
                if (gcd > 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static long findGcd(long[] num) {
        long s = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                s = num[i];
            }
        }
        for (int i = 1; i < num.length; i++) {
            if (num[i] < s && num[i] > 0) {
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
