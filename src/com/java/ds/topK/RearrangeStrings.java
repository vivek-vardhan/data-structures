package com.java.ds.topK;

import java.util.*;

public class RearrangeStrings {
    /*
    Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.

    Input: "Programming"
    Output: "rgmrgmPiano" or "gmringmrPoa" or "gmrPagimnor", etc.
    Explanation: None of the repeating characters come next to each other.

    Input: "aapa"
    Output: ""
    Explanation: In all arrangements of "aapa", atleast two 'a' will come together e.g., "apaa", "paaa".


    ALGO:
    1. first append the most frequent characters to the output strings, for which we can use a Max Heap
        By appending the most frequent character first, we have the best chance to find a string where no two same characters come next to each other.
    2. In each step, we should append one occurrence of the highest frequency character to the output string.
        We will not put this character back in the heap to ensure that no two same characters are adjacent to each other.
    3. In the next step, we should process the next most frequent character from the heap in the same way and then,
        at the end of this step, insert the character from the previous step back to the heap after decrementing its frequency.

     */

    public static String rearrangeString(String str) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : str.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());

        // add all characters to the max heap
        maxHeap.addAll(charFrequencyMap.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder resultString = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            // add the previous entry back in the heap if its frequency is greater than zero
            if (previousEntry != null && previousEntry.getValue() > 0) {
                maxHeap.add(previousEntry);

            }
            // append the current character to the result string and decrement its count
            resultString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry = currentEntry;
        }
        // if we were successful in appending all the characters to the result string, return it
        return resultString.length() == str.length() ? resultString.toString() : "";

    }


}
