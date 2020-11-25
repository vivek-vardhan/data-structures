package com.java.ds.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerSum {

    //All triplets with smaller sum
    public List<List<Integer>> searchTriplets (int[] nums, int target) {

        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i=0;i<nums.length-2;i++) {
            int j = i+1;
            int end = nums.length - 1;
            while (j < end) {
                int current = nums[i] + nums[j] + nums[end];
                if (current < target) { //if need to find only count:[count+=end - j]
                    for ( int k=j+1; k <=end; k++) {//all these will be smaller  IMPORTANT,  //starting from j+1 to end, all elements are smaller.
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]); //1st element is of i loop
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        list.add(triplet);
                    }
                    j++;
                }
                else {
                    end--;
                }
            }
        }

        return list;

    }
}
