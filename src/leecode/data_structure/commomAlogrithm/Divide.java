package leecode.data_structure.commomAlogrithm;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class Divide {
    public static void main(String[] args) {
        hanoiTower(5,'a','b','c');
    }

    /**
     * 漢諾塔問題，使用分治算法
     * @param num 總共幾個盤子
     * @param a 塔A
     * @param b 塔B
     * @param c 塔C
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1個盤從 " + a + " -> " + c);
        } else {
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "個盤從 " + a + " -> " + c);
            hanoiTower(num - 1, b, a, c);
        }
    }
}
