package leecode.medium;

import java.util.*;

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
}
