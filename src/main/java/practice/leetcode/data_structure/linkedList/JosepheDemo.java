package practice.leetcode.data_structure.linkedList;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class JosepheDemo {
    public static void main(String[] args) {
        //測試環形鏈表，和遍歷是否ok
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.list();
        //測試出圈是否正確
        circleSingleLinkedList.countNode(1, 2, 5);
    }
}

//創建環形單向鏈表
class CircleSingleLinkedList {
    //創建first節點，當前沒有編號
    private Node first = null;

    //添加節點，構成一個環形鏈表
    public void add(int nums) {
        //nums 做一個數據校驗
        if (nums < 1) {
            System.out.println("This value is wrong.");
            return;
        }
        //輔助變量，幫助構建環形鏈表
        Node cur = null;
        //使用for循環創建環形鏈表
        for (int i = 1; i <= nums; i++) {
            //根據編號創造節點
            Node node = new Node(i);
            //如果是第一個節點
            if (i == 1) {
                first = node;
                //構成環狀
                first.setNext(first);
                //讓cur指向第一個節點
                cur = first;
            } else {
                cur.setNext(node);
                node.setNext(first);
                cur = node;
            }
        }
    }

    //遍歷當前環形鏈表
    public void list() {
        //判斷是否為空
        if (first == null) {
            System.out.println("This circleLinkedList is empty.");
        }
        //因為first不能動，因此我們使用輔助指針完成遍歷
        Node node = first;
        while (true) {
            System.out.printf("Node's number is %d\n", node.getNo());
            if (node.getNext() == first) {
                //說明已經遍歷完畢
                break;
            }
            //節點後移
            node = node.getNext();
        }
    }

    //根據用戶的輸入，計算出節點出圈的順序

    /**
     * @param startNo  表示從第幾個節點開始數數
     * @param countNum 表示數幾下
     * @param nums     表示最初有多少節點在圈中
     */
    public void countNode(int startNo, int countNum, int nums) {
        //先對數據進行校驗
        if (this.first == null || startNo < 1 || startNo > nums) {
            System.out.println("參數輸入有誤，請重新輸入");
            return;
        }
        //創建一個輔助指針，幫助節點出圈
        Node helper = first;
        while (true) {
            //說明helper指向最後節點
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //節點報數時，先讓first和helper移動k-1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //當節點報數時，讓first和helper指針同時移動m-1次，然後出圈
        //這裡是一個循環操作，直到圈中只有一個節點
        while (true) {
            //說明圈中只有一個節點
            if (helper == first) {
                break;
            }
            //讓first和helper指針同時移動 countNum - 1 次
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //這時first指向的節點就是要出圈的節點
            System.out.printf("No%d out circle.\n", first.getNo());
            //將first指向的節點出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("Last No%d in the circle.\n", first.getNo());
    }


}

//創建一個節點，表示boy
class Node {
    private int no;
    //指向下一個節點，默認為空
    private Node next;

    public Node(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
