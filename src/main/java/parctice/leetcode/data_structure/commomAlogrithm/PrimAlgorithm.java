package main.java.parctice.leetcode.data_structure.commomAlogrithm;

import java.util.Arrays;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertx = data.length;
        int[][] weight = {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        //創建Graph物件
        Graph graph = new Graph(vertx);
        //創建minTree
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, vertx, data, weight);
//        minTree.showGraph(graph);
        minTree.prim(graph, 0);
    }
}

//創建最小生成樹
class MinTree {

    /**
     * 創建圖的鄰接陣列
     *
     * @param graph  圖物件
     * @param vertx  圖對應的頂點個數
     * @param data   圖對應各個頂點的值
     * @param weight 圖的鄰接矩陣
     */
    public void createGraph(Graph graph, int vertx, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < vertx; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < vertx; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(Graph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 得到最小生成數
     *
     * @param graph      圖
     * @param vertxIndex 表示從圖的第幾個頂點開始 'A' -> 0, 'B' -> 1
     */
    public void prim(Graph graph, int vertxIndex) {
        //標記節點是否被訪問過，默認元素的值為0，表示沒有訪問過
        int[] visited = new int[graph.vertx];
        //把當前節點標記為已訪問
        visited[vertxIndex] = 1;
        //紀錄兩個節點的索引
        int h1 = -1;
        int h2 = -1;
        //將minWeight 初始化為一個大數，後面遍歷過程中，會被替換
        int minWeight = 10000;
        //因為有graph.vertx個頂點，普利姆算法結束後，會有graph.vertx-1條邊
        for (int k = 1; k < graph.vertx; k++) {
            //這個是確定每一次生成的子圖，和哪個節點的距離最近
            for (int i = 0; i < graph.vertx; i++) {// i節點表示被訪問過的節點
                for (int j = 0; j < graph.vertx; j++) {// j表示還沒有被訪問過的
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替換minWeight（尋找已訪過的節點，何未訪問過節點邊的權值）
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一條邊
            System.out.println("edge: " + graph.data[h1] + " edge: " + graph.data[h2] + " weight: " + minWeight);
            //將當前這個節點標記為已訪問
            visited[h2] = 1;
            //將minWeight 重製成 10000;
            minWeight = 10000;
        }
    }
}


class Graph {
    //表示節點個數
    int vertx;
    //存放節點數據
    char[] data;
    //存放邊，圖的鄰接矩陣
    int[][] weight;

    public Graph(int vertx) {
        this.vertx = vertx;
        data = new char[vertx];
        weight = new int[vertx][vertx];
    }
}
