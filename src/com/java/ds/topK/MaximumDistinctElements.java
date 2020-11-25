package com.java.ds.topK;

import java.util.*;

public class MaximumDistinctElements {
/*
    Given an array of numbers and a number ‘K’, we need to remove ‘K’ numbers from the array such that we are left with maximum distinct numbers.

    Input: [7, 3, 5, 8, 5, 3, 3], and K=2
    Output: 3
    Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8], we have
    to skip 5 because it is not distinct and occurred twice.

    Another solution could be to remove one instance of '5' and '3' each to be left with three
    distinct numbers [7, 5, 8], in this case, we have to skip 3 because it occurred twice.


    ALGO

    1. First, we will find the frequencies of all the numbers.
    2. Then, push all numbers that are not distinct (i.e., have a frequency higher than one) in a Min Heap based on their frequencies.
        At the same time, we will keep a running count of all the distinct numbers.
    3. Following a greedy approach, in a stepwise fashion, we will remove the least frequent number from the heap (i.e., the top element of the min-heap),
     and try to make it distinct. We will see if we can remove all occurrences of a number except one.
     If we can, we will increment our running count of distinct numbers. We have to also keep a count of how many removals we have done.

    4. If after removing elements from the heap, we are still left with some deletions, we have to remove some distinct elements.

 */

    public static int findMaximumDistinctElements(int[] nums, int k) {
        int distinctElementsCount = 0;
        if (nums.length <= k) {
            return distinctElementsCount;//because all will be deleted
        }

        // find the frequency of each number
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int i : nums) {
            numFrequencyMap.put(i, numFrequencyMap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        // insert all numbers with frequency greater than '1' into the min-heap
        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                distinctElementsCount++;
            } else {
                minHeap.add(entry);
            }
        }
        // following a greedy approach, try removing the least frequent numbers first from the min-heap
        while (k > 0 && !minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            // to make an element distinct, we need to remove all of its occurrences except one
            k -= entry.getValue() - 1; //keep one and remove rest
            if (k >= 0) {
                distinctElementsCount++;
            }
        }

        // if k > 0, this means we have to remove some distinct numbers
        if (k > 0) {
            distinctElementsCount -= k;
        }

        return distinctElementsCount;
    }


}
