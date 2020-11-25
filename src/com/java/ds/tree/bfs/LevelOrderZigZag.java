package com.java.ds.tree.bfs;

import com.java.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderZigZag {

    public List<List<Integer>> levelOrderTraversalAsList(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> levelToNodeList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int nodeInLevel = queue.size();
            List<Integer> list  = new LinkedList<>(); //USE LINKED LIST
            for (int i =0; i< nodeInLevel;i++) {
                TreeNode current = queue.poll();
                if (leftToRight) {
                    list.add(current.val); //left to right,append at end
                } else {
                    list.add(0, current.val); //right to left, append at start
                }

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            leftToRight = !leftToRight; //reverse the direction
            levelToNodeList.add(list);
            //for reverse level order: levelToNodeList.add(0, list);//will keep appending at 0th index
        }
        return levelToNodeList;
    }
}
