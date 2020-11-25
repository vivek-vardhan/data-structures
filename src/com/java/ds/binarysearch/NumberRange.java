package com.java.ds.binarysearch;

public class NumberRange {

    /**
     * Find first and last position of a number in sorted array
     *
     * ALGO is same as binary search, just when mid is found
     *  CASE 1: To Find first occurrence then
     *      - Find the any occurrence
     *      - Go more left possible till 0, OR nums[mid-1]!=nums[mid].. repeat same binary search
     *  Case 2    To Find last occurrence then
     *      - Go more right possible till n-1, OR nums[mid+1]!=nums[mid].. repeat same binary search (as if number was not found)
     */

    public int findFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid]<target)
                low = mid+1;

            else if(nums[mid]>target)
                high = mid-1;

            else{
                if(mid==0  ||  nums[mid-1]!=nums[mid])
                    return mid;
                else
                    high = mid-1; //keep repeating binary search by reducing high (going left)
            }
        }
        return -1;
    }

    public int findLast(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;

            if(nums[mid]<target)
                low = mid+1;

            else if(nums[mid]>target)
                high = mid-1;

            else{
                if(mid==nums.length-1  ||  nums[mid+1]!=nums[mid])
                    return mid;
                else
                    low = mid+1; //keep repeating binary search by increasing low (going right)
            }
        }
        return -1;
    }


}
