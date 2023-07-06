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
            if(root == null){
                return null;
            }
            TreeNode right = root.right;
            TreeNode left = root.left;
            // 利用函數定義，翻轉左右子樹，並且交換節點
            root.left = invertTree(right);
            root.right = invertTree(left);
            // 和定義邏輯自恰：以 root 為根的這棵二叉樹已經被翻轉，返回 root
            return root;
        }
    }
}
