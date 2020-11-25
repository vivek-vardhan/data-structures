package com.java.ds.topK;

import java.util.*;

public class SchedulingTasks {
    /*

    You are given a list of tasks that need to be run, in any order, on a server.

    Each task will take one CPU interval to execute but once a task has finished, it has a cooling period during which it can’t be run again.

    If the cooling period for all tasks is ‘K’ intervals, find the minimum number of CPU intervals that the server needs to finish all tasks.


    Input: [a, a, a, b, c, c], K=2
    Output: 7
    Explanation: a -> c -> b -> a -> c -> idle -> a

    Input: [a, b, a], K=3
    Output: 5
    Explanation: a -> b -> idle -> idle -> a
     */

    public static int scheduleTasks(char[] tasks, int k) {



        Map<Character, Integer> taskFrequencyMap = new HashMap<>();
        for (char chr : tasks) {
            taskFrequencyMap.put(chr, taskFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());

        // add all tasks to the max heap
        maxHeap.addAll(taskFrequencyMap.entrySet());

        int intervalCount = 0;

        while (!maxHeap.isEmpty()) {
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();//task which will be waited
            int n = k+1;
            for (; n > 0 && !maxHeap.isEmpty(); n--) { //try to execute as many as 'k+1' tasks from the max-heap if  possible, one task can't be repeated as wait tine needed
                intervalCount++;
                Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
                if (currentEntry.getValue() > 1) {
                    currentEntry.setValue(currentEntry.getValue() - 1);
                    waitList.add(currentEntry);
                }
            }
            maxHeap.addAll(waitList); // put all the waiting list back on the heap
            if (!maxHeap.isEmpty()) {
                intervalCount += n; // we'll be having 'n' idle intervals for the next iteration
            }
        }
        return intervalCount;
    }
}
