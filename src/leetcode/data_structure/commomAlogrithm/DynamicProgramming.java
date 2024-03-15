package leetcode.data_structure.commomAlogrithm;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        //物品重量
        int[] weight = {1, 4, 3};
        //物品價值
        int[] value = {1500, 3000, 2000};
        //背包容量
        int bag = 4;
        //物品個數
        int count = weight.length;
        //為了記錄放入商品的情況，定義一個二維陣列
        int[][] path = new int[count + 1][bag + 1];
        //表示v[i][j]表示在前i個物品中能夠裝入容量為j的背包中的最大價值。
        int[][] max = new int[count + 1][bag + 1];
        //初始化第一行第一列
        for (int i = 0; i < max.length; i++) {
            //把第一列設置為0
            max[i][0] = 0;
        }
        for (int i = 0; i < max[0].length; i++) {
            //把第一行設置為0
            max[0][i] = 0;
        }
        //根據公式動態規劃處理
        for (int i = 1; i < max.length; i++) { //不處理第一行，i是從1開始的
            for (int j = 1; j < max[0].length; j++) { //不處理第一列，j是從1開始的
                if (weight[i - 1] > j) {
                    //因為程式i是從1開始的，因此從原來公式中的w[i] 修改成 w[i-1]
                    max[i][j] = max[i - 1][j];
                } else {
                    //因為程式i是從1開始的，因此從原來公式中的val[i] 修改成 val[i-1]
                    //max[i][j] = Math.max(max[i - 1][j], value[i - 1] + max[i - 1][j - weight[i - 1]]);
                    //為了記錄商品存放到背包的情況，不能使用直接max，要改成if else
                    if (max[i - 1][j] < value[i - 1] + max[i - 1][j - weight[i - 1]]) {
                        max[i][j] = value[i - 1] + max[i - 1][j - weight[i - 1]];
                        path[i][j] = 1;
                    } else {
                        max[i][j] = max[i - 1][j];
                    }
                }
            }
        }
        //輸出最後紀錄的商品
        //只需要最後一次的放入情況
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) { //逆向遍歷
            if(path[i][j] == 1){
                System.out.printf("第%d個商品放入背包\n",i);
                j -= weight[i-1];
            }
            i--;
        }
    }

}
