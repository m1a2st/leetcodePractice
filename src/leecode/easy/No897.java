package leecode.easy;


/**
 * @Author m1a2st
 * @Date 2023/4/25
 * @Version v1.0
 */
public class No897 {

    public static void main(String[] args) {
        TreeNode root5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        //手動創建二元樹
        root5.left = node3;
        root5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node6.right = node8;
        node2.left = node1;
        node8.left = node7;
        node8.right = node9;

        Solution solution = new Solution();
        TreeNode treeNode = solution.increasingBST(root5);
        System.out.println(treeNode);
    }

    static class Solution {
        public TreeNode increasingBST(TreeNode root) {
            return increasingBST(root, null);
        }

        private TreeNode increasingBST(TreeNode root, TreeNode tail) {
            if (root == null) {
                return tail;
            }
            TreeNode res = increasingBST(root.left, root);
            root.left = null;
            root.right = increasingBST(root.right, tail);
            return res;
        }
    }
}
