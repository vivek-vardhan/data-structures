package com.java.ds.twopointers;

import java.util.Arrays;

public class PairWithTargetSum {

    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                return new int[]{start, end};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[] { -1, -1 };
    }
}
