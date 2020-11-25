package com.java.ds;

import com.java.ds.cyclicsort.CyclicSort;
import com.java.ds.fastslowpointers.ListNode;
import com.java.ds.listreversal.ReverseEverykNodes;
import com.java.ds.twopointers.RemoveDuplicates;
import com.java.ds.twopointers.TripletWithSmallerSum;

public class Runner {

    public static void main(String args[]) {
//        MaxSubarraySumSizeK maxSubarraySumSizeK = new MaxSubarraySumSizeK();
//        System.out.println(maxSubarraySumSizeK.maxSubArraySumSizeK(3, new int[] { 2, 1, 5, 1, 3, 2 }));
//        System.out.println(maxSubarraySumSizeK.maxSubArraySumSizeK(2, new int[] { 2, 3, 4, 1, 5 }));
//
//
//        SmallestSubarrayWithGivenSum smallestSubarrayWithGivenSum = new SmallestSubarrayWithGivenSum();
//        System.out.println(smallestSubarrayWithGivenSum.smallestSubArrayWithGivenSum(7, new int[] { 2, 1, 5, 2, 3, 2 }));
//        System.out.println(smallestSubarrayWithGivenSum.smallestSubArrayWithGivenSum(7, new int[] { 2, 1, 5, 2, 8 }));
//        System.out.println(smallestSubarrayWithGivenSum.smallestSubArrayWithGivenSum(8, new int[] { 3, 4, 1, 1, 6 }));


//        LongestSubStrWithKDistrinctChar longestSubStrWithKDistrinctChar = new LongestSubStrWithKDistrinctChar();
//        System.out.println(longestSubStrWithKDistrinctChar.getLength("araaci", 2));
//        System.out.println(longestSubStrWithKDistrinctChar.getLength("araaci", 1));
//        System.out.println(longestSubStrWithKDistrinctChar.getLength("cbbebi", 3));

//        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
//        System.out.println(removeDuplicates.giveCountAfterRemovingDuplicates(new int[] {0, 0, 0, 0, 1, 1, 2,  2, 3,  4, 4, 4, 5}));
//        System.out.println(removeDuplicates.giveCountAfterRemovingDuplicates(new int[] {1,  2, 3, 4, 5}));


//        TripletWithSmallerSum tripletWithSmallerSum = new TripletWithSmallerSum();
//        System.out.println(tripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
//        System.out.println(tripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));

//
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);
//        head.next.next.next.next.next.next.next.next = new ListNode(9);
//        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
//        head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
//
//        ReverseEverykNodes reverseEverykNodes = new ReverseEverykNodes();
//
//        reverseEverykNodes.reverseEveryKNode(head, 3);


        CyclicSort cyclicSort = new CyclicSort();
        int arr[] = new int[] { 3, 1, 5, 4, 2 };
        cyclicSort.sort(arr);
        System.out.println(arr);

    }

}
