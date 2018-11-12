package SortingAndSearching;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        /*
        The following is using a PriorityQueue.
        Does not temper original input but has high space complexity of O(n).

        if (intervals == null || intervals.size() <= 1) return intervals;

        PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.start));
        pq.addAll(intervals);

        List<Interval> mergedList = new LinkedList<>();
        while (pq.size() > 1) {
            Interval i1 = pq.poll();
            Interval i2 = pq.poll();
            if (i1.end >= i2.start) {
                //in range, ex) [[1,3], [2,6]] => pq.offer([1,6])
                pq.offer(new Interval(i1.start, Math.max(i1.end, i2.end)));
            }
            else {
                //not in range, ex) [[1,6], [8,10]] => mergedList.add([1,6]) && pq.offer([8,10])
                mergedList.add(i1);
                pq.offer(i2);
            }
        }
        if (!pq.isEmpty()) mergedList.add(pq.poll());
        return mergedList;
        */

        if (intervals == null || intervals.size() <= 1) return intervals;
        intervals.sort(Comparator.comparing(i -> i.start));

        List<Interval> mergedList = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (end >= interval.start) {
                end = Math.max(end, interval.end);
            }
            else {
                mergedList.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        mergedList.add(new Interval(start, end));
        return mergedList;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));

        List<Interval> mergedList = merge(intervals);
        for (Interval interval : mergedList) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }
}
