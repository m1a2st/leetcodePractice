package parctice.leetcode.data_structure.tree;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        // 1,2,4,5,3,6,7
        arrBinaryTree.preOrder();
        // 4,2,5,1,6,3,7
        arrBinaryTree.infixOrder();
        //4,5,2,6,1,3,7
        arrBinaryTree.postOrder();
    }

}

//編寫一個arrayBinaryTree，實現順序存取二元數
class ArrBinaryTree {
    private final int[] arr;//儲存數據節點的陣列

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;

    }

    //overload preOrder
    public void preOrder() {
        this.preOrder(0);
    }

    public void infixOrder() {
        this.infixOrder(0);
    }

    public void postOrder() {
        this.postOrder(0);
    }

    /**
     * 完成儲存二元數的前序遍歷
     * 1. 先判斷此陣列是否為空
     * 2. 輸出當前元素
     * 3. 向左遞迴遍歷
     * 4. 向右遞迴遍歷
     *
     * @param index 陣列的索引
     */
    private void preOrder(int index) {
        if (arr.length == 0) {
            System.out.println("This array is empty.");
        }

        System.out.println(arr[index]);


        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    /**
     * 完成儲存二元數的中序遍歷
     * 1. 先判斷此陣列是否為空
     * 2. 向左遞迴遍歷
     * 3. 輸出當前元素
     * 4. 向右遞迴遍歷
     *
     * @param index 陣列的索引
     */
    private void infixOrder(int index) {
        if (arr.length == 0) {
            System.out.println("This array is empty.");
            return;
        }
        if ((index * 2 + 1) < arr.length) {
            infixOrder(index * 2 + 1);
        }
        System.out.println(arr[index]);
        if ((index * 2 + 2) < arr.length) {
            infixOrder(index * 2 + 2);
        }
    }

    /**
     * 完成儲存二元數的中序遍歷
     * 1. 先判斷此陣列是否為空
     * 2. 向左遞迴遍歷
     * 3. 向右遞迴遍歷
     * 4. 輸出當前元素
     *
     * @param index 陣列的索引
     */
    private void postOrder(int index) {
        if (arr.length == 0) {
            System.out.println("This array is empty.");
            return;
        }
        if ((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }

        if ((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }
        System.out.println(arr[index]);
    }
}
