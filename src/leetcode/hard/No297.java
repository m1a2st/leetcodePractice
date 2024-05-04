package leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class No297 {

    @Test
    public void test() {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = codec.serialize(root);
        System.out.println(serialize);
    }


    //      Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            traversal(root, sb);
            return sb.deleteCharAt(sb.length() - 1).toString();
        }

        private void traversal(TreeNode root, StringBuilder sb) {
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sb.append(node.val).append(",");
                    if (node.left != null) {
                        queue.offer(node.left);
                    } else if (node.val != 1001) {
                        queue.offer(new TreeNode(1001));
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    } else if (node.val != 1001) {
                        queue.offer(new TreeNode(1001));
                    }
                }
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            if (arr.length == 0 || data.isEmpty()) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int i = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (i < arr.length && !arr[i].equals("1001")) {
                    node.left = new TreeNode(Integer.parseInt(arr[i]));
                    queue.offer(node.left);
                }
                i++;
                if (i < arr.length && !arr[i].equals("1001")) {
                    node.right = new TreeNode(Integer.parseInt(arr[i]));
                    queue.offer(node.right);
                }
                i++;
            }
            return root;
        }
    }
}
