package com.java.ds.twopointers;

public class BackspaceStringCompare {
    /*
    https://leetcode.com/problems/backspace-string-compare/

    Input: str1="xy#z", str2="xzz#"
    Output: true
    Explanation: After applying backspaces the strings become "xz" and "xz" respectively.

     */

    public static boolean compare(String str1, String str2) {
        // use two pointer approach to compare the strings
        int index1 = str1.length() - 1, index2 = str2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {

            int i1 = getNextValidCharIndex(str1, index1);
            int i2 = getNextValidCharIndex(str2, index2);

            if (i1 < 0 && i2 < 0) // reached the end of both the strings
                return true;

            if (i1 < 0 || i2 < 0) // reached the end of one of the strings
                return false;

            if (str1.charAt(i1) != str2.charAt(i2)) // check if the characters are equal
                return false;

            index1 = i1 - 1;
            index2 = i2 - 1;
        }

        return true;
    }

    private static int getNextValidCharIndex(String str, int index) {
        int backspaceCount = 0;
        while (index >= 0) {
            if (str.charAt(index) == '#') {// found a backspace character
                backspaceCount++;
                index--; // skip a backspace
            } else if (backspaceCount > 0) { // a non-backspace character, but backspace was detected before. So, decrease backspace, reduce index
                backspaceCount--;
                index--; // skip the char
            }
            else
                break;
        }
        return index;
    }

}
