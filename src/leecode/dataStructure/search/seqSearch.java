package leecode.dataStructure.search;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class seqSearch {
    public static void main(String[] args) {
        int[] arr = {1, 9, 5, 3, 6, 7};
        int index = seqSearch(arr,6);
        System.out.println(index);
    }

    /**
     * 線性搜尋是逐一比對，發現有相同的值，就返回下標
     * 這裡實現的線性搜尋是找到一個滿足條件的值就返回
     * @param arr 欲搜尋的陣列
     * @param target 欲被搜尋的值
     * @return index
     */
    public static int seqSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if(target == arr[i]){
                return i;
            }
        }
        return -1;
    }
}
