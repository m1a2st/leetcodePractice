package practice.se.ex1.module12_15;

/*
 * 觀察陣列的傳值
 * 此範例使用指定運算子(=)
 */
public class TestAssignArray1 {

    public static void main(String[] args) {
        int[] intArray1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 將 intArray1指定給 intArray2
        int[] intArray2 = intArray1;

        // 將intArray2所有元素改成0
        for (int i = 0; i < intArray2.length; i++)
            intArray2[i] = 0;

        // 列印原來 intArray1所有元素,也會跟著改變
        for (int i = 0; i < intArray1.length; i++)
            System.out.println(intArray1[i]);
    }

}
