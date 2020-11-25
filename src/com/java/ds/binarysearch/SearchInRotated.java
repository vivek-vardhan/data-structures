package com.java.ds.binarysearch;

public class SearchInRotated {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = left + (right-left/2);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] < nums[mid]) {//if left half sorted:
                if (nums[left] <= target && nums[mid] >=target) {//then check whether it can lie in left
                    right = mid -1;
                } else {
                    left = mid+1;
                }
            } else { //RIGHT half sorted
                if (nums[right] >= target && nums[mid] <=target) { //then check whether it can lie in right
                    left = mid +1;
                } else {
                    right = mid-1;
                }
            }

        }
        return -1;

    }

    public boolean seacrhWithDuplicates(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target)
                return true;

            // to handle the duplicates only if start and mid and end all are same, else all logic will work, this will confuse which half is sorted
            if((nums[start] == nums[mid]) && (nums[end] == nums[mid])){ //this cause worst case O(n)
                start++;
                end--;
            } else if(nums[start] <= nums[mid]){
                if(target >= nums[start] && nums[mid] > target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            } else{
                if(target <= nums[end] && nums[mid] < target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return false;

    }

    public int countRotation(int[] arr) { //SAME AS FIND PIVOT
        /*
                Input: [10, 15, 1, 3, 8]
                Output: 2
                Explanation: The array has been rotated 2 times.

                Input: [4, 5, 7, 9, 10, -1, 2]
                Output: 5
                Explanation: The array has been rotated 5 times.

                Observe: We just have to find pivot

         */

            int start = 0, end = arr.length - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;

                if (mid < end && arr[mid] > arr[mid + 1]) {// if mid is greater than the next element
                    return mid + 1;
                }
                if (mid > start && arr[mid - 1] > arr[mid]) { // if mid is smaller than the previous element
                    return mid;
                }

                if (arr[start] < arr[mid]) { // left side is sorted, so the pivot is on right side
                    start = mid + 1;
                } else { // right side is sorted, so the pivot is on the left side
                    end = mid - 1;
                }
            }

            return 0; // the array has not been rotated
    }



}
