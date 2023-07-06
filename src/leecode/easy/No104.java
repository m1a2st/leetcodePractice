package leecode.easy;

/**
 * @Author m1a2st
 * @Date 2023/7/6
 * @Version v1.0
 */
public class No104 {

    class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            int right = maxDepth(root.right) + 1;
            int left = maxDepth(root.left) + 1;
            return Math.max(right, left);
        }
    }
}
