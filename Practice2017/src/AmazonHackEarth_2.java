import java.util.*;

/**
 * Created by Gaurav-PC on 27-05-2017.
 */
public class AmazonHackEarth_2 {

    static List<String> list = new ArrayList<>();
    static Set<String> set = new HashSet<>();

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
        int iter = s.nextInt();
        String temp = s.nextLine();
        for (int i = 0; i < iter; i++) {
            list = new ArrayList<>();
            set = new HashSet<>();
            String line = s.nextLine();
            String[] str = line.split(" ");
            int place = Integer.parseInt(str[1]);
            permutation("", str[0]);
            Collections.sort(list);
            System.out.println(list.get(place-1));
        }
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            if(!set.contains(prefix)) {
                list.add(prefix);
                set.add(prefix);
            }
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }
}
