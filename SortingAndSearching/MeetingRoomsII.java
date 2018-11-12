package SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

 Example 1:

 Input: [[0, 30],[5, 10],[15, 20]]
 Output: 2
 Example 2:

 Input: [[7,10],[2,4]]
 Output: 1
 */
public class MeetingRoomsII {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static int minMeetingRooms(Interval[] intervals) {

        /*
        pseudo code:
            [[4,7],[6,10],[9,12]]
            if i1.end > i2.start
                need room, pq.offer(i2)
            else
                dont need room, update i1's end
            pq.offer(i1);
         */

        if (intervals == null) return 0;
        if (intervals.length <= 1) return intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

        PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length, Comparator.comparingInt(i -> i.end));
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = pq.poll();
            if (interval.end > intervals[i].start) {
                pq.offer(intervals[i]);
            }
            else {
                interval.end = Math.max(interval.end, intervals[i].end);
            }
            pq.offer(interval);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(4,7);
        intervals[1] = new Interval(6,10);
        intervals[2] = new Interval(9,12);

        System.out.println(minMeetingRooms(intervals));
    }
}
