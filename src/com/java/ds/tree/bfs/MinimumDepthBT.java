package com.java.ds.tree.bfs;

import com.java.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDepthBT {

    /**
     *
     * ALGO: Keep increasing depth as the level change
     *
     * - As soon as first leaf encountered, return the depth
     *
     *
     */
    public static int findMinDepth(TreeNode root) {

        if (root == null) {
                return 0;
            }
        List<List<Integer>> levelToNodeList = new LinkedList<>();
        int minDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            minDepth++;
            int nodeInLevel = queue.size();
            List<Integer> list  = new ArrayList<>(nodeInLevel);
            for (int i =0; i< nodeInLevel;i++) { //remove all in level, then break the loop for next level (queue won't be empty)
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left == null && current.right == null) { //if we reach a leaf node
                    return minDepth;
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            levelToNodeList.add(list);
            //for reverse level order: levelToNodeList.add(0, list);//will keep appending at 0th index
        }

        return minDepth;

    }
}
