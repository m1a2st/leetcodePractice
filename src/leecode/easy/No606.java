package leecode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No606 {


    @Test
    public void testTree2strWithSingleNode() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        String result = solution.tree2str(root);
        assertEquals("1", result);
    }

    @Test
    public void testTree2strWithMultipleNodes() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        String result = solution.tree2str(root);
        assertEquals("1(3)(2)", result);
    }

    @Test
    public void testTree2strWithNull() {
        Solution solution = new Solution();
        String result = solution.tree2str(null);
        assertEquals("", result);
    }


    class Solution {
        public String tree2str(TreeNode t) {
            return dfs(t);
        }

        private String dfs(TreeNode root) {
            if (root == null)
                return "";
            if (root.right != null)
                return root.val + "(" + dfs(root.left) + ")(" + dfs(root.right) + ")";
            if (root.left != null)
                return root.val + "(" + dfs(root.left) + ")";
            return root.val + "";
        }
    }
}
