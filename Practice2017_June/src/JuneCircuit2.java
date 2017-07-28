import java.util.Scanner;

/**
 * Created by Gaurav-PC on 21-06-2017.
 */
public class JuneCircuit2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            int r = s.nextInt();
            int total = s.nextInt();
            int p = s.nextInt();
            int a =1;
            int sum =1;
            int res = -1;
            for(int j =1; j<p; j++){
                sum += (a*Math.pow(r,j)) % 7;
                if(sum % 7 == total){
                    res = j+1;
                    break;
                }
            }
            System.out.println(res);
        }
    }


}
