package practice.leetcode.data_structure.recursive;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class maze {
    public static void main(String[] args) {
        //先創建一個二維陣列模擬迷宮
        int[][] maze = new int[8][7];
        //使用1來表示牆
        //上下置為1
        for (int i = 0; i < 7; i++) {
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        //左右置為1
        for (int i = 0; i < 8; i++) {
            maze[i][0] = 1;
            maze[i][6] = 1;
        }
        maze[3][1] = 1;
        maze[2][2] = 1;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        //使用遞迴回溯給小球找路
        setWay(maze, 1, 1);
        //輸出新的地圖，小球走過，並標示過的遞迴
        System.out.println("=====================================");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用遞迴給小球找路
     * 說明
     * 1. maze表示迷宮
     * 2. i,j表示從哪個位置開始出發(1,1)
     * 3. 如果小球能到maze[6][5]，則說明找到路徑
     * 4. 規則：當maze[i][j]
     * 1. 為0表示該節點沒有走過，
     * 2. 為1時表示牆
     * 3. 為2表示道路可以走
     * 4. 為3表示該點已經走過，但是走不通
     * 5. 在走迷宮時，需要定義一個策略 下->右->上->左，如果該點走不通，再回溯
     *
     * @param maze 表示迷宮
     * @param i    從哪個位置開始找
     * @param j    TODO
     * @return 如果找到通路就返回true，否則就返回false
     */
    public static boolean setWay(int[][] maze, int i, int j) {
        if (maze[6][5] == 2) {
            return true;
        } else {
            //如果當前這個點還沒有走過
            if (maze[i][j] == 0) {
                //需要定義一個策略 下->右->上->左
                maze[i][j] = 2; //假定該點是可以走通
                if (setWay(maze, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(maze, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(maze, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(maze, i, j - 1)) {//向左走
                    return true;
                } else {
                    //說明該點是走不通的，是死路
                    maze[i][j] = 3;
                    return false;
                }
            } else { //如果map[i][j] != 0，可能1, 2, 3
                return false;
            }
        }
    }
}
