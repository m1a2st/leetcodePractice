package leecode.medium;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @Author m1a2st
 * @Date 2023/7/16
 * @Version v1.0
 */
public class No230 {

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            setAllNodeInPq(root, pq);
            int ans = 0;
            for (int i = 0; i < k; i++) {
                ans = pq.poll();
            }
            return ans;
        }

        private void setAllNodeInPq(TreeNode root, PriorityQueue<Integer> pq) {
            if (root == null) return;
            pq.add(root.val);
            setAllNodeInPq(root.right, pq);
            setAllNodeInPq(root.left, pq);
        }
    }

    class Solution1 {
        public int kthSmallest(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            for (int i = 0; i < k - 1; i++) {
                TreeNode node = stack.pop();
                TreeNode left = node.left;
                while (left != null) {
                    stack.push(left);
                    left = left.right;
                }
            }
            return stack.peek().val;
        }
    }
}
