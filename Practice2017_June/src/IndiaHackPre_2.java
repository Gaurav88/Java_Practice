import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Gaurav-PC on 18-06-2017.
 */
//THIS SOLUTION IS WRONG
public class IndiaHackPre_2 {
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

        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }

        for (int j = 0; j < M; j++) {
            int num = s.nextInt();
            boolean res = false;
            //Map<Integer, Integer> hMap = noOfFactors(num);
            for (int i = 0; i < N; i++) {
                int temp = num;
                if (temp % arr[i] == 0) {
                    while (temp % arr[i] == 0) {
                    /*int temp = hMap.get(arr[i]);
                    int diff = count - temp;*/
                        temp = temp / arr[i];
                    }
                    noOfFactors(temp);
                    if (count < 3) {
                        System.out.println("YES");
                        res = true;
                        break;
                    }
                }
            }
            if (!res) {
                System.out.println("NO");
                //res = true;
            }
        }

    }


    static int count = 0;

    static void noOfFactors(int n) {
        count = 0;
        //Map<Integer, Integer> hMap = new HashMap<>();
        int temp = n;
        for (int i = 2; i <= temp / 2; i += 1) {
            if(i == n){
                break;
            }
            while (n % i == 0) {
                /*if (!hMap.containsKey(i)) {
                    hMap.put(i, 1);
                } else {
                    hMap.put(i, hMap.get(i) + 1);
                }*/
                count++;
                n = n / i;
            }
        }

    }
}
