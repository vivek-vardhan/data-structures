package com.java.ds.tree.dfs;

import com.java.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPathSum {

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        findPathsRecursive(root, sum, currentPath, allPaths);

        return allPaths;
    }

    private static void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath,
                                           List<List<Integer>> allPaths) {
        if (currentNode == null) {
            return;
        }

        // add the current node to the path, if it will not lead to sum, then we will remove it
        currentPath.add(currentNode.val);

        // if the current node is a leaf and its value is equal to sum, save the current path
        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            // traverse the left sub-tree
            findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);

            // traverse the right sub-tree
            findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }
}
