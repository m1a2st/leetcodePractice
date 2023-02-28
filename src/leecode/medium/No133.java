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
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        //        public Node cloneGraph(Node node) {
//            if (node == null) return null;
//            //Map用來儲存新舊節點對應關係，用來區分已clone何未clone的節點
//            Map<Node, Node> map = new HashMap<>();
//            Queue<Node> queue = new LinkedList<>();
//            queue.add(node);
//            map.put(node, new Node(node.val));
//            while (!queue.isEmpty()) {
//                Node cur = queue.poll();
//                for (Node neighbor : cur.neighbors) {
//                    if (!map.containsKey(neighbor)) {
//                        queue.add(neighbor);
//                        map.put(neighbor, new Node(neighbor.val));
//                    }
//                    map.get(cur).neighbors.add(map.get(neighbor));
//                }
//            }
//            return map.get(node);
//        }
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
}
