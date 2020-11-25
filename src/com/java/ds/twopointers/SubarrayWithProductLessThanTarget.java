package com.java.ds.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubarrayWithProductLessThanTarget {
    /*

    Input: [2, 5, 3, 10], target=30
    Output: [2], [5], [2, 5], [3], [5, 3], [10]
    Explanation: There are six contiguous subarrays whose product is less than the target.

     */

    public static List<List<Integer>> findSubarrays(int[] arr, int target) {  //O(n*n*n), Space = O(n*n)
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int product = 1, start = 0;
        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];

            //if product is high, increase start to decrease the product

            while (product >= target && start < arr.length) {
                product /= arr[start++];
            }
            List<Integer> tempList = new LinkedList<>();
            //all elements from i to start will constitute this subarray
            for (int j = i; j >= start; j--) {
                tempList.add(0, arr[j]);
                result.add(new ArrayList<>(tempList));
            }

        }
        return result;

    }
}
