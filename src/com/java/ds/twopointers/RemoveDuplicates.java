package com.java.ds.twopointers;

import java.util.Arrays;
//0 0 0 0 1 1 2  2 3  4 4 4 5
// 1 2 3 4 5

public class RemoveDuplicates {

    public int giveCountAfterRemovingDuplicates(int[] nums) {
        Arrays.sort(nums);
        int count  = 0, next = 1;
        for ( int i =0 ;i < nums.length;) {
            count++;
            while (next < nums.length &&  nums[i] == nums[next] ) {
                next++;
            }
            i = next;
            next = next+1;
        }
        return count;
    }

    public int removingDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        //keep 1 pointer for nonDuplicates
        //and another for traversinf

        int i = 0;
        for (int j = 1; j <  nums.length; j++) {
                if (nums[i] != nums[j]) { //if element is not same, means i can be increased to next, current i was unique
                    i++;
                    nums[i] = nums[j];//switch to next element
                }
        }

        return i+1;
    }
}
