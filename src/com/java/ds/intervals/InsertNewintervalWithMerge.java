package com.java.ds.intervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *
 * Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
 * Output: [[1,3], [4,7], [8,12]]
 * Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
 *
 *
 *
 *
 */
public class InsertNewintervalWithMerge {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty())
            return Arrays.asList(newInterval);

        List<Interval> mergedIntervals = new ArrayList<>();

        //move till start of sorted intervals

        int i = 0;
        while (i < intervals.size() && intervals.get(i).getEnd() < newInterval.getStart()) {
            mergedIntervals.add(intervals.get(i));//not  overlapping case
            i++;
        }
        //merge overlapping, keep updating the new
        while (i < intervals.size() && intervals.get(i).getStart() <= newInterval.getEnd()) {
            newInterval.setStart(Math.min(newInterval.getStart(), intervals.get(i).getStart())); //Jiska chhota min ho, keep that
            newInterval.setEnd(Math.max(newInterval.getEnd(), intervals.get(i).getEnd())); //Jiska bada end ho  keep that
            i++;
        }
        mergedIntervals.add(newInterval);

        //add remaining
        while (i < intervals.size()) {
            mergedIntervals.add(intervals.get(i));
            i++;
        }
        return mergedIntervals;

    }
}
