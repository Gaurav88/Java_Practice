import java.util.Scanner;

/**
 * Created by Gaurav-PC on 22-07-2017.
 */
/*She found four numbers n,a, b and c .Now, She wants to know how many number exists which are less than or equal to n and are divisible by a ,b or c .
Input : First line contains 't' denoting numbers of test cases

Next t lines contains 4 integers denoting n,a,b and c separated by space

Output : 't' lines containing the count of the numbers which are divisible a,b,c

Sample Input
1
15 2 3 5

Sample Output
11
 */
//100% Correct
public class AristocratHack1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
            long n = s.nextInt();
            long a = s.nextInt();
            long b = s.nextInt();
            long c = s.nextInt();
            long out_ = divisibilty(a, c, b, n);
            System.out.println(out_);
        }
        // System.out.println(divisibilty(2,3,5,1,15));
    }

    static long divisibilty(long a, long c, long b, long n) {
        // Write your code here
        long count = 0;
        for (long i = 2; i <= n; i++) {
            if ((i % a == 0) || (i % b == 0) || (i % c == 0)) {
                count++;
            }
        }
        System.out.println(count);

        //Optimised code here
        count = 0;
        count += n / a;
        count += n / b;
        count += n / c;
        long num1 = lcm(a, b);
        count -= n / num1;

        long num2 = lcm(a, c);
        count -= n / num2;

        long num3 = lcm(b, c);
        count -= n / num3;

        long num4 = lcm(lcm(a, b), c);
        count += n / num4;
        return count;

    }

    //This is best way to find LCM
    public static long lcm(long a, long b) {
        return (a * b) / GCF(a, b);
    }


    public static long GCF(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return (GCF(b, a % b));
        }
    }

}
