package com.java.ds.topK;

import java.util.*;

public class ReArrangeKDistanceApart {
    /*
    Input: "mmpp", K=2
    Output: "mpmp" or "pmpm"
    Explanation: All same characters are 2 distance apart.

    Input: "Programming", K=3
    Output: "rgmPrgmiano" or "gmringmrPoa" or "gmrPagimnor" and a few more
    Explanation: All same characters are 3 distance apart.


    ALGO: Similar to re-arramge strings, just maintain a Queue of prev entries, with size = k
     */

    public static String reorganizeString(String str, int k) {
        if (k <= 1) {
            return str;
        }
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : str.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());

        // add all characters to the max heap
        maxHeap.addAll(charFrequencyMap.entrySet());


        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder resultString = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            // append the current character to the result string and decrement its count
            resultString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            queue.add(currentEntry);
            if (queue.size() == k) {
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0) {
                    maxHeap.add(entry);
                }
            }
        }

        // if we were successful in appending all the characters to the result string, return it
        return resultString.length() == str.length() ? resultString.toString() : "";
    }
}
