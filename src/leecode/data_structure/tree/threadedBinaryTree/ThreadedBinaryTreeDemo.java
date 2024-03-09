package leecode.data_structure.tree.threadedBinaryTree;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "SuperMan");
        HeroNode node2 = new HeroNode(3, "Batman");
        HeroNode node3 = new HeroNode(6, "SpiderMan");
        HeroNode node4 = new HeroNode(8, "GreenMan");
        HeroNode node5 = new HeroNode(10, "King");
        HeroNode node6 = new HeroNode(14, "IronMan");

        ThreadedBinaryTree binaryTree = new ThreadedBinaryTree();
        binaryTree.setRoot(root);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        binaryTree.threadedNodes();

        binaryTree.threadList();

    }
}

//實現線索化功能的二元數
class ThreadedBinaryTree {
    private HeroNode root;
    //為了實現線索化，需要創建要給指向當前節點的前驅節點指針
    //在遞迴進行線索化時，pre總是保留前一個節點
    private HeroNode pre;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes(){
        this.threadedNodes(root);
    }

    /**
     * 遍歷線索化二元數
     * 分析：
     * 1. 定義一個變量，儲存當前遍歷的節點，從root開始
     * 2. 循環找到leftType == 1 的節點，第一個找到就是8節點
     *    後面隨著遍歷而變化，因為當leftType == 1時，說明該節點是按照線索化處理後的有效節點
     * 3. 打印當前節點
     * 4. 如果當前節點的後繼指針指向的是後繼節點，就一直輸出
     * 5. 獲取到當前節點的後繼節點
     * 6. 替換節點
     */
    public void threadList(){
        HeroNode node = root;
        while(node != null){
            while (node.leftType == 0){
                node = node.left;
            }
            System.out.println(node);
            while(node.rightType == 1){
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }
    }

    /**
     * 對二元樹進行中序線索化的方法
     * 分析：
     * 1. 如果node==null則不用線索化
     * 2. 先線索化左子樹
     * 3. 線索化當前節點
     * 3.1 處理當前節點的前驅節點，讓當前節點的左指針指向前驅節點
     * 3.2 修改當前節點的左指針類型，指向前驅節點
     * 3.3 處理後繼節點，讓前驅節點的右指針指向當前節點
     * 3.4 修改前驅節點的右指針類型
     * 3.5 每處理一個節點後，讓下一個前驅節點是下一個節點的前驅節點
     * 4. 再線索化右子樹
     *
     * @param node 當前需要線索化的節點
     */
    private void threadedNodes(HeroNode node) {
        if (node == null) {
            return;
        }
        threadedNodes(node.left);
        if (node.left == null) {
            node.left = pre;
            node.leftType = 1;
        }
        if (pre != null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }
        pre = node;
        threadedNodes(node.right);
    }

}

class HeroNode {
    public int id;
    public String name;
    public HeroNode right;
    public HeroNode left;

    /*
        說明：
        1. 如果leftType == 0表示指向左子樹，如果1則表示指向前驅節點
        1. 如果rightType == 0表示指向右子樹，如果1則表示指向後繼節點
     */
    public int leftType;
    public int rightType;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
