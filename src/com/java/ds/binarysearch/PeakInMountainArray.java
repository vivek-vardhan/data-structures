package com.java.ds.binarysearch;

public class PeakInMountainArray {

    /**
     *
     * Input: [1, 3, 8, 12, 4, 2]
     * Output: 12
     * Explanation: The maximum number in the input bitonic array is '12'.
     *
     */

    /*
    ALGO:

    if arr[middle] > arr[middle + 1] : We are in the second (descending) part,  mid can be the answer, so end = mid, it may decrease
    if arr[middle] < arr[middle + 1] : We are in the first (ascending) part, //so, atleast mid+1 will be the answer
     */

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) { //we are in descending part, mid can be the answer, so end = mid
                end = mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                return start;
            }
        }
        return start;
    }

    public int searchInMountainArray(int[] arr, int key) {
        /*
            AlGO:
            1. Find peak
            2. Divide in two halves from there
            3. perform binary search from there
         */

        int maxIndex = peakIndexInMountainArray(arr);
        int keyIndex = binarySearch(arr, key, 0, maxIndex);
        if (keyIndex != -1)
            return keyIndex;
        return binarySearch(arr, key, maxIndex + 1, arr.length - 1);
    }

    private static int binarySearch(int[] arr, int key, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key == arr[mid]) {
                return mid;
            }

            if (arr[start] < arr[end]) { // ascending order
                if (key < arr[mid]) {
                    end = mid - 1;
                } else { // key > arr[mid]
                    start = mid + 1;
                }
            } else { // descending order
                if (key > arr[mid]) {
                    end = mid - 1;
                } else { // key < arr[mid]
                    start = mid + 1;
                }
            }
        }
        return -1; // element is not found
    }
}
