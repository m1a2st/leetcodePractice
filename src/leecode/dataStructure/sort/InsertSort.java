package leecode.dataStructure.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class InsertSort {
    /**
     * 說明：
     * 1. 因為第一個數是不動的，所以是從第二個數來判斷，因此定義兩個區域變量
     *    1. insertVal :定義插入的數
     *    2. insertIndex :即arr[i]的前面這個數的下標
     * 2. 幫insertVal找到插入位置
     *    1. insertIndex >= 0 保證給insertVal 找插入位置，不越界
     *    2. insertVal < arr[insertIndex] 待插入的數，還沒有找到插入位置
     *    3. 就需要將arr[insertIndex] 後移
     * 3. 如果值的順序並沒有變動，insertIndex並不會有改變，所以可以用來判斷是否需要賦值
     * 4. 退出while循環時，說明插入位置找到，insertIndex + 1
     * (要變成從大到小，把判斷的 < 改成 > 就可以了)
     * @param arr 想要被排序的陣列
     */
    public static void insertSort(int[] arr) {
        for (int index = 1; index < arr.length; index++) {
            int insertVal = arr[index];
            int insertIndex = index - 1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != index) {
                arr[insertIndex + 1] = insertVal;
            }
//            System.out.printf("第%d趟排序\n", index );
//            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        //測試冒泡排序的速度O(n^2)
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        Date startTime = new Date();
        long start = startTime.getTime();
        insertSort(arr);
        Date endTime = new Date();
        long end = endTime.getTime();
        System.out.println("總共花費的時間為： " + (end - start));
    }
}
