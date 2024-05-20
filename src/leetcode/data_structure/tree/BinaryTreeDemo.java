package leetcode.data_structure.tree;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

        //create a binary tree
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "SuperMan");
        HeroNode node1 = new HeroNode(2, "Batman");
        HeroNode node2 = new HeroNode(3, "SpiderMan");
        HeroNode node3 = new HeroNode(4, "GreenMan");
        HeroNode node4 = new HeroNode(5, "wolfMan");

        //手動創建二元樹
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node1.left = node4;

        binaryTree.setRoot(root);
        //測試，前序遍歷 =>1,2,3,4
        binaryTree.preOrder();
//        //測試，中序遍歷 =>2,1,3,4
//        System.out.println();
//        binaryTree.infixOrder();
//        //測試，前序遍歷 =>2,4,3,1
//        System.out.println();
//        binaryTree.postOrder();
//
//        System.out.println(binaryTree.preOrderSearch(15));
//        System.out.println(binaryTree.infixOrderSearch(3));
//        System.out.println(binaryTree.postOrderSearch(5));

//        binaryTree.delete(3);
//        binaryTree.preOrder();
    }
}

//定義一個binaryTree
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 前序遍歷
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("This binary tree is empty.");
        }
    }

    /**
     * 中序遍歷
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("This binary tree is empty.");
        }
    }

    /**
     * 後序遍歷
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("This binary tree is empty.");
        }
    }

    /**
     * 前序搜尋
     *
     * @param id 搜尋的id值
     * @return 如果有就返回該Node，沒有就返回null
     */
    public HeroNode preOrderSearch(int id) {
        if (root != null) {
            return root.preOrderSearch(id);
        } else {
            return null;
        }
    }

    /**
     * 中序搜尋
     *
     * @param id 搜尋的id值
     * @return 如果有就返回該Node，沒有就返回null
     */
    public HeroNode infixOrderSearch(int id) {
        if (root != null) {
            return root.infixOrderSearch(id);
        } else {
            return null;
        }
    }

    /**
     * 後序搜尋
     *
     * @param id 搜尋的id值
     * @return 如果有就返回該Node，沒有就返回null
     */
    public HeroNode postOrderSearch(int id) {
        if (root != null) {
            return root.postOrderSearch(id);
        } else {
            return null;
        }
    }

    /**
     * 刪除節點：
     * 思路：
     * 1. 如果root == null代表此樹為空
     * 2. 如果 root.id == id 代表要刪除的是根節點
     * 3. 如果以上條件都不是，則調用HeroNode的delete方法
     *
     * @param id 欲備刪除節點的id
     */
    public void delete(int id) {
        if (root == null) {
            System.out.println("This binary tree is empty");
        } else {
            if (root.id == id) {
                root = null;
            } else {
                root.delete(id);
            }
        }
    }
}

//先創建HeroNode節點
class HeroNode {
    public int id;
    public String name;
    public HeroNode right;
    public HeroNode left;

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

    /**
     * 前序遍歷
     * 1. 先輸出父節點
     * 2. 遞迴左子樹前序遍歷
     * 3. 遞迴右子樹前序遍歷
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍歷
     * 1. 遞迴左子樹中序遍歷
     * 2. 輸出父節點
     * 3. 遞迴右子樹中序遍歷
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 後序遍歷
     * 1. 遞迴左子樹後序遍歷
     * 2. 遞迴右子樹後序遍歷
     * 3. 輸出父節點
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序搜尋
     * 1. 判斷當前節點是不是要搜尋的值
     * 2. 若不是則判斷當前節點的子左節點使否為空，如果不為空則左遞迴前序搜尋
     * 3. 如果左遞迴前序搜尋，找到節點，則返回
     * 4. 當前節點右節點是否為空，如果不為空則繼續向右遞迴前序搜尋
     *
     * @param id 搜尋的id值
     * @return 如果有就返回該Node，沒有就返回null
     */
    public HeroNode preOrderSearch(int id) {
        if (this.id == id) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(id);
        }
        return resNode;
    }

    /**
     * 中序搜尋
     * 1. 先判斷此節點的左節點是否為空，如果不為空則向左遞迴搜尋
     * 2. 向左遞迴搜尋，若不為空則返回結果，為空則判斷此節點
     * 3. 若此節點id 為搜尋id則返回，否則判斷右節點是否為空
     * 4. 若右節點不為空，則向右遞迴搜尋，若不為空則返回，為空則返回null
     *
     * @param id 搜尋的id值
     * @return 如果有就返回該Node，沒有就返回null
     */
    public HeroNode infixOrderSearch(int id) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.id == id) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(id);
        }
        return resNode;
    }

    /**
     * 後序搜尋
     * 1. 先判斷此節點的左節點是否為空，如果不為空則向左遞迴搜尋
     * 2. 向左遞迴搜尋，若不為空則返回結果，為空則判斷此節點的柚子節點是否為空
     * 3. 若右節點不為空，則向右遞迴搜尋，若不為空則返回，為空則判斷此節點
     * 4. 若此節點id 為搜尋id則返回，否則回傳null
     *
     * @param id 搜尋的id值
     * @return 如果有就返回該Node，沒有就返回null
     */
    public HeroNode postOrderSearch(int id) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.id == id) {
            return this;
        }
        return null;
    }


    /**
     * 遞迴刪除節點
     * 前提：
     * 1. 如果刪除的節點是葉子節點，則刪除該節點
     * 2. 如果刪除的節點是非葉子節點，則刪除該子樹
     * 思路：
     * 1. 因為目前的二元樹是單向的，所以我們是判斷當前節點的子節點是否需要刪除節點，而不能去判斷當前這個節點是不是需要刪除節點
     * 2. 如果當前節點的左子節點不為空，並且左子節點就是要刪除的節點，就將this.left = null，並且返回（結束遞迴刪除）
     * 3. 如果當前節點的右子節點不為空，並且右子節點就是要刪除的節點，就將this.right = null，並且返回（結束遞迴刪除）
     * 4. 如果第2步跟第3步都沒有刪除節點，那麼就需要向左子樹進行遞迴刪除
     * 5. 如果第4步沒有刪除節點，那麼就需要向右子樹進行遞迴刪除
     *
     * @param id 欲備刪除節點的id
     */
    public void delete(int id) {
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delete(id);
        }
        if (this.right != null) {
            this.right.delete(id);
        }
    }
}
