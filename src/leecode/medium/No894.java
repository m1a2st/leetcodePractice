package leecode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No894 {


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

        Map<Integer, List<TreeNode>> map = new HashMap<>();

        public List<TreeNode> allPossibleFBT(int n) {
            return allTree(n);
        }

        public List<TreeNode> allTree(int n) {
            List<TreeNode> rst = map.get(n);
            if (rst != null) {
                return rst;
            }
            rst = new ArrayList<>();
            if (n == 1) {
                rst.add(new TreeNode(0));
            }
            n -= 1;//root
            for (int i = 1; i <= n; i += 2) {
                List<TreeNode> left = allTree(i);
                List<TreeNode> right = allTree(n - i);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(0);
                        root.left = l;
                        root.right = r;
                        rst.add(root);
                    }
                }
            }
            map.put(n + 1, rst);
            return rst;
        }
    }
}
