package com.java.ds.twopointers;

public class MinimumWindowSort {
    /*

    Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

    Input: [1, 3, 2, 0, -1, 7, 10]
    Output: 5
    Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted



    1. From the beginning and end of the array, find the first elements that are out of the sorting order. The two elements will be our candidate subarray.
    2. Find the maximum and minimum of this subarray.
    3. Extend the subarray from beginning to include any number which is bigger than the minimum of the subarray.
    4. Similarly, extend the subarray from the end to include any number which is smaller than the maximum of the subarray.
     */

    public static int sort(int[] arr) {
        int low = 0, high = arr.length - 1;
        // find the first number out of sorting order from the beginning
        while (low < arr.length - 1 && arr[low] <= arr[low + 1]) {
            low++;
        }

        if (low == arr.length - 1) { // if the array is sorted
            return 0;
        }

        // find the first number out of sorting order from the end
        while (high > 0 && arr[high] >= arr[high - 1]) {
            high--;
        }

        // find the maximum and minimum of the subarray
        int subarrayMax = Integer.MIN_VALUE, subarrayMin = Integer.MAX_VALUE;
        for (int k = low; k <= high; k++) {
            subarrayMax = Math.max(subarrayMax, arr[k]);
            subarrayMin = Math.min(subarrayMin, arr[k]);
        }

        // extend the subarray to include any number which is bigger than the minimum of the subarray
        while (low > 0 && arr[low - 1] > subarrayMin) {
            low--;
        }

        // extend the subarray to include any number which is smaller than the maximum of the subarray
        while (high < arr.length - 1 && arr[high + 1] < subarrayMax) {
            high++;
        }

        return high - low + 1;
    }
}
