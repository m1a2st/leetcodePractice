package leetcode.data_structure.array;

import java.io.*;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class SparseArray {

    public static void main(String[] args) {
        //創造一個11*11的二維陣列
        //0：表示沒有棋子，1：表示黑子，2：表示藍子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        //輸出原始二維陣列
        for (int[] row : chessArr) {
            for (int point : row) {
                System.out.printf("%d\t", point);
            }
            System.out.println();
        }
        //將二維陣列轉成稀疏陣列
        //1. 先遍歷二維陣列得到非0數據個數
        int sum = 0;
        for (int[] row : chessArr) {
            for (int point : row) {
                if (point != 0) {
                    sum++;
                }
            }
        }
        //2. 創建對應的稀疏陣列
        int[][] sparseArr = new int[sum + 1][3];
        //3. 給稀疏陣列賦值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍歷二維陣列將非0的值存入稀疏陣列中
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        //輸出稀疏陣列
        for (int[] row : sparseArr) {
            for (int point : row) {
                System.out.printf("%d\t", point);
            }
            System.out.println();
        }
        //寫出檔案
        File file = new File("sparseArr.txt");
        try (FileOutputStream out = new FileOutputStream(file);
             BufferedOutputStream bf = new BufferedOutputStream(out);
             PrintStream ps = new PrintStream(bf)) {

            for (int[] row : sparseArr) {
                for (int point : row) {
                    ps.printf("%d\t", point);
                }
                ps.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //讀取檔案
        try {
            int i;
            FileReader fr =new FileReader(file);
            while ((i = fr.read()) != -1){
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //將稀疏陣列-->恢復成原始的二維陣列
        //先讀取稀疏陣列的第一行，根據地一行的數據，創建原始的二維陣列
        int[][] chessArrNew = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArrNew[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int[] row : chessArrNew) {
            for (int point : row) {
                System.out.printf("%d\t", point);
            }
            System.out.println();
        }
    }
}
