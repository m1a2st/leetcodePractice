package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class No623 {

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

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(5);
        new SolutionDFS().addOneRow(root, 1, 3);
    }


    class SolutionBFS {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                return new TreeNode(val, root, null);
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int level = 1;

            while (!queue.isEmpty() && level < depth) {
                int levelNodeCount = queue.size();
                for (int i = 0; i < levelNodeCount; i++) {
                    TreeNode poll = queue.poll();
                    if (level == depth - 1) {
                        TreeNode left = poll.left;
                        TreeNode right = poll.right;
                        poll.left = new TreeNode(val, left, null);
                        poll.right = new TreeNode(val, null, right);
                    } else {
                        if (poll.left != null) {
                            queue.offer(poll.left);
                        }

                        if (poll.right != null) {
                            queue.offer(poll.right);
                        }
                    }
                }
                if (level == depth - 1) break;
                level++;
            }
            return root;
        }
    }

    class SolutionDFS {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                return new TreeNode(val, root, null);
            }
            dfs(root, val, depth, 1);
            return root;
        }

        private void dfs(TreeNode root, int val, int depth, int level) {
            if (root == null) {
                return;
            }
            if (depth == level - 1) {
                root.left = new TreeNode(val, root.left, null);
                root.right = new TreeNode(val, null, root.right);
                return;
            }
            dfs(root.left, val, depth, level + 1);
            dfs(root.right, val, depth, level + 1);
        }
    }
}
