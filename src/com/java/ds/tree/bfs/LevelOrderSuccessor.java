package com.java.ds.tree.bfs;


import com.java.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * NOTE: One more variation is connect level order nodes
 * HOW TO: every level, keep prev node and connect prevNode.next to CURRENT NODE, and last node of same level will connect to null
 *
 * Now, suppose last node of cur level to connect to next level, JUST INIT the prev and current outside for loop
 *
 *     Queue<TreeNode> queue = new LinkedList<>();
 *     queue.offer(root);
 *     TreeNode currentNode = null, previousNode = null;
 *     while (!queue.isEmpty()) {
 *       currentNode = queue.poll();
 *       if (previousNode != null)
 *         previousNode.next = currentNode;
 *       previousNode = currentNode;
 *    }
 *
 */

public class LevelOrderSuccessor {
    /**
     * 1. Do level order
     * 2. Keep adding nodes of next level
     * 3. After adding the child of current, check whether current is key : WHY AFTER ADDING, because key  might be there in next level
     * 4. If yes, return next element from queue
     *
     * @param root
     * @param key
     * @return
     */

    public static int levelOrderSuccessor(TreeNode root, int key) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ans =-1;
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

                if (current.val == key) { //If we fou
                    ans = queue.peek().val;
                }
            }
        }

        return ans;

    }
}
