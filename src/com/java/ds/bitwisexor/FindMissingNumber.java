package com.java.ds.bitwisexor;

public class FindMissingNumber {

    /*

    Given an array of n-1n−1 integers in the range from 11 to nn, find the one number that is missing from the array.


        1. XOR all the numbers from 1 to n, let’s call it x1.
        2. XOR all the numbers in the input array, let’s call it x2.
        3. The missing number can be found by x1 XOR x2.


        taking XOR of a number with itself returns 0, e.g.,
        1 ^ 1 = 0
        29 ^ 29 = 0

        Taking XOR of a number with 0 returns the same number, e.g.,
        1 ^ 0 = 1
        31 ^ 0 = 31


        XOR is Associative & Commutative, which means:
        (a ^ b) ^ c = a ^ (b ^ c)
        a ^ b = b ^ a

     */

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        // find sum of all numbers from 1 to n.
        int x1 = 1;
        for (int i = 2; i <= n; i++)
            x1 = x1 ^ i;

        // x2 represents XOR of all values in arr
        int x2 = arr[0];
        for (int i = 1; i < n-1; i++)
            x2 = x2 ^ arr[i];

        // missing number is the xor of x1 and x2
        return x1 ^ x2;
    }

}
