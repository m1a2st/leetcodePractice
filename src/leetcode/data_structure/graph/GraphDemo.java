package leetcode.data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class GraphDemo {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        String[] vertexValue = {"A", "B", "C", "D", "E"};
        for (String vertex : vertexValue) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
//        graph.showGraph();

//        graph.dfs();
        graph.bfs();
    }
}

class Graph {
    //儲存頂點集合
    private final ArrayList<String> vertexList;
    //儲存圖對應的鄰結矩陣
    private final int[][] edges;
    //表示邊的數目
    private int numOfEdges;
    //定義一個陣列boolean[]，紀錄某個節點是否被訪問
    private final boolean[] isVisited;

    public Graph(int n) {
        this.edges = new int[n][n];
        this.vertexList = new ArrayList<>(n);
        this.numOfEdges = 0;
        isVisited = new boolean[n];
    }

    /**
     * 插入節點
     */
    public void insertVertex(String vertex) {
        this.vertexList.add(vertex);
    }

    /**
     * 添加邊
     * "A" - "B" "A" -> 0 "B" -> 1
     *
     * @param v1     表示第幾個結點
     * @param v2     表示第幾個結點
     * @param weight 關聯 1為有關聯 2為無關聯
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 得到節點數目
     *
     * @return 節點數
     */
    public int getNumberOfVertex() {
        return vertexList.size();
    }

    /**
     * 返回邊的數目
     *
     * @return 邊的數目
     */
    public int getNumOfEdges() {
        return this.numOfEdges;
    }

    /**
     * 返回索引值所對應節點的數據
     *
     * @param index 索引值
     * @return 節點的數據
     */
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    /**
     * 返回兩節點間的權值
     *
     * @param v1 表示第幾個結點
     * @param v2 表示第幾個結點
     * @return 兩節點間的權值
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 顯示圖的矩陣
     */
    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 得到第一個鄰接節點的索引
     *
     * @param index 欲被搜尋節點的索引值
     * @return 如果存在就返回對應的索引，否則返回 -1
     */
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }

        return -1;
    }

    /**
     * 深度優先遍歷
     * 1. 首先訪問該節點並且輸出
     * 2. 將節點設置為已訪問
     * 3. 查找結點v的第一個鄰接結點w
     *
     * @param isVisited 紀錄某個節點是否被訪問
     * @param index     第一次為0
     */
    private void dfs(boolean[] isVisited, int index) {
        System.out.printf(getValueByIndex(index) + "->");
        isVisited[index] = true;
        int w = getFirstNeighbor(index);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            //如果w節點已經被訪問過
            w = getNextNeighbor(index, w);
        }
    }

    /**
     * 遍歷所有的節點進行dfs
     */
    public void dfs() {
        for (int index = 0; index < getNumberOfVertex(); index++) {
            if (!isVisited[index]) {
                dfs(isVisited, index);
            }
        }
    }


    /**
     * 根據前一個領接節點的索引來獲取下一個領接節點
     *
     * @param v1 表示第幾個結點
     * @param v2 表示第幾個結點
     * @return TODO
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    private void bfs(boolean[] isVisited, int index) {
        //表示ArrayList頭節點的索引
        int rootIndex;
        //代表第一個鄰接節點的索引
        int neighborIndex;
        //ArrayList，紀錄節點訪問順序
        LinkedList<Integer> queue = new LinkedList<>();
        //訪問節點
        System.out.print(getValueByIndex(index) + "->");
        isVisited[index] = true;
        //將節點加入List
        queue.addLast(index);
        while (!queue.isEmpty()) {
            //取出List頭節點
            rootIndex = queue.removeFirst();
            //得到第一個臨接節點的索引
            neighborIndex = getFirstNeighbor(rootIndex);
            while (neighborIndex != -1) {
                //是否訪問過
                if (!isVisited[neighborIndex]) {
                    System.out.print(getValueByIndex(neighborIndex) + "->");
                    //標記已訪問
                    isVisited[neighborIndex] = true;
                    queue.addLast(neighborIndex);
                }
                //以 rootIndex，找neighborIndex下一個鄰接節點
                neighborIndex = getNextNeighbor(rootIndex, neighborIndex);//體現出廣度優先
            }
        }
    }

    /**
     * 遍歷所有的節點進行bfs
     */
    public void bfs() {
        for (int index = 0; index < getNumberOfVertex(); index++) {
            if (!isVisited[index]) {
                bfs(isVisited, index);
            }
        }
    }
}
