package com.java.ds.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumZero {


    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> answers = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i< nums.length -2;i++) {
            if (i > 0 && nums[i] == nums[i-1]) {// to avoid duplicates
                continue;
            }
            int start = i+1;
            int end = nums.length -1;
            int targetSum = 0 - nums[i];

            while (start < end) {
                int currentSum = nums[start] + nums[end];
                if (currentSum == targetSum) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[start]);
                    triplet.add(nums[end]);
                    answers.add(triplet);
                    start++;
                    end--;
                    //Skip duplicates here too - Important
                    // if (nums[start] == nums[start - 1]) {
                    //     start++;
                    // }
                    // if (nums[end] == nums[end + 1]) {
                    //     end--;
                    // }
                    //If will not work as it will not be able to handle double repeatitions
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }


                } else if (currentSum < targetSum) {
                    start++;
                } else {
                    end--;
                }
            }


        }
        return answers;

    }
}
