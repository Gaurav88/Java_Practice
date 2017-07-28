import java.util.*;

/**
 * Created by Gaurav-PC on 18-06-2017.
 */
public class IndiaHackPre_3 {
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

        long arr[] = new long[N];
        long temp[] = new long[N];
        long cal = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
            cal += arr[i];
            temp[i] = cal;
        }
        for (int i = 0; i < M; i++) {
            int type = s.nextInt();
            int l = s.nextInt();
            int r = s.nextInt();
            if (type == 1) {
                int k = s.nextInt();
                long sum = 0;
                // NEW_2
                for (int j = l; j <= r; j++) {
                    if (j - k - 2 >= 0) {
                        sum += temp[j - 1] - temp[j - k - 2];
                    } else {
                        sum += temp[j - 1];
                    }
                }
                System.out.println(sum);
            }
            if (type == 2) {
                long diff = arr[l - 1] - r;
                arr[l - 1] = r;
                temp = reBuild(temp, l, diff);
            }
        }
    }

    private static long[] reBuild(long[] temp, int l, long diff) {
        for (int i = l - 1; i < temp.length; i++) {
            temp[i] = temp[i] - diff;
        }
        return temp;
    }
}