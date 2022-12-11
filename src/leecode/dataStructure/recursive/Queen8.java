package leecode.dataStructure.recursive;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class Queen8 {

    public static void main(String[] args) {
        //測試
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(count);
    }
    static int count;
    //定義一個值表示最多有幾個皇后
    int max = 8;
    //定義一個陣列array，保存皇后放置的結果，比如arr=[0, 4, 7, 5, 2, 6, 1, 3]
    int[] result = new int[max];

    //可以將皇后擺放的位置顯示出來
    private void print() {
        count++;
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    //編寫一個方法，放置第n個皇后
    //特別注意：check 是每一次遞迴時，進入到check中都有for (int i = 0; i < max; i++)，因此會有回溯
    private void check(int nQueen) {
        if (nQueen == max) { // nQueen == 8，其實8個皇后已然放好
            print();
            return;
        }
        //依次放入皇后，並判斷是否衝突
        for (int i = 0; i < max; i++) {
            //先把當前這個皇后n，放到該行的第一列
            result[nQueen] = i;
            //判斷當放置第n個皇后到第i列時，是否衝突
            if(judge(nQueen)){ //不衝突
                //接著放n+1個皇后，即開始遞迴
                check(nQueen+1);
            }
            //如果衝突，就繼續執行array[nQueen] = i;即將第n個皇后，放置在本行的後一個位置

        }
    }

    //查看當我們第n個皇后，就去檢測該皇后是否和前面已經擺放的皇后衝突

    /**
     * @param nQueen 表示擺放第n個皇后
     * @return
     */
    private boolean judge(int nQueen) {
        for (int row = 0; row < nQueen; row++) {
            /*
                說明：
                1. array[row] == array[nQueen] 表示判斷第n個皇后是否和前面的n-1個皇后在同一列
                2. Math.abs(nQueen - row) == Math.abs(array[nQueen] - array[row]) 俵是判斷第n個皇后是否和第i皇后在同一斜線
                   row = 1 放置第2列1 row = 1 array[1] = 1
                   Math.abs(1-0) == 1 Math.abs(array[nQueen] - array[row]) = Math.abs(1-0)=1
                3. 沒有必要，判斷是否在同一行，因為row每次都在遞增
             */
            if (result[row] == result[nQueen] || Math.abs(nQueen - row) == Math.abs(result[nQueen] - result[row])) {
                return false;
            }
        }
        return true;
    }

}
