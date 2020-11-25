package com.java.ds.cyclicsort;

public class CyclicSort {
    /**
     *
     * Input: [3, 1, 5, 4, 2]
     * Output: [1, 2, 3, 4, 5] > Sort in place in O(n) using cyclic sort
     *
     * ALGO
     * 1. start from 0th index
     * 2. Keep swapping number to its correct index
     *
     */

    public void sort(int[] nums) {
        int i=0;
        while (i < nums.length) {
            int correctPosition = nums[i] -1; //example: 3, it shouls be aty index 2
            if (nums[i] != nums[correctPosition]) { //nums[2] is not 3, so, swap, nums[2] is now 3
                swap(nums, i, correctPosition);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
