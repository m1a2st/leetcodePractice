package leetcode.data_structure.linkedList;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //創建節點
        HeroNodeI heroNode = new HeroNodeI(1, "SuperMan", "超人");
        HeroNodeI heroNode1 = new HeroNodeI(2, "Batman", "蝙蝠俠");
        HeroNodeI heroNode2 = new HeroNodeI(3, "SpiderMan", "蜘蛛人");
        HeroNodeI heroNode3 = new HeroNodeI(4, "GreenMan", "綠巨人");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode);
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
//        doubleLinkedList.list();

        HeroNodeI heroNode4 = new HeroNodeI(2, "123", "123");
        doubleLinkedList.update(heroNode4);
        doubleLinkedList.delete(2);
        doubleLinkedList.list();
    }
}


class DoubleLinkedList {
    //先初始化頭節點，頭節點不要動，不存放具體數據
    private final HeroNodeI head = new HeroNodeI(0, "", "");

    public HeroNodeI getHead() {
        return head;
    }

    //顯示鍊錶
    public void list() {
        //  判斷鍊錶是否為空
        if (head.next == null) {
            System.out.println("LinkedList is empty.");
            return;
        }
        //因為頭節點不能動，所以需要一個輔助指針遍歷linkedList
        HeroNodeI temp = head.next;
        while (true) {
            //判斷鍊錶是否對最後
            if (temp == null) {
                break;
            }
            //輸出節點訊息
            System.out.println(temp);
            //將temp後移
            temp = temp.next;
        }
    }

    //添加節點到雙向鍊錶
    /*
        思路，當不考慮編號順序時
        1. 找到當前鍊錶的最後節點
        2. 將最後這個節點的next，指向新的節點
     */
    public void add(HeroNodeI heroNode) {
        //因為頭節點不能動，所以需要一個輔助指針遍歷linkedList
        HeroNodeI temp = head;
        //  遍歷練表，找到最後
        while (true) {
            //找到鍊錶的最後
            if (temp.next == null) {
                break;
            }
            //如果沒找到temp後移
            temp = temp.next;
        }
        //當退出while循環時，temp就指向了鍊表的最後
        //將最後這個節點的next，指向新的節點
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //根據編號（no），來修改節點訊息
    //1. 根據newHeroNode 的no 來修改即可
    public void update(HeroNodeI heroNode) {
        //判斷是否為空
        if (this.head.next == null) {
            System.out.println("This linkedList is null");
            return;
        }
        //找到需要修改的節點，根據no編號，定義一個輔助變量
        HeroNodeI temp = this.head.next;
        //表示是否找到該節點
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //以經遍歷完鏈表
                break;
            }
            if (temp.no == heroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //如果有找到就修改節點
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            //如果沒有找到，顯使沒有找到
            System.out.printf("Don't find the no%d of node.\n", heroNode.no);
        }
    }

    //從雙向鏈表中刪除一個節點
    /*
        說明
        1. 對於雙向鏈表，我們可以直接找到要刪除的這個節點
        2. 找到後，自我刪除即可
     */

    public void delete(int no) {

        //判斷當前鏈表是否為空
        if (head.next == null) {
            System.out.println("Linked List is empty. Can't delete.");
            return;
        }
        HeroNodeI temp = head.next;
        //標示是否找到刪除節點
        boolean flag = false;
        while (true) {
            //已經到鏈表最後
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //如果是最後一個節點，不需要執行此行，會出現空指針異常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("Want to delete node%d is not exist.\n", no);
        }
    }

}

//定義HeroNode，每個HeroNode對象就是一個節點
class HeroNodeI {
    public int no;
    public String name;
    public String nickName;
    //指向下一個節點，默認為null
    public HeroNodeI next;
    //指向前一個節點，默認為null
    public HeroNodeI pre;

    public HeroNodeI(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //為了顯示方式，重寫toString()方法

    @Override
    public String toString() {
        return "HeroNodeI{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
