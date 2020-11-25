package com.java.ds.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class CycleInCircleArray {

    static int mod(int a, int b){
        int c = a % b;
        return (c < 0) ? c + b : c;
    }

    public static boolean circularArrayLoop(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        int len = nums.length;
        Integer idx = null;
        for ( int i = 0; i < len; ++i ) {
            // set starting point
            if (idx == null) {
                idx = i;
                visited.add(i);
            }
            int prevIdx = idx;
            idx += nums[idx];
            idx = mod(idx,len);
            // reset starting point
            if ( idx == prevIdx ) {
                idx = null;
                visited.clear();
            }
            // same direction case
            else if ((nums[idx] > 0 && nums[prevIdx] > 0) || (nums[idx] < 0 && nums[prevIdx] < 0)) {
                if (visited.contains(idx)) return true;
                visited.add(idx);
            }
            // reset starting point if direction has changed
            else {
                idx = null;
                visited.clear();
            }
        }
        return false;
    }

}
