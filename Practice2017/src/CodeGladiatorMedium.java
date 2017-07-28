import java.util.*;

/**
 * Created by Gaurav-PC on 01-04-2017.
 */
public class CodeGladiatorMedium {

    static Set<String> arr = new HashSet<>();

    public static int GetJumpCount(int input1, int input2, String input3, String input4) {
        //Write code here
        int res = 0;
        Set<String> arr1 = permutation("", input3);
        for (String s : arr1) {
            res += checkContains(s, input4);

        }
        return res;
    }

    /*public static int countSubstring(String subStr, String str) {
        return (str.length() - str.replace(subStr, "").length()) / subStr.length();
    }*/

    private static int checkContains(String input, String target) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < target.length(); i++) {
            boolean test = false;
            if (input.charAt(0) == target.charAt(i)) {
                temp = i;
                for (int j = 0; j < input.length(); j++) {
                    if (i < target.length() && input.charAt(j) != target.charAt(i)) {
                        test = false;
                        i = temp;
                        break;
                    } else if (i < target.length() && j < input.length()) {
                        i++;
                        test = true;
                    } else {
                        test = false;
                        i = temp;
                        break;
                    }
                }

            }
            if (test) {
                i = temp;
                temp = 0;
                count++;
            }
        }
        return count;

    }

    private static Set<String> permutation(String prefix, String str) {

        int n = str.length();
        if (n == 0)
            arr.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
        return arr;
    }

    public static void main(String[] args) {
        //String input3 = "acAd";
        //String input4 = "AbrAcadAbRa";
        String input3 = "ABCD";
        String input4 = "BACDGABCDA";
        int input1 = 5;
        int input2 = 1;
        //My code
        System.out.println(GetJumpCount(input1, input2, input3, input4));
        //Correct Soln
        System.out.println(findSubstring(input4, input3).size());
    }

    public static List<Integer> findSubstring(String str, String ptn){
        List<Integer> res = new LinkedList<Integer>();
        //
        int[] pntcnt = new int[256];

        int[] strcnt = new int[256];
        for(int i = 0; i < ptn.length(); i++){
            pntcnt[ptn.charAt(i)]++;
        }
        int i = 0;
        for(i = 0; i < ptn.length() && i < str.length(); i++){
            strcnt[str.charAt(i)]++;
        }
        if(isSame(pntcnt, strcnt)){
            res.add(i - ptn.length());
        }
        while(i < str.length()){
            //A new character, since the increase in the number of times
            strcnt[str.charAt(i)]++;

            //The number of characters leaving the window is reduced by one
            strcnt[str.charAt(i - ptn.length())]--;
            i++;
            // To determine whether the two arrays are the same
            if(isSame(pntcnt, strcnt)){
                res.add(i - ptn.length());
            }
        }
        return res;
    }

    public static boolean isSame(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length) return false;
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
