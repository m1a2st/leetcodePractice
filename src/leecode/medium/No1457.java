package leecode.medium;

public class No1457 {


    // Definition for a binary tree node.
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
        int ans = 0;

        public int pseudoPalindromicPaths(TreeNode root) {
            func(root, 0);
            return ans;
        }

        void func(TreeNode node, int seen) {
            if (node == null) return;
            seen ^= (1 << node.val);
            if (node.left == null && node.right == null) {
                if ((seen & (seen - 1)) == 0) {
                    ans++;
                }
                return;
            }
            func(node.left, seen);
            func(node.right, seen);

        }
    }

    class SolutionNew {

        int[] cache = new int[10];
        int totalPalPaths = 0;

        public int pseudoPalindromicPaths(TreeNode root) {
            traverse(root);
            return totalPalPaths;
        }

        private void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            cache[root.val]++;
            if (root.left == null && root.right == null) {
                int odds = 0;
                for (int s : cache) {
                    odds += s % 2;
                }
                if (odds <= 1) totalPalPaths++;
            } else {
                traverse(root.left);
                traverse(root.right);
            }
            cache[root.val]--;
        }
    }
}
