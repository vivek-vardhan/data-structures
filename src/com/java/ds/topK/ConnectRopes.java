package com.java.ds.topK;

import java.util.PriorityQueue;

/**
 *
 * Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
 * The cost of connecting two ropes is equal to the sum of their lengths.
 *
 */
public class ConnectRopes {

    /*

    Logic is: Keep adding, and add th sum to its closest value and so on
    .. So, its heap.. Min heap.. smallest top
     */

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        // add all ropes to the min heap
        for (int i = 0; i < ropeLengths.length; i++)
            minHeap.add(ropeLengths[i]);

        // go through the values of the heap, in each step take top (lowest) rope lengths from the min heap connect them
        // and push the result back to the min heap.

        // keep doing this until the heap is left with only one rope
        int result = 0, temp = 0;
        while (minHeap.size() > 1) {
            temp = minHeap.poll() + minHeap.poll();
            result += temp;
            minHeap.add(temp);
        }

        return result;
    }
}
