package com.java.ds.slidingwindow;

public class LongestSubarrWithOnesAfterReplace {
    /*
    Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
    find the length of the longest contiguous subarray having all 1s.


    Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
    Output: 9
    Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
     */

    public static int findLength(int[] arr, int k) {
        int start = 0, maxLength = 0, maxOnesCount = 0;
        // try to extend the range [start, windowEnd]
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                maxOnesCount++;

            // current window size is from start to i, overall we have a maximum of 1s repeating a maximum of 'maxOnesCount' times,
            // this means that we can have a window with 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s.
            // now, if the remaining 0s are more than 'k', it is the time to shrink the window
            // as we are not allowed to replace more than 'k' Os
            if (i - start + 1 - maxOnesCount > k) {
                if (arr[start] == 1)
                    maxOnesCount--;
                start++;
            }

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}
