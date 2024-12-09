package main.java.parctice.leetcode.data_structure.commomAlogrithm.floyd;

import java.util.Arrays;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class FloydDemo {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        final int N = 65535;
        int[][] matrix = {
                {0, 5, 7, N, N, N, 2},
                {5, 0, N, 9, N, N, 3},
                {7, N, 0, N, 8, N, N},
                {N, 9, N, 0, N, 4, N},
                {N, N, 8, N, 0, 5, 4},
                {N, N, N, 4, 5, 0, 6},
                {2, 3, N, N, 4, 6, 0},
        };
        Graph graph = new Graph(vertex.length, matrix, vertex);
        graph.floyd();
        graph.show();
    }
}

class Graph {
    //存放頂點的陣列
    private final char[] vertex;
    //保存，從各個項目出發到其他頂點的距離，最後的結果，也使保留在該陣列
    private final int[][] distance;
    //保存到達目標節點的前驅節點
    private final int[][] pre;

    /**
     * @param length 大小
     * @param matrix 鄰接矩陣
     * @param vertex 頂點陣列
     */
    public Graph(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.distance = matrix;
        this.pre = new int[length][length];
        //對pre陣列初始化，存放的是前驅頂點的索引
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }

    /**
     * 顯示pre跟distance陣列
     */
    public void show() {
        for (int[] line : distance) {
            System.out.println(Arrays.toString(line));
        }
        for (int[] line : pre) {
            for (int i : line) {
                System.out.print(this.vertex[i] + " ");
            }
            System.out.println();
        }
    }

    public void floyd() {
        //保存距離
        int length;
        //從中間節點遍歷，k就是中間節點的索引[A, B, C, D, E, F, G]
        for (int k = 0; k < distance.length; k++) {
            //從i節點開始出發[A, B, C, D, E, F, G]
            for (int i = 0; i < distance.length; i++) {
                for (int j = 0; j < distance.length; j++) {
                    //求出從i節點出發，經過k中間節點，達到j節點距離
                    length = distance[i][k] + distance[k][j];
                    //如果length小於distance[i][j]
                    if (length < distance[i][j]) {
                        //更新距離
                        distance[i][j] = length;
                        //更新前驅頂點
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}
