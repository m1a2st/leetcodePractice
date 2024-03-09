package leecode.data_structure.sort;

import java.util.Date;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[8000000];
        int[] temp = new int[8000000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 800000);
        }

        Date startTime = new Date();
        long start = startTime.getTime();
        radixSort(arr);
        Date endTime = new Date();
        long end = endTime.getTime();
        System.out.println("總共花費的時間為： " + (end - start));
    }

    //基數排序方法
    public static void radixSort(int[] arr) {
        //1.得到陣列中最大數的位數
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = ("" + max).length();
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {


            //第i輪排序，針對每個元素的個位數進行處理
            //定義一個二維陣列，表示10個桶，每個桶就是一個一維陣列
        /*
            說明：
            1. 二位陣列包含一個意為陣列
            2. 為了防止再放入數的時候溢出，則每一個一維陣列的大小為arr.length
            3. 很明顯的，基數排序是使用空間換取時間的經典算法
         */
            int[][] bucket = new int[10][arr.length];

            //為了記錄每個桶中，實際存放了多少個數據，我們定義一個一維陣列來記錄各個桶每次放入的數據個數
            //bucketElementCounts[0]，紀錄的就是bucket[0]桶放入數據的個數
            int[] bucketElementCounts = new int[10];
            //針對每個元素的對應進行排序處理，第一次是個位，第二次是十位，第三次是百位....
            for (int j : arr) {
                //取出每個元素的個位數的數值
                int digitOfElement = j / n % 10;
                //放入到對應的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = j;
                bucketElementCounts[digitOfElement]++;
            }
            //按照這個桶的順序（一維陣列的下標依次取出數據，放入原來陣列）
            int index = 0;
            //遍歷每一個桶，並將桶中數據，放到原陣列
            for (int k = 0; k < bucket.length; k++) {
                //如果桶中有數據，我們才放入原陣列
                if (bucketElementCounts[k] != 0) {
                    //循環該桶（即第k個桶，即第k個一維陣列），放入數據即可
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到array中
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //第一輪處理後，需要將每個bucketElementCounts[k] = 0 （重要）
                bucketElementCounts[k] = 0;
            }
//            System.out.println(Arrays.toString(arr));
        }
    }
}
