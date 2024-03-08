package leecode.medium;

import java.util.*;
import java.util.LinkedList;

import static kotlin.reflect.jvm.internal.impl.utils.DFS.dfs;

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
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Node[] visited = new Node[101];
            Node newNode = new Node(node.val);
            dfs(node, newNode, visited);
            return newNode;
        }

        private void dfs(Node node, Node newNode, Node[] visited) {
            visited[newNode.val] = newNode;
            for (Node neighbor : node.neighbors) {
                if (visited[neighbor.val] == null) {
                    Node n = new Node(neighbor.val);
                    newNode.neighbors.add(n);
                    dfs(neighbor, n, visited);
                } else {
                    newNode.neighbors.add(visited[neighbor.val]);
                }
            }
        }
    }

    class SolutionNew2 {

        Node[] visited = new Node[101];

        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Node newNode = new Node(node.val);
            dfs(newNode, node);
            return newNode;
        }

        private void dfs(Node newNode, Node node) {
            visited[newNode.val] = newNode;
            for (Node neighbor : node.neighbors) {
                if (visited[neighbor.val] == null) {
                    Node newNeighborNode = new Node(neighbor.val);
                    newNode.neighbors.add(newNeighborNode);
                    dfs(newNeighborNode, neighbor);
                } else {
                    newNode.neighbors.add(visited[neighbor.val]);
                }
            }
        }
    }
}
