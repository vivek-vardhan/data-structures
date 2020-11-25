package com.java.ds.twopointers;

import java.util.*;

public class QuadrupleSumToTarget {
    //Just an extension of triplet sum to 0
    //Change is: doing low/high with every i, do it for every i and j

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> quadruplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) { // skip same element to avoid duplicate quadruplets
                continue;
            }
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) { // skip same element to avoid duplicate quadruplets
                    continue;
                }
                int left = j + 1;
                int right = arr.length - 1;
                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum == target) { // found the quadruplet
                        quadruplets.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;
                        while (left < right && arr[left] == arr[left - 1]) {
                            left++; // skip same element to avoid duplicate quadruplets
                        }
                        while (left < right && arr[right] == arr[right + 1]) {
                            right--; // skip same element to avoid duplicate quadruplets
                        }
                    } else if (sum < target)
                        left++; // we need a pair with a bigger sum
                    else
                        right--; // we need a pair with a smaller sum
                }
            }
        }
        return quadruplets;
    }
}
