package com.java.ds.slidingwindow;

import java.util.*;

public class SmallestWindowContainingStr {
    /*

    Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.

    Input: String="abdbca", Pattern="abc"
    Output: "bca"
    Explanation: The smallest substring having all characters of the pattern is "bca".


1. We start with two pointers,
start and i initially pointing to the first element of the string SS.

2. We use the i pointer to expand the window until we get a desirable window i.e. a window that contains all of the characters of TT.

3. Once we have a window with all the characters,
we can move the left pointer ahead one by one. If the window is still a desirable one we keep on updating the minimum window size.

4. If the window is not desirable any more, we repeat step 2 onwards.


     */
    public static String findSubstring(String str, String pattern) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }


        int start = 0;
        int matched = 0;
        int minLength = str.length() + 1; //Init the min length to greater than str length, to check whether str found or not
        int subStrStart = 0;

        for (int i=0; i< str.length();i++) {
            char currentChar = str.charAt(i);
            if (charFrequencyMap.containsKey(currentChar)) {
                charFrequencyMap.put(currentChar, charFrequencyMap.get(currentChar) - 1); //decrease count if matched
                if (charFrequencyMap.get(currentChar) >= 0) {// count every matching of a character (aa will be counted as 2)
                    matched++;
                }
            }
            //if all matched, calculate length & shrink the window till its still matching
            while (matched == pattern.length()) {
                //update current min
                if (minLength > i - start + 1) {
                    minLength = i - start + 1;
                    subStrStart = start;
                }
                char leftChar = str.charAt(start);
                start++;
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--; //Removed matched and add the char again
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }

        }
        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }

}
