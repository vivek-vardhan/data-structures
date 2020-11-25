package com.java.ds.binarysearch;

public class CeilingOfNumber {
    /**
     *
     *
     *  The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
     *
     * - Can be applied to array of characters too - new char[] { 'a', 'c', 'f', 'h' }, 'b')); : C will be the answer
     */

    public static int searchCeilingOfANumber(int[] arr, int key) {
        if (key > arr[arr.length - 1]) { // if the 'key' is bigger than the biggest element
            return -1;
        }
        int start = 0, end = arr.length - 1;
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
        //At end of loop, eventally START will be the position which will be just greater than number (START == END +1)
        return start;

        /**
         *
         * If we had to return minimum distance, then check whose difference is less
         *  iff ((arr[start] - key) < (key - arr[end])) { means difference is near to start} - return start: else return end
         *
         *
         */
    }
}
