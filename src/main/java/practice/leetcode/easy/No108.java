package practice.leetcode.easy;

public class No108 {


    // Definition for a binary tree node.
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

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }

        private TreeNode build(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            final int m = (left + right) / 2;
            return new TreeNode(nums[m], build(nums, left, m - 1), build(nums, m + 1, right));
        }
    }

    class SolutionNew {
        public TreeNode sortedArrayToBST(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }

        private TreeNode build(int[] nums, int left, int right) {
            if (left < right) {
                return null;
            }
            int mid = (left + right) / 2;
            return new TreeNode(nums[mid], build(nums, left, mid - 1), build(nums, mid + 1, right));
        }
    }
}
