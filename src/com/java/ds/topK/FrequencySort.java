package com.java.ds.topK;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    /*
    Given a string, sort it based on the decreasing frequency of its characters.


    Input: "Programming"
    Output: "rrggmmPiano"
    Explanation: 'r', 'g', and 'm' appeared twice, so they need to appear before any other character.
*/


    public static String sortCharacterByFrequency(String str) {
        // find the frequency of each character
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for (char chr : str.toCharArray()) {
            characterFrequencyMap.put(chr, characterFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());

        // add all characters to the max heap
        maxHeap.addAll(characterFrequencyMap.entrySet());

        // build a string, appending the most occurring characters first
        StringBuilder sortedString = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++)
                sortedString.append(entry.getKey());
        }
        return sortedString.toString();
    }

}
