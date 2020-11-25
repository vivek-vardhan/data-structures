package com.java.ds.slidingwindow;

import java.util.*;

public class LongestsubstrwithLetterReplacement {
    /*

    Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,

    find the length of the longest substring having the same letters after replacement.

    Input: String="abccde", k=1
    Output: 3
    Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".

    Input: String="aabccbb", k=2
    Output: 5
    Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
   */

    public static int findLength(String str, int k) {
        int start = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            letterFrequencyMap.put(currentChar, letterFrequencyMap.getOrDefault(currentChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(currentChar));

            // current window size is from start to i,
            // overall we have a letter which is repeating 'maxRepeatLetterCount' times,
            // this means we can have a window which has one letter repeating 'maxRepeatLetterCount' times
            // and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we are not allowed to replace more than 'k' letters
            if (i - start + 1 - maxRepeatLetterCount > k) {
                char leftChar = str.charAt(start);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                start++;
            }
            /*
            Why don’t we need to update this count when we shrink the window?

            - In any window, since we have to replace all the remaining letters to get the longest substring having the same letter,
            we can’t get a better answer from any other window even though,
            all occurrences of the letter with frequency maxRepeatLetterCount is not in the current window.
             */

            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
    /*
    What are the strange things?

        1. You don't update your maxLetter
        2. You don't mantain a result length, simply return right - left at the end.

    This works because of the following:
            - Longest substring must have the maximum maxRepeatLetterCount.
            - you best result is (maxRepeatLetterCount - k),

            - k stays the same for any substring so maxRepeatLetterCount must be the maximum over all maxLetters you encountered during runtime.

        3. Why the wrong maxRepeatLetterCount won't mess your result?
        - if your maxRepeatLetterCount is bigger than it should be, you gonna skip left increments and
            make your current valid substring longer than it actually is
        - it doesn't matter since you gonna return the length of the longest, and we showed that it's maxRepeatLetterCount is gonna be correct

        4. Why it's enough to return right-left?

        -   will always grow, so we might make right larger and wrongly inflate our output
        - if maxRepeatLetterCount doesn't grow along with right, left is gonna grow as well!! (offsetting the mistaken right growth)
        - this way the right - left gap is the actual longest substring








     */


}
