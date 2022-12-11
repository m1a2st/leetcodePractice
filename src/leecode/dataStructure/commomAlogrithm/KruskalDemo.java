package leecode.dataStructure.commomAlogrithm;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class KruskalDemo {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0},
        };
        Kruskal kruskal = new Kruskal(vertex, matrix);
//        kruskal.print();
//        EData[] edges = kruskal.getEdges();
//        kruskal.sortEdges(edges);
//        System.out.println(Arrays.toString(edges));
        kruskal.kruskal();
    }
}

class Kruskal {
    // 邊的個數
    private int edgeNum;
    // 頂點陣列
    private final char[] vertex;
    // 鄰接矩陣
    private final int[][] matrix;
    // 表示兩個節點不能連通的權值
    private static final int INF = Integer.MAX_VALUE;

    public Kruskal(char[] vertex, int[][] matrix) {
        //初始化節點和邊的個數
        int vNum = vertex.length;
        //初始化節點，使用複製的方式
        this.vertex = new char[vNum];
        System.arraycopy(vertex, 0, this.vertex, 0, vertex.length);
        //初始化邊
        this.matrix = new int[vNum][vNum];
        for (int i = 0; i < vNum; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, vNum);
        }
        //統計邊
        for (int i = 0; i < vNum; i++) {
            for (int j = i + 1; j < vNum; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 使用冒泡排序，對邊進行排序處理
     *
     * @param eData edge邊的集合
     */
    public void sortEdges(EData[] eData) {
        for (int i = 0; i < eData.length - 1; i++) {
            for (int j = 0; j < eData.length - 1 - i; j++) {
                if (eData[j].weight > eData[j + 1].weight) {
                    EData temp = eData[j];
                    eData[j] = eData[j + 1];
                    eData[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 搜尋頂點得索引值
     *
     * @param ch 節點的值，比如'A','B'
     * @return 返回ch節點對應的索引，如果找不到返回-1
     */
    public int getPosition(char ch) {
        for (int index = 0; index < vertex.length; index++) {
            if (vertex[index] == ch) {
                return index;
            }
        }
        return -1;
    }

    /**
     * 獲取圖中的邊，放到EData[]陣列中
     * 是透過matrix 鄰接矩陣來獲取
     * EData[] 形式[['A','B',12],['B','F',7],...]
     *
     * @return EData[]
     */
    public EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = i + 1; j < vertex.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertex[i], vertex[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 獲取索引為index的終點，用於後面判斷兩個節點的終點是否相同
     *
     * @param ends  紀錄了各個頂點對應的終點是哪個，ends陣列是遍歷過程中，逐步形成
     * @param index 表示傳入節點的索引
     * @return 返回索引為index這個節點的終點之索引
     */
    public int getEnd(int[] ends, int index) {
        while (ends[index] != 0) {
            index = ends[index];
        }
        return index;
    }

    public void kruskal() {
        //表示最後陣列的索引
        int index = 0;
        //用於保存"已有最小生成樹"中的每個節點在“最小生成樹的終點”
        int[] ends = new int[edgeNum];
        //創建結果陣列，保存最後的最小生成樹
        EData[] result = new EData[edgeNum];
        //獲取圖中所有邊的集合，一共有12條邊
        EData[] edges = getEdges();
        //首先按照邊的權值大小排序（從小到大）
        sortEdges(edges);
        //遍歷edges陣列，將邊添加到最小陣列時，判斷準備加入的邊是否構成迴路，如果沒有，就加入result，否則不能加入
        for (int i = 0; i < edgeNum; i++) {
            //獲取到第i條邊的第一個節點（起點）
            int startVertex = getPosition(edges[i].startVertex); //startVertex = 4
            //獲取到第i條邊的第二個節點
            int endVertex = getPosition(edges[i].endVertex); //endVertex = 5
            //獲取startVertex這個頂點在已有最小生成樹的終點
            int startEndVertex = getEnd(ends, startVertex); //startEndVertex = 4
            //獲取endVertex這個頂點在已有最小生成樹的終點
            int endEndVertex = getEnd(ends, endVertex); //endEndVertex = 5
            //受否構成迴路
            if (startEndVertex != endEndVertex) { //沒有構成迴路
                //設置startEndVertex在“已有最小生成樹中的終點”<E, F> [0,0,0,0,5,0,0,0,0,0,0,0]
                ends[startEndVertex] = endEndVertex;
                //有一條邊加入result陣列
                result[index++] = edges[i];
            }
        }
        //統計並打印最小生成樹，輸出result
        for(EData eData :result){
            if(eData != null){
                System.out.println(eData);
            }
        }

    }

}

//表示一條邊
class EData {
    //表示邊的起點
    char startVertex;
    //邊的另外一個點
    char endVertex;
    //邊的權值
    int weight;

    public EData(char startVertex, char endVertex, int weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "<" + startVertex +
                ", " + endVertex + ">" +
                ", weight=" + weight +
                '}';
    }
}