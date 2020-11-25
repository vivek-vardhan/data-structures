package com.java.ds.twopointers;

import java.util.Arrays;

public class TripletSumClosestToTarget {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int nearest = nums[0] + nums[1] + nums[2];

        for (int i=0;i<nums.length-2;i++) {
            int j = i+1;
            int end = nums.length - 1;
            while (j < end) {
                int current = nums[i] + nums[j] + nums[end];
                if (Math.abs(target - current) < Math.abs(target - nearest)) {
                    nearest = current;
                }
                if (current > target) {
                    end--;
                } else {
                    j++;
                }
            }
        }

        return nearest;

    }
}
