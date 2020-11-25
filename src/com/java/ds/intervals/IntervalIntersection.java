package com.java.ds.intervals;

import java.util.*;

/**
 *
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists
 *
 *
 */
public class IntervalIntersection {

    public static Interval[] intersection(Interval[] arr1, Interval[] arr2) {

        List<Interval> result = new ArrayList<Interval>();

        int i=0,j=0;

        while ( i < arr1.length && j< arr2.length) {
            //Check for intersection
            Interval first = arr1[0];
            Interval sec = arr2[0];
            if (first.getStart() <= sec.getStart()  && sec.getStart() <= first.getEnd()
            || first.getStart() >= sec.getStart() && sec.getEnd() >= first.getStart()) {
                result.add(new Interval(Math.max(first.getStart(), sec.getStart()), Math.min(first.getEnd(), sec.getEnd())));
            }
            //Move to next from wchich is ending first
            if (first.getEnd() < sec.getEnd() ) {
                i++;
            } else {
                j++;
            }

        }
        return result.toArray(new Interval[result.size()]);

    }
}
