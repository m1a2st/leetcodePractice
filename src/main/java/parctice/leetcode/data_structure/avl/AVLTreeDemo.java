package parctice.leetcode.data_structure.avl;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }
        avlTree.infixOrder();
        int height = avlTree.getRoot().height();
        System.out.println(height);
        System.out.println(avlTree.getRoot().leftHeight());
        System.out.println(avlTree.getRoot().rightHeight());
    }
}

class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }


    /**
     * 刪除節點
     * 1. 先去找到要刪除的節點 targetNode
     * 2. 如果沒有找到要刪除的節點，返回
     * 3. 當發現此二元樹只有一個節點時，刪掉root
     * 4. 找到targetNode 的父節點
     * 5. 判斷要刪除的節點是否為葉子節點，且判斷要刪除的是左子節點還是右子節點
     * 6. 判斷要刪除的節點是否為有兩個子節點
     * 7. 判斷要刪除的節點是否為只有一個子節點
     *
     * @param value 希望刪除節點的值
     */
    public void deleteNode(int value) {
        if (root != null) {
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            Node parent = searchParent(value);
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                targetNode.value = delRightTreeMin(targetNode.right);
            } else { //刪除只有一顆子樹的節點
                //如果要刪除的節點有左節點
                if (targetNode.left != null) {
                    if (parent != null) {
                        //如果targetNode 是parent的左子節點
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else { //如果要刪除的節點有右節點
                    if (parent != null) {
                        //如果targetNode 是parent的左子節點
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    /**
     * 思路：
     * 1. 循環搜尋左子節點，就會找到最小值
     * 2. target指向最小節點，並刪除最小節點
     * 2. 返回最小節點的值
     *
     * @param node 傳入的節點（當作二元排序樹的根節點）
     * @return 返回以node為根節點的二元排序樹的最小節點的值，並且刪除節點
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        deleteNode(target.value);
        return target.value;
    }

    /**
     * 查找要刪除的結點
     *
     * @param value 希望刪除節點的值
     * @return 如果找到則返回該節點，沒有返回null
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 搜尋想查找值的父節點
     *
     * @param value 要找到節點的值
     * @return 返回想查找值的父節點，如果沒有則返回null
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 添加節點的方法
     *
     * @param node 要添加的節點
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍歷
     */
    public void infixOrder() {
        if (root == null) {
            System.out.println("This binary tree is empty.");
        } else {
            root.infixOrder();
        }
    }
}


class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * @return 左子樹的高度
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    /**
     * @return 右子樹的高度
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
    }

    /**
     * @return 返回當前節點高度，以該節點為根節點樹的高度
     */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 1. 創建新的節點，以當前根節點的值賦值
     * 2. 把新節點的左子樹設置成當前節點的左子樹
     * 3. 把新節點的右子樹設置成當前節點的右子樹的左子樹
     * 4. 把當前節點的值替換成右子節點的值
     * 5. 把當前節點的右子樹，設置成當前節點的右子樹的右子樹
     * 6. 把當前節點的左子節點，設置成新的節點
     */
    private void leftRotate() {
        Node newNode = new Node(this.value);
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.value = this.right.value;
        this.right = this.right.right;
        this.left = newNode;
    }

    /**
     * 1. 創建新的節點，以當前根節點的值賦值
     * 2. 把新節點的右子樹設置成當前節點的右子樹
     * 3. 把新節點的左子樹設置成當前節點的左子樹的右子樹
     * 4. 把當前節點的值替換成左子節點的值
     * 5. 把當前節點的左子樹，設置成當前節點的左子樹的左子樹
     * 6. 把當前節點的右子節點，設置成新的節點
     */
    private void rightRotate() {
        Node newNode = new Node(this.value);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = newNode;
    }


    /**
     * 查找要刪除的結點
     * 思路：
     * 1. 先判斷當前節點是否是要查找的值
     * 2. 判斷查找的值是否小於當前節點，如果是的話，則向左遞迴查找
     * 3. 若左子節點為空則代表，找不到該值，所以返回空值
     * 4. 判斷查找的值是否大於當前節點，如果是的話，則向右遞迴查找
     * 5. 若右子節點為空則代表，找不到該值，所以返回空值
     *
     * @param value 希望刪除節點的值
     * @return 如果找到則返回該節點，沒有返回null
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 搜尋想查找值的父節點
     * 思路：
     * 1. 如果當前節點就是在搜尋的父節點，就返回
     * 2. 如果搜尋的值小於當前節點，且當前節點的左子節點不為空時，則向左遞迴查找
     * 3. 如果搜尋的值大於當前節點，且當前節點的右子節點不為空時，則向右遞迴查找
     * 4. 如果都不符合上面條件，則返回空值
     *
     * @param value 要找到節點的值
     * @return 返回想查找值的父節點，如果沒有則返回null
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    /**
     * 已遞迴的形式添加節點，需要滿足二元排序數的要求
     *
     * @param node 將要添加的節點
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判斷傳入節點的值，和當前子樹節點值的關係
        if (node.value < this.value) {
            //如果當前節點的左子節點為空
            if (this.left == null) {
                this.left = node;
            } else {
                //遞迴向左子樹添加
                this.left.add(node);
            }
        } else { //添加的節點值大於當前節點
            if (this.right == null) {
                this.right = node;
            } else {
                //遞迴向右子樹添加
                this.right.add(node);
            }
        }
        //當添加完一個節點後，如果右子樹的高度-左子樹的高度>1，左旋轉
        if (rightHeight() - leftHeight() > 1) {
            //如果右子樹的左子樹的高度大於他的右子樹的右子樹高度
            if (this.right != null && this.right.leftHeight() > this.right.rightHeight()) {
                //先對右子節點進行右旋轉
                this.right.rightRotate();
            }
            this.leftRotate();
            //重要！！！
            return;
        }
        //當添加完一個節點後，如果左子樹的高度-右子樹的高度>1，右旋轉
        if (leftHeight() - rightHeight() > 1) {
            //如果左子樹的右子樹高度大於左子樹的高度
            if (this.left != null && this.left.rightHeight() > this.left.leftHeight()) {
                //先對當前節點的左節點（左子樹）->左旋轉
                this.left.leftRotate();
            }
            //直接進行右旋轉
            this.rightRotate();
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
