package com.java.ds.tree.dfs;

import com.java.ds.tree.TreeNode;

public class TreeDiameter {

    /*
    Longest leaf to leaf path: Not necessary from root


    Diameter at every node: leftTreeHeight (considering root at this node) + rightTreeHeight + 1
     */

    private static int treeDiameter = 0;

    public static int findDiameter(TreeNode root) {
        calculateHight(root);
        return treeDiameter;
    }

    private static int calculateHight(TreeNode currentNode) {
        if (currentNode == null) {
            return 0;
        }

        int leftTreeHeight = calculateHight(currentNode.left);
        int rightTreeHeight = calculateHight(currentNode.right);

        // diameter at the current node will be equal to the height of left subtree + the height of right sub-trees + '1' for the current node
        int diameter = leftTreeHeight + rightTreeHeight + 1;

        // update the global tree diameter
        treeDiameter = Math.max(treeDiameter, diameter);

        // return height of the current node
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }

}
