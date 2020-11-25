package com.java.ds.tree.dfs;

import com.java.ds.tree.TreeNode;

public class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        if (root == null)
            return sequence.length == 0;

        return findPathRecursive(root, sequence, 0);
    }

    private static boolean findPathRecursive(TreeNode currentNode, int[] sequence, int sequenceIndex) {

        if (currentNode == null) {
            return false;
        }
        if (sequenceIndex >= sequence.length) { //if leaf not reached, this cannot be path
            return false;
        }
        if (currentNode.val != sequence[sequenceIndex]) { //if current sequence not matched
            return false;
        }

        // if the current node is a leaf, add it is the end of the sequence, we have found a path!
        if (currentNode.left == null && currentNode.right == null && sequenceIndex == sequence.length - 1) {
            return true;
        }

        // recursively call to traverse the left and right sub-tree
        // return true if any of the two recusrive call return true
        return findPathRecursive(currentNode.left, sequence, sequenceIndex + 1)
                || findPathRecursive(currentNode.right, sequence, sequenceIndex + 1);
    }
}
