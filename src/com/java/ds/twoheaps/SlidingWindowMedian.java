package com.java.ds.twoheaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    /**
     *
     * Its  similar to median in streams: with number will keep getting removed and added after k length
     *
     *
     *
     *
     */

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());; //containing first half of numbers of k
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();; //containing second half of numbers

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];

        int indexInResult = 0;
        for (int i = 0; i < nums.length; i++) {
            //exact same logic as before
            if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            rebalance();

            //Now if K elements reached then generate medians and slide window
            if (i > k) {
                //generate median
                //size are same then average of top of heaps
                if (maxHeap.size() == minHeap.size()) {
                    result[indexInResult] = ( maxHeap.peek() + minHeap.peek())/2;
                } else {
                    result[indexInResult] = maxHeap.peek();
                }

                //Now slide the window
                int elementToBeRemoved = nums[indexInResult];
                if (elementToBeRemoved <= maxHeap.peek()) { //If element is less than maxHeap top
                    maxHeap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }
                rebalance();
                indexInResult++;
            }

        }

        return result;

    }

    private void rebalance() {
        // either both the heaps will have equal number of elements or max-heap will have one more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

}
