package com.java.ds.slidingwindow;

/**
 *
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 *
 */
public class MaxSubarraySumSizeK {

    public int maxSubArraySumSizeK(int k, int arr[]) {
        int curMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i =0 ; i< k;i++) {
            sum+=arr[i];
            curMax = sum > curMax ? sum : curMax;
        }
        //Slide window now
        for (int i=k;i <arr.length;i++) {
            sum = sum + arr[i] - arr[i-k];
            curMax = sum > curMax ? sum : curMax;
        }

        return curMax;

    }
 }
