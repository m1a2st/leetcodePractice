package parctice.leetcode.data_structure.commomAlogrithm.dijkstra;

import java.util.Arrays;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class DijkstraDemo {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        final int N = 65535;
        int[][] matrix = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N},
        };
        Graph graph = new Graph(vertex, matrix);
        graph.showGraph();
        graph.dijkstra(6);
        graph.show();
    }
}

class VisitedVertex {
    //紀錄各個頂點是否訪問過，1表示訪問過，0未訪問，回動態更新
    public int[] alreadyArr;
    //每個索引對應的值為前一個節點的索引，會動態更新
    public int[] preVisited;
    //紀錄出發頂點到其他所有頂點的距離，比如說G為出發節點，就會紀錄G到其他節點的距離，會動態更新，求得最短距離就會放到dis
    public int[] distance;

    /**
     * @param length 表示節點的個數
     * @param index  出發節點對應的索引，比如G頂點，索引就是6
     */
    public VisitedVertex(int length, int index) {
        this.alreadyArr = new int[length];
        this.preVisited = new int[length];
        this.distance = new int[length];
        //初始化distance
        Arrays.fill(distance, 65535);
        //設置出發頂點被訪問過
        this.alreadyArr[index] = 1;
        //設置出發頂點的訪問距離為0
        this.distance[index] = 0;
    }

    /**
     * 判斷index索引對應的頂點是否被訪問過
     *
     * @param index 查找頂點的索引
     * @return 如果訪問過就返回true，沒有就返回false
     */
    public boolean isVisited(int index) {
        return alreadyArr[index] == 1;
    }

    /**
     * 更新出發節點到index這個索引頂點的距離
     *
     * @param index  更新節點的索引
     * @param length 更新的距離是多少
     */
    public void updateDistance(int index, int length) {
        distance[index] = length;
    }

    /**
     * 更新pre這個節點的前驅節點為index的節點
     *
     * @param pre   TODO
     * @param index 更新節點的索引
     */
    public void updatePre(int pre, int index) {
        preVisited[pre] = index;
    }

    /**
     * 返回出發節點到index索引節點的距離
     *
     * @param index index索引的節點
     * @return 出發節點到index索引節點的距離
     */
    public int getDistance(int index) {
        return distance[index];
    }

    /**
     * 繼續選擇並返回新的節點，比如說這裡的G訪問完後，
     * 就是A節點作為新的訪問節點（注意不是出發節點）
     *
     * @return TODO
     */
    public int updateAlreadyArr() {
        int min = 65535, index = 0;
        for (int i = 0; i < alreadyArr.length; i++) {
            if (alreadyArr[i] == 0 && distance[i] < min) {
                min = distance[i];
                index = i;
            }
        }
        //更新index節點被訪問過
        alreadyArr[index] = 1;
        return index;
    }


    /**
     * 顯示最後結果
     */
    public void show() {
        System.out.println("============================");
        for (int i : this.alreadyArr) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : this.preVisited) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : this.distance) {
            System.out.print(i + " ");
        }
        System.out.println();
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int count = 0;
        for (int i : distance) {
            if (i != 65535) {
                System.out.println(vertex[count] + "( " + i + " )");
                count++;
            }
        }
    }
}


class Graph {
    //節點陣列
    private final char[] vertex;
    //鄰接矩陣
    private final int[][] matrix;
    //已經訪問頂點的集合
    private VisitedVertex visitedVertex;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    /**
     * 顯示圖
     */
    public void showGraph() {
        for (int[] link : matrix) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * @param index 表示出發節點對應的索引
     */
    public void dijkstra(int index) {
        this.visitedVertex = new VisitedVertex(vertex.length, index);
        //更新index節點到周圍節點的距離與前驅節點
        update(index);
        for (int j = 1; j < this.vertex.length; j++) {
            //選擇並返回新的訪問節點
            index = this.visitedVertex.updateAlreadyArr();
            //更新index節點到周圍節點的距離與前驅節點
            update(index);
        }
    }

    /**
     * 更新index索引節點的周圍節點的距離和周圍節點的前驅節點
     *
     * @param index TODO
     */
    private void update(int index) {
        int length;
        //根據遍歷我們的鄰接矩陣的matrix[index]行
        for (int j = 0; j < matrix[index].length; j++) {
            //length含義是：出發節點到index節點距離+從index節點到j節點距離的和
            length = this.visitedVertex.getDistance(index) + matrix[index][j];
            //如果j頂點沒有被訪問過，並且length小於出發節點到j節點的距離，就需要更新
            if (!this.visitedVertex.isVisited(j) && length < this.visitedVertex.getDistance(j)) {
                //更新j節點，前驅為index節點
                this.visitedVertex.updatePre(j, index);
                //更新出發節點到j節點的距離
                this.visitedVertex.updateDistance(j, length);
            }
        }
    }

    public void show() {
        this.visitedVertex.show();
    }

}
