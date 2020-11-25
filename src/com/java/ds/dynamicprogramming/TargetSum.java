package com.java.ds.dynamicprogramming;

public class TargetSum {
    /*
    You are given a set of positive numbers and a target sum ‘S’.
    Each number should be assigned either a ‘+’ or ‘-’ sign.

    We need to find the total ways to assign symbols to make the sum of the numbers equal to the target ‘S’.

    Input: {1, 1, 2, 3}, S=1
    Output: 3
    Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}


 let’s say ‘Sum(s1)’ denotes the total sum of set ‘s1’, and ‘Sum(s2)’ denotes the total sum of set ‘s2’. So the required equation is:

 Required is:               Sum(s1) - Sum(s2) = S          (s1 is assigining +ve and S2 is assigining -ve)

 The subset equation is:     Sum(s1) + Sum(s2) = Sum(num)


Adding above two -


   => Sum(s1) - Sum(s2) + Sum(s1) + Sum(s2) = S + Sum(num)
   => 2 * Sum(s1) =  S + Sum(num)
   => Sum(s1) = (S + Sum(num)) / 2 -> reduced to count of subset sum

     */

    public int findTargetSubsets(int[] num, int s) {
        int totalSum = 0;
        for (int n : num) {
            totalSum += n;
        }


        // if 's + totalSum' is odd, we can't find a subset with sum equal to '(s + totalSum) / 2'
        if(totalSum < s || (s + totalSum) % 2 == 1) {
            return 0;
        }

        return countSubsets(num, (s + totalSum) / 2);
    }

    // this function is exactly similar to what we have in 'Count of Subset Sum' problem.
    private int countSubsets(int[] num, int sum) {
        int n = num.length;
        int[][] dp = new int[n][sum + 1];

        // populate the sum=0 columns, as we will always have an empty set for zero sum
        for(int i=0; i < n; i++) {
            dp[i][0] = 1;
        }


        // with only one number, we can form a subset only when the required sum is equal to the number
        for(int s=1; s <= sum ; s++) {
            dp[0][s] = (num[0] == s ? 1 : 0);
        }

        // process all subsets for all sums
        for(int i=1; i < num.length; i++) {
            for(int s=1; s <= sum; s++) {
                dp[i][s] = dp[i-1][s];
                if(s >= num[i])
                    dp[i][s] += dp[i-1][s-num[i]];
            }
        }

        // the bottom-right corner will have our answer.
        return dp[num.length-1][sum];
    }

}
