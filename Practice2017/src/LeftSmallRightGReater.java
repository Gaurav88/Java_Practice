/**
 * Created by Gaurav-PC on 17-04-2017.
 * Given an array, find an element before which all elements are smaller than it, and after which all are greater than it.
 * Return index of the element if there is such an element, otherwise return -1.
 *
 1) Create two arrays leftMax[] and rightMin[].
 2) Traverse input array from left to right and fill leftMax[] such that leftMax[i] contains maximum element from 0 to i-1 in input array.
 3) Traverse input array from right to left and fill rightMin[] such that rightMin[i] contains minimum element from to n-1 to i+1 in input array.
 4) Traverse input array. For every element arr[i], check if arr[i] is greater than leftMax[i] and smaller than rightMin[i]. If yes, return i.
 */
public class LeftSmallRightGReater {

    static int findElement(int arr[], int n)
    {
        // leftMax[i] stores maximum of arr[0..i-1]
        int leftMax[] = new int[n];
        leftMax[0] = Integer.MIN_VALUE;

        // Fill leftMax[]1..n-1]
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i-1], arr[i-1]);

        // Initialize minimum from right
        int rightMin = Integer.MAX_VALUE;

        // Traverse array from right
        for (int i=n-1; i>=0; i--)
        {
            // Check if we found a required element
            if (leftMax[i] < arr[i] && rightMin > arr[i])
                return i;

            // Update right minimum
            rightMin = Math.min(rightMin, arr[i]);
        }

        // If there was no element matching criteria
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        int input2=5;
        int input3 =3;
        System.out.println(findElement(arr,arr.length));
    }
}
