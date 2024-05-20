package leetcode.data_structure.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    /**
     * 思想：
     * 1. 遍歷arr陣列
     * 2. 將arr的每個元素構成一個Node
     * 3. 將Node放入ArrayList中
     * 4. 從小大到排序
     * 5. 取出根結點權值最小的兩顆二元樹
     * 5.1取出權值最小的節點（二元樹）
     * 5.2取出權值第二小的節點（二元樹）
     * 5.3構建一顆新的二元數
     * 5.4從ArrayList刪除處理過的節點
     * 5.5將parentNode加入到nodes
     *
     * @param arr 要成為赫夫曼樹的陣列
     * @return 創建好赫夫曼樹的根節點
     */
    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        Collections.sort(nodes);
        while (nodes.size() > 1) {
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parentNode = new Node(leftNode.value + rightNode.value);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
            Collections.sort(nodes);
        }
        return nodes.get(0);
    }

    /**
     * 前序遍歷
     *
     * @param root 根節點
     */
    public static void preOrder(Node root) {
        if (root == null) {
            System.out.println("This Huffman Tree is empty");
        } else {
            root.preOrder();
        }
    }
}

/**
 * 為了讓Node2對象可以使用Collections集合排序
 * 讓Node實現Comparable介面
 */
class Node implements Comparable<Node> {
    public int value; //節點權值
    char c; //字符
    public Node left; //指向左子節點
    public Node right; //指向右子節點

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 從小到大排序
     */
    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    /**
     * 前序遍歷
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
