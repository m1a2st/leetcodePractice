package practice.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class No103 {


    //      Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            boolean reverse = false;
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> subList = new ArrayList<>();
                if (reverse) {
                    for (int i = 0; i < size; i++) {
                        TreeNode last = deque.pollLast();
                        subList.add(last.val);
                        if (last.right != null) {
                            deque.addFirst(last.right);
                        }
                        if (last.left != null) {
                            deque.addFirst(last.left);
                        }
                    }
                } else {
                    for (int i = 0; i < size; i++) {
                        TreeNode node = deque.pop();
                        subList.add(node.val);
                        if (node.left != null) {
                            deque.offer(node.left);
                        }
                        if (node.right != null) {
                            deque.offer(node.right);
                        }
                    }
                }
                ans.add(subList);
                reverse = !reverse;
            }
            return ans;
        }
    }
}
