package leetcode.data_structure.commomAlogrithm.horse;

import java.awt.*;
import java.time.Duration;
import java.util.*;
import java.util.List;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class HorseChess {
    //棋盤的列數
    private static int x;
    //棋盤的行數
    private static int y;
    //標記棋盤的各位置是否被訪問過
    private static boolean[] visited;
    //標記棋盤是否被訪問完，如果為true表示成功
    private static boolean finished;

    /**
     * 根據當前位置（point對象），計算馬兒還能走哪些位置（point對象），並放入到一個集合中(ArrayList), 最多有8個位置
     *
     * @param curPoint 馬可以走得點，最多8個
     * @return 可以走的集合
     */
    public static List<Point> next(Point curPoint) {
        List<Point> points = new ArrayList<>();
        Point point = new Point();
        //表示馬可以走5這個位置
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y - 1) >= 0) {
            points.add(new Point(point));
        }
        //表示馬可以走6這個位置
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y - 2) >= 0) {
            points.add(new Point(point));
        }
        //表示馬可以走7這個位置
        if ((point.x = curPoint.x + 1) < x && (point.y = curPoint.y - 2) >= 0) {
            points.add(new Point(point));
        }
        //表示馬可以走0這個位置
        if ((point.x = curPoint.x + 2) < x && (point.y = curPoint.y - 1) >= 0) {
            points.add(new Point(point));
        }
        //表示馬可以走1這個位置
        if ((point.x = curPoint.x + 2) < x && (point.y = curPoint.y + 1) < y) {
            points.add(new Point(point));
        }
        //表示馬可以走2這個位置
        if ((point.x = curPoint.x + 1) < x && (point.y = curPoint.y + 2) < y) {
            points.add(new Point(point));
        }
        //表示馬可以走3這個位置
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y + 2) < y) {
            points.add(new Point(point));
        }
        //表示馬可以走4這個位置
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y + 1) < y) {
            points.add(new Point(point));
        }
        return points;
    }

    /**
     * @param chessBoard 棋盤
     * @param row        馬當前的行，從0開始
     * @param column     馬當前的列，從0開始
     * @param step       是第幾步，初始位置就是第一步
     */
    public static void traversal(int[][] chessBoard, int row, int column, int step) {
        chessBoard[row][column] = step;
        //row = 4 ,x= 8 column = 4 => 36
        visited[row * x + column] = true; //標記該位置已訪問
        //獲取當前位置可以走的下一個位置集合
        List<Point> points = next(new Point(column, row));
        //對points進行排序，根據當前這一步的所有下一步選擇位置，進行非遞減排序
        sort(points);
        //遍歷points
        while (!points.isEmpty()) {
            //出下一個可以走的位置
            Point point = points.remove(0);
            //判斷該點是否已經訪問過
            if (!visited[point.y * x + point.x]) {//說明還沒有訪問過
                traversal(chessBoard, point.y, point.x, step + 1);
            }
        }
        //判斷馬兒是否完成了任務，使用step和應該走的步數比較，
        //如果沒有達到數量，則表示沒有完成任務，將整個棋盤置0
        // 說明： step < x * y 成立情況有兩種
        // 1. 棋盤目前還沒走完
        // 2. 目前處於回溯狀態中
        if (step < x * y && !finished) {
            chessBoard[row][column] = 0;
            visited[row * x + column] = false;
        } else {
            finished = true;
        }
    }

    //根據當前這一步的所有下一步選擇位置，進行非遞減排序
    public static void sort(List<Point> points) {
        points.sort((o1, o2) -> {
            //獲取到o1下一步的所有位置
            int count1 = next(o1).size();
            int count2 = next(o2).size();
            return Integer.compare(count1, count2);
        });
    }

    public static void main(String[] args) {
        x = 8;
        y = 8;
        //馬初始位置
        int row = 1;
        int column = 1;
        //創建棋牌
        int[][] chessBoard = new int[x][y];
        //初始值都是false
        visited = new boolean[x * y];
        Date start = new Date();
        traversal(chessBoard, row - 1, column - 1, 1);
        Date end = new Date();
        Duration between = Duration.between(start.toInstant(), end.toInstant());
        System.out.println(between.getSeconds());

        for (int[] rows : chessBoard) {
            System.out.println(Arrays.toString(rows));
        }
    }
}
