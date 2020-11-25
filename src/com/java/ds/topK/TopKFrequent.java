package com.java.ds.topK;

import java.util.*;

public class TopKFrequent {
    /*

    It will be same, but we need to maintain frequency.So, map.. and PQ will use the map


     */

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        // find the frequency of each number
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int n : nums) {
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);
        }


        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());

        // go through all numbers of the numFrequencyMap and push them in the minHeap, which will have
        // top k frequent numbers. If the heap size is more than k, we remove the smallest (top) number
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // create a list of top k numbers
        List<Integer> topNumbers = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }
        return topNumbers;
    }

}
