import java.util.*;
import java.util.Vector;

/**
 * Created by Gaurav-PC on 01-07-2017.
 */
public class GrouponHackerEarth1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int arr[] = new int[N];
        long total = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
            total += arr[i];
        }

        long k = s.nextInt();
        long res = SubArraySum1(arr, N, k);
        System.out.println(res);

    }


    static long SubArraySum1(int arr[], int n, long range)
    {

        long count = 0;
        // Pick starting point
        for (int i=0; i <n; i++)
        {
            // Pick ending point
            for (int j=i; j<n; j++)
            {
                long result = 0;
                for (int k=i; k<=j; k++) {
                    result += arr[k];
                    if(result >= range){
                        count++;
                    }
                }
            }
        }
        return count ;
    }

}
