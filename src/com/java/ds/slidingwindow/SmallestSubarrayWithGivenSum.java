package com.java.ds.slidingwindow;

/**
 *
 *  find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 *
 *  1. Find sum till it become >=S, once it become greater, remove element from start of window till sum become less
 *
 *
 *
 */
public class SmallestSubarrayWithGivenSum {

    public int smallestSubArrayWithGivenSum(int sum, int arr[]) {
        int start = 0;
        int curSum = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            curSum += arr[i];
            while (curSum >= sum) {
                minLength = Math.min(minLength, i - start + 1);
                curSum = curSum - arr[start];
                start++;//reduce window by increasing start of window
            }
        }

        return minLength;

    }
}
