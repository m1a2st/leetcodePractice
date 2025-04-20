package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author m1a2st
 * @Date 2023/7/13
 * @Version v1.0
 */
public class No199 {

    class Solution {

        List<Integer> res = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {
            addLevelRight(root, 0);
            return res;
        }

        private void addLevelRight(TreeNode root, int level) {
            if (root == null) return;
            if (level == res.size()) {
                res.add(root.val);
            }
            addLevelRight(root.right, level + 1);
            addLevelRight(root.left, level + 1);
        }
    }
}
