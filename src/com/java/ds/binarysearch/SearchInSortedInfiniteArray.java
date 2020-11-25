package com.java.ds.binarysearch;

public class SearchInSortedInfiniteArray {

    /*
    ALGO is to find the range where it can lie, keep doubling the array size





     */

    public static int search(int[] arr, int key) {

        int start = 0, end = 1;
        while (arr[end] < key) {
                int newStart = end +1;
                end = end + (end - start + 1) * 2; //increase by double
                start = newStart;
        }

        return binarySearch(arr, key, start, end); //now regular binary search

    }

    private static int binarySearch(int[] arr, int key, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else { // found the key
                return mid;
            }
        }

        return -1;
    }
}
