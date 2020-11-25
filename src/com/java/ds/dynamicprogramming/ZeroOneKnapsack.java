package com.java.ds.dynamicprogramming;

public class ZeroOneKnapsack {

    /*
    Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack with a capacity ‘C.’
    The goal is to get the maximum profit out of the knapsack items.
    Each item can only be selected once, as we don’t have multiple quantities of any item.


        return this.knapsackRecursive(profits, weights, capacity, 0); - O(2^n)

     */

    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        // base checks
        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }


        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if( weights[currentIndex] <= capacity ) {
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1); //including current
        }

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }

    //Top down DP with Memoization
    //just remember the result in an array
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return this.knapsackRecursiveWithMemo(dp, profits, weights, capacity, 0);
    }

    private int knapsackRecursiveWithMemo(Integer[][] dp, int[] profits, int[] weights, int capacity,
                                  int currentIndex) {

        // base checks
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // if we have already solved a similar problem, return the result from memory
        if(dp[currentIndex][capacity] != null) {
            return dp[currentIndex][capacity];
        }

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if( weights[currentIndex] <= capacity )
            profit1 = profits[currentIndex] + knapsackRecursiveWithMemo(dp, profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursiveWithMemo(dp, profits, weights, capacity, currentIndex + 1);

        dp[currentIndex][capacity] = Math.max(profit1, profit2);
        return dp[currentIndex][capacity];
    }

    //Bottom up DP - build solution
    /*
    - dp[i][c] will represent the maximum knapsack profit for capacity ‘c’ calculated from the first ‘i’ items.

    - So, for each item at index ‘i’ (0 <= i < items.length) and capacity ‘c’ (0 <= c <= capacity), we have two options:

        1. Exclude the item at index ‘i.’ In this case, we will take whatever profit we get from the sub-array excluding this item => dp[i-1][c]
        2. Include the item at index ‘i’ if its weight is not more than the capacity.
            In this case, we include its profit plus whatever profit we get from the remaining capacity and from remaining items => profit[i] + dp[i-1][c-weight[i]]


                dp[i][c] = max (dp[i-1][c],     profit[i] + dp[i-1][c-weight[i]])


     */

    public int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length) {
            return 0;
        }

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        for(int i=0; i < n; i++) {
            dp[i][0] = 0;
        }

        // if we have only one weight, we will take it if it is not more than the capacity
        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        // process all sub-arrays for all the capacities
        for(int i=1; i < n; i++) {
            for(int c=1; c <= capacity; c++) {
                int profit1= 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if(weights[i] <= c) {
                    profit1 = profits[i] + dp[i-1][c-weights[i]];
                }
                // exclude the item
                profit2 = dp[i-1][c];
                // take maximum
                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        printSelectedElements(dp, weights, profits, capacity);

        // maximum profit will be at the bottom-right corner.
        return dp[n-1][capacity];
    }

    /*
     at every step, we had two options: include an item or skip it.
     - If we skip an item, we take the profit from the remaining items (i.e., from the cell right above it);
     - if we include the item, then we jump to the remaining profit to find more items.

     */
    private void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity){
        System.out.print("Selected weights:");
        int totalProfit = dp[weights.length-1][capacity];
        for(int i = weights.length-1; i > 0; i--) {
            if(totalProfit != dp[i-1][capacity]) { //if not from top, then this is the place where it came from, else continue on top
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }

        if(totalProfit != 0) {
            System.out.print(" " + weights[0]);
        }
        System.out.println("");
    }



}
