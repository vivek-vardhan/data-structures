package com.java.ds.slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given a string, find the length of the longest substring, which has no repeating characters.
 *
 */
public class LongestSubStrWithoutRepeatChar {

    public int lengthOfLongestSubstring(String s) {


        Set<Character> set = new HashSet<>();
        int ans = 0, start = 0;

        for (int i =0; i< s.length();i++) {
            Character currentChar = s.charAt(i);
            if (!set.contains(currentChar)) { //new character, valid case
                set.add(currentChar);
                ans = Math.max(ans, set.size());//current size of set is the ans
            } else { //I have seen this character before,
                // so start removing  character from start and increase window till I am able to remove one instance of this character
                while (start < s.length() && s.charAt(start) != currentChar) {
                    set.remove(s.charAt(start));
                    start++;
                }
                //Now increase start once more to actually remove the character and add this to set here
                start++;
                set.add(currentChar);

            }
        }

        return ans;

    }
}
