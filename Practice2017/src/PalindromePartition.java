import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gaurav-PC on 28-05-2017.
 */
//GOLDMAN SACHS Test
/*calculate no of possible Combination of  String formed from given no
    e.g 2112
    (2)(1)(1)(2), (21)(1)(2), (21)(12),(2)(11)(2), (2)(1)(12)
    */
public class PalindromePartition {
    //private int isPalin[][];
    private int N;
    private ArrayList<ArrayList<String>> mRes;
    private String mString;

    public ArrayList<ArrayList<String>> partition(String A) {

        mRes = new ArrayList<>();
        N = A.length();
        if (N == 0)
            return null;

        mString = A;

        ArrayList<String> str = new ArrayList<>();

        rec(str, 0);
        return mRes;

    }

    public void rec(ArrayList<String> str, int index) {

        if (index == N) {
            mRes.add(new ArrayList(str));
            return;
        }
        for (int i = index; i < N; i++) {

            str.add(mString.substring(index, i + 1));
            rec(str, i + 1);
            str.remove(str.size() - 1);

        }


    }

    static long calculatePossibleCombination(String input) {
        ArrayList<ArrayList<String>> list = new PalindromePartition().partition(input);
        long res = 0;
        for (ArrayList<String> l : list) {
            int count = 1;
            for (String s : l) {
                if (Integer.parseInt(s) > 26 || Integer.parseInt(s) == 0 || s.startsWith("0")) {
                    break;
                }
                if (count == l.size()) {
                    res++;
                }
                count++;
            }
        }
        return res;
    }

    public static void main(String... args) {
        System.out.println(calculatePossibleCombination("2101"));
    }

}
