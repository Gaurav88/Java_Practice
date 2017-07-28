import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Gaurav-PC on 07-05-2017.
 */
public class NextSmallElement {

    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        ArrayList<Integer> op = new ArrayList<Integer>();
        Stack<Integer> S = new Stack<Integer>();
        int n= arr.size();
        // Traverse all array elements
        for (int i=0; i<n; i++)
        {
            // Keep removing top element from S while the top
            // element is greater than or equal to arr[i]
            while (!S.empty() && S.peek() >= arr.get(i))
                S.pop();

            // If all elements in S were greater than arr[i]
            if (S.empty())
                op.add( -1);
            else  //Else print the nearest smaller element
                op.add(S.peek() );

            // Push this element
            S.push(arr.get(i));
        }


        return op;
    }

    public static void main(String args[]){

        Integer input[] = {2,2,2,6,1,5,4,2,2,2,2};
        ArrayList<Integer> arr =  new ArrayList<Integer> (Arrays.asList(input));
        ArrayList<Integer> op = prevSmaller(arr);
        for(int i : op){
            System.out.print(i);
            System.out.print(" ");
        }

    }
}
