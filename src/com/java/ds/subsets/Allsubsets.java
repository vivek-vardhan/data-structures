package com.java.ds.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Allsubsets {
    /*
    Input: [1, 3]
    Output: [], [1], [3], [1,3]


    ALGO:

    Given set: [1, 5, 3]

    1. Start with an empty set: [[]]
    2. Add the first number (1) to all the existing subsets to create new subsets: [[], [1]];
    3. Add the second number (5) to all the existing subsets: [[], [1], [5], [1,5]];
    4. Add the third number (3) to all the existing subsets: [[], [1], [5], [1,5], [3], [1,3], [5,3], [1,5,3]].

    Time and Space both are: O(N * 2^N).

     */

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing subsets and insert the current number in them to create new subsets
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }

    /*
    Given a set of numbers that might contain duplicates, find all of its distinct subsets.

    Input: [1, 3, 3]
    Output: [], [1], [3], [1,3], [3,3], [1,3,3]


        1. Sort all numbers of the given set. This will ensure that all duplicate numbers are next to each other.
        2. Follow the same BFS approach but whenever we are about to process a duplicate
            (i.e., when the current and the previous numbers are same), instead of adding the current number (which is a duplicate) to all the existing subsets,
            only add it to the subsets which were created in the previous step.

    ALGO WALK THROUGH

        Given set: [1, 5, 3, 3]
        Sorted set: [1, 3, 3, 5]

        1. Start with an empty set: [[]]
        2. Add the first number (1) to all the existing subsets to create new subsets: [[], [1]];
        3. Add the second number (3) to all the existing subsets: [[], [1], [3], [1,3]].
        4. The next number (3) is a duplicate. So, we will add only to newly created subsets
            [[], [1], (won't add to these 2) [3], [1,3],  [3,3], [1,3,3]]
        5. [[], [1], [3], [1,3], [3,3], [1,3,3], [5], [1,5], [3,5], [1,3,5], [3,3,5], [1,3,3,5]]

         Time and Space both are: O(N * 2^N).

   */

    public static List<List<Integer>> findSubsetsWithDuplicates(int[] nums) {
        // sort the numbers to handle duplicates
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        int startIndex = 0, prevCreatedSubsetEndIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;
            // if current and the previous elements are same, create new subsets only from the subsets added in the previous step
            if (i > 0 && nums[i] == nums[i - 1]) {
                startIndex = prevCreatedSubsetEndIndex + 1; //To skip older created subsets
            }
            prevCreatedSubsetEndIndex = subsets.size() - 1; //Increase prev index to  subset size created in last iteration
            for (int j = startIndex; j <= prevCreatedSubsetEndIndex; j++) {
                // create a new subset from the existing subset and add the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }
}
