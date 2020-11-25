package com.java.ds.tree.dfs;

import com.java.ds.tree.TreeNode;

public class PathWithMaximumSum {

    /*

    Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.

    A path can be defined as a sequence of nodes between any two nodes
        and doesn’t necessarily pass through the root. The path must contain at least one node.
     */

    private static int globalMaximumSum;

    public static int findMaximumPathSum(TreeNode root) {
        globalMaximumSum = Integer.MIN_VALUE;
        findMaximumPathSumRecursive(root);
        return globalMaximumSum;
    }

    private static int findMaximumPathSumRecursive(TreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }

        int maxPathSumFromLeft = findMaximumPathSumRecursive(currentNode.left);
        int maxPathSumFromRight = findMaximumPathSumRecursive(currentNode.right);

        // ignore paths with negative sums, since we need to find the maximum sum we should ignore any path which has an overall negative sum.
        maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
        maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);

        // maximum path sum at the current node will be equal to the sum from the left subtree + the sum from right subtree + val of current node
        int localMaximumSum = maxPathSumFromLeft + maxPathSumFromRight + currentNode.val;

        // update the global maximum sum
        globalMaximumSum = Math.max(globalMaximumSum, localMaximumSum);

        // maximum sum of any path from the current node will be equal to the maximum of the sums from left or right subtrees plus the value of the current node
        return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + currentNode.val;
    }
}
