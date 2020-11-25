package com.java.ds.slidingwindow;

import java.util.*;

public class WordConcat {
    /*
    Given a string and a list of words, find all the starting indices of substrings in the given string that are
    a concatenation of all the given words exactly once without any overlapping of words. It is given that all words are of the same length.



Input: String="catfoxcat", Words=["cat", "fox"]
Output: [0, 3]
Explanation: The two substring containing both the words are "catfox" & "foxcat".

Input: String="catcatfoxfox", Words=["cat", "fox"]
Output: [3]
Explanation: The only substring containing both the words is "catfox".


1. Keep the frequency of every word in a HashMap.
2. Starting from every index in the string, try to match all the words.
3. In each iteration, keep track of all the words that we have already seen in another HashMap.
4. If a word is not found or has a higher frequency than required, we can move on to the next character in the string.
5. Store the index if we have found all the words.


     */

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        //get all the words and the ferquency
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> resultIndices = new ArrayList<Integer>();
        int totalWords = words.length;
        int eachWordLength = words[0].length();

        //Atleast totalWords * eachWordLength : this much char needed to contain all the words
        for (int i = 0; i <= str.length() - totalWords * eachWordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();

            for (int j = 0; j < totalWords; j++) {
                int nextWordIndex = i + j * eachWordLength; //matching all words one by one, starting from ith index in main str of length of word
                String currentWord = str.substring(nextWordIndex, nextWordIndex + eachWordLength);
                if (!wordFrequencyMap.containsKey(currentWord)) // break if we don't need this word
                    break;
                wordsSeen.put(currentWord, wordsSeen.getOrDefault(currentWord, 0) + 1); // add the word to the 'wordsSeen' map
                // no need to process further if the word has higher frequency than required
                if (wordsSeen.get(currentWord) > wordFrequencyMap.getOrDefault(currentWord, 0))
                    break;
                if (j + 1 == totalWords) // store index if we have found all the words
                    resultIndices.add(i);

            }
        }
        return resultIndices;
    }
}
