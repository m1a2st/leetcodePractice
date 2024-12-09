package parctice.se.ex1.module12_15;

public class TestBubble {

    public static void main(String[] args) {
        int[] a = {38, 27, 19, 56, 92, 1, 68, 72, 100, 43};
        // 泡沫排序法
        for (int i = 0; i < a.length - 1; i++) { // 從a[0]比到a[8]，比較a[9]沒有意義
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j + 1]; // 交換陣列元素
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
