package com.java.ds.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 *
 * ALGO:
 *
 * 1. Create a map of character to count of the characters
 * 2. As size is growing more than k, remove the start character and increase the start
 *
 *
 */


public class LongestSubStrWithKDistrinctChar {

    public int getLength(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        int start = 0;
        for (int i =0; i < str.length();i++) {
            Character currentChar = str.charAt(i);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            //Now, if with addition of this character, size becomes > k, means extra char gets added, so remove from start
            while (map.size() > k) {
                Character startchar = str.charAt(start);
                //remove one character at a time
                map.put(startchar, map.get(startchar) - 1); //reducing count by 1, we cannot directly reduce count here as it might not be contiguous
                if (map.get(startchar) == 0) {//if count becomes zero
                    map.remove(startchar);
                }
                start++;

            }
            maxLength = Math.max(maxLength, i-start +1);
        }

        return maxLength;
    }
}
