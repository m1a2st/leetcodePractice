package leecode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author m1a2st
 * @Date 2023/7/4
 * @Version v1.0
 */
public class No226 {

    class Solution {
        // 定義：將以 root 為根的這棵二叉樹翻轉，返回翻轉後的二叉樹的根節點
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.right = invertTree(left);
            root.left = invertTree(right);
            return root;
        }
    }
}
