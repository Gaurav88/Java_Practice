import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Gaurav-PC on 23-03-2017.
 */
public class Java8Streams {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        Random rnd = new Random();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            arr.add(rnd.nextInt());
        }

        /*int result = 0;
        for (int i : arr) {
            result += result + f(i);
        }
        */
        //int result = arr.stream().map(i -> f(i)).reduce(Integer::sum).get();
       // int result = arr.parallelStream().map(i -> f(i)).reduce(Integer::sum).get();
       // System.out.println(result);
        int sum = arr.parallelStream().mapToInt(i -> f(i)).sum();
        System.out.println(sum);
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);



    }

    public static int f(int n) {
        for (int i = 1; i < 10000; i++) {
            n = (n ^ i) % i;
            if (n <= 0) {
                n = 10;
            }
        }
        return n;
    }
}
