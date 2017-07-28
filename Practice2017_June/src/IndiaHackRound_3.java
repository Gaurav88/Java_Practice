import java.util.*;

/**
 * Created by Gaurav-PC on 23-07-2017.
 */

/**
 * There are
 N people who want to donate blood. Each person has a unique health level
 Hi. Instead of attending to each person one by one, the blood bank thought of a new way to make the whole process of blood donation faster.
 Consider all people standing in a line from left to right. People will be divided in groups. Initially there is only one group with all people in it. Every second,
 person with the highest health level in each group will leave the group, donate blood and go home.
 After a person leaves a group, all the people to the left of him in the same group (if any) form another group and all the people to the right of him in the same group (if any) form another group.
 For each second, until at least one person remains, you need to tell the sum of health levels of all people that donated blood.
 Input:

 First line of input contains an integer
 N, denoting the number of people who want to donate blood. Next line contains
 N space separated integers
 i
 Hi, denoting the health level of each person.

 Output:

 Print
 X integers, each on a new line, where
 X is the maximum time till which there is at least one person who hasn't gone home.
 ith integer represents the sum of health level of all persons who donated blood in the
 ith second.

 5
 3 5 4 2 1

 SAMPLE OUTPUT
 5
 7
 2
 1
 */
public class IndiaHackRound_3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        long arr[] = new long[N];
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            long num = s.nextInt();
            list.add(num);
            arr[i] = num;
        }
        Queue<List<Long>> queue = new LinkedList<>();
        Long max = sum(list, queue);
        System.out.println(max);
        while (!queue.isEmpty()) {
            max = Long.valueOf(0);
            Queue<List<Long>> st = copy(queue);
            while (!st.isEmpty()) {
                queue.poll();
                max += sum(st.poll(), queue);
                //max += sum(queue.poll(), st);
            }
            System.out.println(max);
        }
    }

    private static Long sum(List<Long> arr, Queue<List<Long>> queue) {
        int max = findMax(arr);
        Long res = arr.get(max);
        List<Long> temp1 = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            temp1.add(arr.get(i));
        }
        if (temp1.size() > 0) {
            queue.add(temp1);
        }
        List<Long> temp2 = new ArrayList<>();
        for (int i = max + 1; i < arr.size(); i++) {
            temp2.add(arr.get(i));
        }
        if (temp2.size() > 0) {
            queue.add(temp2);
        }
        return res;
    }

    private static int findMax(List<Long> arr) {
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(max)) {
                max = i;
            }
        }
        return max;
    }

    private static Queue<List<Long>> copy(Queue<List<Long>> q) {
        Queue<List<Long>> queue = new LinkedList<>();
        for (List<Long> l : q) {
            queue.add(l);
        }
        return queue;
    }
}
