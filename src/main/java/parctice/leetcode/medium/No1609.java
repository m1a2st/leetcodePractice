package parctice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class No1609 {

    class Solution {

        List<Integer> oddNumber = new ArrayList<>();
        List<Integer> evenNumber = new ArrayList<>();

        public boolean isEvenOddTree(TreeNode root) {
            traversal(root, 0);
            return checkList(oddNumber) && checkList(evenNumber);
        }

        private boolean checkList(List<Integer> oddNumber) {
            return false;
        }

        private void traversal(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if ((level & 1) == 1) {
                oddNumber.add(root.val);
            } else {
                evenNumber.add(root.val);
            }
            traversal(root.left, level + 1);
            traversal(root.right, level + 1);
        }
    }
}
