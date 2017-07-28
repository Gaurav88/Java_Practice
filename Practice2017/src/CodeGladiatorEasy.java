/**
 * Created by Gaurav-PC on 26-03-2017.
 */
public class CodeGladiatorEasy {

    static int res = 0;

    public static int GetJumpCount(int input1, int input2, int[] input3) {
        //Write code here
        for (int i = 0; i < input3.length; i++) {
            calculate(input1, input2, input3[i]);
        }
        return res;
    }

    public static void calculate(int input1, int input2, int height) {
        while (height > 0) {
            res++;
            height -= input1;
            if (height > 0) {
                height += input2;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {9,10};
        int input1 = 5;
        int input2 = 1;
        System.out.println(GetJumpCount(input1, input2, arr));
    }
}
