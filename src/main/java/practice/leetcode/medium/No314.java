package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class No314 {

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

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = solution.buildTree();
        List<List<Integer>> lists = solution.verticalOrder(root);
        lists.forEach(System.out::println);
    }

    class Solution {

        public TreeNode buildTree() {
            TreeNode root = new TreeNode(3);

            // 第二層
            root.left = new TreeNode(9);
            root.right = new TreeNode(8);

            // 第三層
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(0);
            root.right.left = new TreeNode(1);
            root.right.right = new TreeNode(7);

            // 第四層
            root.left.right.right = new TreeNode(2);  // 0 的右子節點是 2
            root.right.left.left = new TreeNode(5);   // 1 的左子節點是 5

            return root;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();

        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;

            // TreeMap 自動按 key 排序（列的順序）
            Map<Integer, List<Integer>> map = new TreeMap<>();

            // Queue 存放 (節點, 列號) 的配對
            Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
            queue.offer(new Pair<>(root, 0));

            while (!queue.isEmpty()) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int col = pair.getValue();

                // 加入對應列
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(node.val);

                // 左子節點：列號 -1
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, col - 1));
                }

                // 右子節點：列號 +1
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, col + 1));
                }
            }

            // 將 map 轉換為結果
            for (List<Integer> list : map.values()) {
                res.add(list);
            }

            return res;
        }

        class Pair<TreeNode, Integer> {
            private TreeNode key;
            private Integer value;

            public Pair(TreeNode key, Integer value) {
                this.key = key;
                this.value = value;
            }

            public TreeNode getKey() {
                return key;
            }

            public Integer getValue() {
                return value;
            }
        }
    }
}
