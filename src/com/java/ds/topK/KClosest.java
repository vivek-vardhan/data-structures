package com.java.ds.topK;

import java.util.*;

/**
 * Input: [5, 6, 7, 8, 9], K = 3, X = 7.. 3 numbers closest to 7
 * Output: [6, 7, 8]
 *
 */

class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}


public class KClosest {

    /**
     * ALGO
     * 1. sort the array
     * 2. Find closest to x  using binary search:  normal binary search for if exist or not, if not then check & compare with current start and end
     * 3. find k closest number both side in sorted array, use min heap to keep only k from both side
     *
     *
     */

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        int index = binarySearch(arr, X);


        int low = index - K, high = index + K;
        low = Math.max(low, 0); // 'low' should not be less than zero
        high = Math.min(high, arr.length - 1); // 'high' should not be greater the size of the array

        PriorityQueue<Entry> minHeap = new PriorityQueue<>(Comparator.comparing(Entry::getKey));
        // add all candidate elements to the min heap, sorted by their absolute difference from 'X'
        for (int i = low; i <= high; i++)
            minHeap.add(new Entry(Math.abs(arr[i] - X), i));

        // we need the top 'K' elements having smallest difference from 'X'
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < K; i++)
            result.add(arr[minHeap.poll().value]);

        Collections.sort(result);
        return result;
    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (low > 0) {
            return low - 1;
        }
        return low;
    }

}
