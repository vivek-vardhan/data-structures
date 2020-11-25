package com.java.ds.twopointers;

public class SquareOfSortedArray {

    public int[] sortedSquares(int[] A) {

        if (A.length == 0) {
            return A;
        }
        int start = 0;
        int end = A.length - 1;
        int index = A.length - 1;
        int[] arr = new int[A.length];

        while (start <=end) {
            int squareStart = A[start] * A[start];
            int squareEnd = A[end] * A[end];
            if (squareStart  >  squareEnd){
                arr[index--] = squareStart;
                start++;
            } else {
                arr[index--] = squareEnd;
                end--;
            }
        }
        return arr;

    }
}
