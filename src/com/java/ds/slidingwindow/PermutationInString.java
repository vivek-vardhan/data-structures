package com.java.ds.slidingwindow;

import java.util.*;

public class PermutationInString {
    /*
    Given a string and a pattern, find out all the string index which contains any permutation of the pattern.

https://leetcode.com/problems/find-all-anagrams-in-a-string/
    Input: String="oidbcaf", Pattern="abc"
    Output: 3
    Explanation: The string contains "bca" which is a permutation of the given pattern.

     */

    public static List<Integer> findPermutation(String str, String pattern) {

        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> charFrequencyMap = new HashMap<>();//Freq in pattern
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }
        int start = 0;
        int charMatchedCount  = 0;//to keep track of char frequency matched

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (charFrequencyMap.containsKey(currentChar)) {
                charFrequencyMap.put(currentChar, charFrequencyMap.get(currentChar) - 1); //matched, so decrease count
                if (charFrequencyMap.get(currentChar) == 0) {
                    charMatchedCount++; //This character is completely matched
                }
            }
            if (charMatchedCount == charFrequencyMap.size()) {
                list.add(i- pattern.length() + 1); //Add the start index
            }
            if (i >= pattern.length() - 1) { // shrink the window by one character
                char leftChar = str.charAt(start++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0)
                        charMatchedCount--; // before putting the character back, decrement the matched count
                    // put the character back for matching
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }

        }
        return list;
    }

    //Find all such start index in the string of pattern
}
