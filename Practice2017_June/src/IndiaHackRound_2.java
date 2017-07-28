import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Gaurav-PC on 23-07-2017.
 */
//http://www.programcreek.com/2014/05/leetcode-meeting-rooms-ii-java/
    /*INput :-
    6
1 0 2 0
16 0 21 30
9 30 13 0
21 30 22 30
21 30 22 30
12 0 12 30

O/P :- 3
     */
public class IndiaHackRound_2 {

    private static String util(int n) {
        if (n < 10) {
            return Integer.toString(0) + Integer.toString(n);
        }
        return Integer.toString(n);
    }

    public static int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        int count = 1;
        queue.offer(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start <= queue.peek()) {
                count++;

            } else {
                queue.poll();
            }

            queue.offer(intervals[i].end);
        }

        return count;
    }

    public static void main1(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        //int arr[] = new int[N];
        //int dep[] = new int[N];
        Interval[] intervals = new Interval[N];
        for (int i = 0; i < N; i++) {
            Interval interval = new Interval();
            int a = s.nextInt();
            int b = s.nextInt();
            /*if (a == 0) {
                a = 24;
            }*/
            int t1 = Integer.parseInt(util(a) + util(b));
            interval.start = t1;
            int c = s.nextInt();
            int d = s.nextInt();
            /*if (c == 0) {
                c = 24;
            }*/
            int t2 = Integer.parseInt(util(c) + util(d));
            interval.end = t2;
            intervals[i] = interval;
        }
        int res = minMeetingRooms(intervals);
        System.out.println(res);
    }
}

class Interval {

    public int start;
    public int end;
}