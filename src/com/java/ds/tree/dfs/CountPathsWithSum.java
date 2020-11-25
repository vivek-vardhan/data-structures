package com.java.ds.tree.dfs;

import com.java.ds.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CountPathsWithSum {

    /*
    Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’.

     Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).

     */

    public static int countPaths(TreeNode root, int S) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursive(root, S, currentPath);
    }

    private static int countPathsRecursive(TreeNode currentNode, int S, List<Integer> currentPath) {
        if (currentNode == null)
            return 0;

        // add the current node to the path
        currentPath.add(currentNode.val);
        int pathCount = 0, pathSum = 0;
        // find the sums of all sub-paths in the current path list
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());

        //check for any path (not necessary from root)
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            // if the sum of any sub-path is equal to 'S' we increment our path count.
            if (pathSum == S) {
                pathCount++;
            }
        }

        // traverse the left sub-tree
        pathCount += countPathsRecursive(currentNode.left, S, currentPath);
        // traverse the right sub-tree
        pathCount += countPathsRecursive(currentNode.right, S, currentPath);

        // remove the current node from the path to backtrack, we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);

        return pathCount;
    }
}
