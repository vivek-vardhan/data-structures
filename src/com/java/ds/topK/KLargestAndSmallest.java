package com.java.ds.topK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestAndSmallest {

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // put first 'K' numbers in the min heap
        for (int i = 0; i < k; i++)
            minHeap.add(nums[i]);

        // go through the remaining numbers of the array, if the number from the array is bigger than the
        // top (smallest) number of the min-heap, remove the top number from heap and add the number from array
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        // the heap has the top 'K' numbers, return them in a list
        return new ArrayList<>(minHeap);
    }

    public static List<Integer> findKSmallestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // put first 'K' numbers in the min heap
        for (int i = 0; i < k; i++)
            maxHeap.add(nums[i]);

        // go through the remaining numbers of the array, if the number from the array is lesser than the
        // top (largest of k) number of the max-heap, remove the top number from heap and add the number from array
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        // the heap has the top 'K' numbers, return them in a list
        return new ArrayList<>(maxHeap);
    }

    public static Integer findKThLargestNumbersInStream(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
