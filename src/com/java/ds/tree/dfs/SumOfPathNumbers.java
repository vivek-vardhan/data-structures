package com.java.ds.tree.dfs;

import com.java.ds.tree.TreeNode;

public class SumOfPathNumbers {

    /*

    Given a binary tree where each node can only have a digit (0-9) value,
    each root-to-leaf path will represent a number. Find the total sum of all the numbers represented by all paths.


            1
         7          9
                2       9

                17 + 192 + 199 = 408
     */

    public static int findSumOfPathNumbers(TreeNode root) {
        return findRootToLeafPathNumbers(root, 0);
    }

    private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
        if (currentNode == null) {
            return 0;
        }

        // calculate the path number of the current node
        pathSum = 10 * pathSum + currentNode.val;

        // if the current node is a leaf, return the current path sum.
        if (currentNode.left == null && currentNode.right == null) {
            return pathSum;
        }

        // traverse the left and the right sub-tree
        return findRootToLeafPathNumbers(currentNode.left, pathSum) + findRootToLeafPathNumbers(currentNode.right, pathSum);
    }
}
