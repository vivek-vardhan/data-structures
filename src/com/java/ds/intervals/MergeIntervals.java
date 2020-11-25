package com.java.ds.intervals;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
 *
 *ALGO:
 * 1. Sort the intervals by start time
 * 2. Start merging based on end times < start times
 *
 */
public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <2) {
            return intervals;
        }
        //Sort by start time
//        Collections.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start.compareTo(o2.start);
//
//            }
//        });
        Collections.sort(intervals, (o1, o2) -> Integer.compare(o1.getStart(), o2.getStart()));

        List<Interval> mergedIntervals = new LinkedList<>();

        //Get 1st interval
        Interval currentInterval = intervals.get(0);
        int currentStart = currentInterval.getStart();
        int currentEnd = currentInterval.getEnd();
        for (int i =1;i <intervals.size();i++) {
            Interval nextInterval = intervals.get(i);
            //if this intervals start < end of prev, merge
            if (nextInterval.getStart() < currentEnd) {
                currentEnd = Math.max(nextInterval.getEnd(), currentEnd); //Make whichever is higher as new end
            } else {
                //Non overlapping interval, add to linkedList
                mergedIntervals.add(new Interval(currentStart, currentEnd));
                currentStart = nextInterval.getStart();
                currentEnd = nextInterval.getEnd();
            }

        }

        return mergedIntervals;

    }
}
