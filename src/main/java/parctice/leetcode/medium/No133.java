package parctice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No133 {

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {

        Node[] visited = new Node[101];

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            Node newNode = new Node(node.val);
            dfs(node, newNode);
            return newNode;
        }

        private void dfs(Node node, Node newNode) {
            visited[node.val] = newNode;
            for (Node neighbor : node.neighbors) {
                if (visited[neighbor.val] == null) {
                    Node newNeighbor = new Node(neighbor.val);
                    newNode.neighbors.add(newNeighbor);
                    dfs(neighbor, newNeighbor);
                } else {
                    newNode.neighbors.add(visited[neighbor.val]);
                }
            }
        }
    }

}
