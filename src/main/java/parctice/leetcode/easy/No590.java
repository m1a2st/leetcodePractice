package main.java.parctice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class No590 {


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Solution {
        
        List<Integer> ans = new ArrayList<>();
        
        public List<Integer> postorder(Node root) {
            postorderNAry(root);
            return ans;
        }

        private void postorderNAry(Node root) {
            if (root == null) {
                return;
            }
            for (Node child : root.children) {
                postorderNAry(child);
            }
            ans.add(root.val);
        }
    }
}
