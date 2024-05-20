package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author m1a2st
 * @Date 2023/7/12
 * @Version v1.0
 */
public class No102 {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));

            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                for (int size = queue.size(); size > 0; --size) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                res.add(level);
            }
            return res;
        }
    }

    class SolutionBfs {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            if (root == null) {
                return ans;
            }
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                ans.add(level);
            }
            return ans;
        }
    }

    class SolutionDfs {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return ans;
            }
            traversal(root, 0);
            return ans;
        }

        private void traversal(TreeNode root, int level) {
            if (root != null) {
                if (level == ans.size()) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(root.val);
                    ans.add(list);
                } else {
                    ans.get(level).add(root.val);
                }
                traversal(root.left, level + 1);
                traversal(root.right, level + 1);
            }
        }
    }
}
