package com.java.ds.twopointers;

public class SortArrayWith01And2 {
    /*
    Input: [1, 0, 2, 1, 0]
    Output: [0 0 1 1 2]
     */

    public static void sort(int[] arr) {
        // low for adding 0s, and high for adding 1s
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high;) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else { // the case for arr[i] == 2
                swap(arr, i, high);
                // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
