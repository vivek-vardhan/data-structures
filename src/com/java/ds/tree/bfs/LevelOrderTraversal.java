package com.java.ds.tree.bfs;

import com.java.ds.tree.TreeNode;

import java.util.*;

public class LevelOrderTraversal {


    /**
     * Can be extended to RIGHT VIEW of binary tree, left view, border view.. JUST PRINT 1st AND/OR last node at each level
     *
     *
     *
     * @param root
     * @return
     */
    public Map<Integer, List<Integer>> levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return new HashMap<>();
        }
        Map<Integer, List<Integer>> levelToNodeList = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int nodeInLevel = queue.size();
            List<Integer> list  = new ArrayList<>(nodeInLevel);
            for (int i =0; i< nodeInLevel;i++) { //remove all in level, then break the loop for next level (queue won't be empty)
                TreeNode current = queue.poll();
                list.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            levelToNodeList.put(level, list);
            level++;
        }
        return levelToNodeList;
    }

    /**
     * for reverse level order check the comments
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderTraversalAsList(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> levelToNodeList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodeInLevel = queue.size();
            List<Integer> list  = new ArrayList<>(nodeInLevel);
            for (int i =0; i< nodeInLevel;i++) { //remove all in level, then break the loop for next level (queue won't be empty)
                TreeNode current = queue.poll();
                list.add(current.val);
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
        return levelToNodeList;
    }
}
