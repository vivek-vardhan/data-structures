package com.java.ds.tree.dfs;

import com.java.ds.tree.TreeNode;

public class RootToLeafPathSum {
    /*

    Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
     */

    public static boolean hasTreePathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        // if the current node is a leaf and its value is equal to the sum, we've found a path
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        //decrease sum and send recursively, so that directly you can get the root.val
        return hasTreePathSum(root.left, sum - root.val) || hasTreePathSum(root.right, sum - root.val);

    }
}
