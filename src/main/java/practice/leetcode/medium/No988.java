package practice.leetcode.medium;

import org.junit.jupiter.api.Test;


public class No988 {

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
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);

        System.out.println(new Solution().smallestFromLeaf(root));
    }

    class Solution {

        String ans = "";

        public String smallestFromLeaf(TreeNode root) {
            traversal(root, new StringBuilder());
            return ans;
        }

        private void traversal(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.insert(0, (char) (root.val + 97));
            if (root.left == null && root.right == null) {
                ans = checkStringIsLexicographicallySmallest(sb);
            }
            traversal(root.left, sb);
            traversal(root.right, sb);
            sb.deleteCharAt(0);
        }

        private String checkStringIsLexicographicallySmallest(StringBuilder temp) {
            if (ans.isEmpty()) {
                return temp.toString();
            }
            String currentStr = temp.toString();
            return ans.compareTo(currentStr) > 0 ? currentStr : ans;
        }
    }
}
