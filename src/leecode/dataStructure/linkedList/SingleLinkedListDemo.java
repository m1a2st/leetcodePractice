package leecode.dataStructure.linkedList;

import java.util.Stack;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //創建節點
        HeroNode heroNode = new HeroNode(1, "SuperMan", "超人");
        HeroNode heroNode1 = new HeroNode(2, "Batman", "蝙蝠俠");
        HeroNode heroNode2 = new HeroNode(3, "SpiderMan", "蜘蛛人");
        HeroNode heroNode3 = new HeroNode(4, "GreenMan", "綠巨人");

        //創建鍊錶
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
//        singleLinkedList.add(heroNode);
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
        singleLinkedList.addByOrder(heroNode);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode1);

        reverseList(singleLinkedList.getHead());
        reversePrint(singleLinkedList.getHead());
//        singleLinkedList.list();
//        HeroNode heroNode4 = new HeroNode(2, "鄭成功", "小功");
//        singleLinkedList.update(heroNode4);
//        singleLinkedList.delete(1);
//        singleLinkedList.list();
//        System.out.println(getLength(singleLinkedList.getHead()));
//        System.out.println(findLastIndexNode(singleLinkedList.getHead(), 1));
    }

    //可以利用棧(stack)這個數據結構，將各個節點壓入到棧中，然後利用棧的先進後出的特點，就實現了逆序打印的效果
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            //空練表，不能打印
            return;
        }
        //創建一個棧，將個節點寫入
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //將鏈表所有節點寫入棧中
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            //stack特點先進後出
            System.out.println(stack.pop());
        }
    }

    //將單鏈表進行反轉
    public static void reverseList(HeroNode head) {
        //如果當前鏈表為空，或是只有一個節點則無須反轉
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定義一個輔助指針（變量），幫助我們遍歷原來的鏈表
        HeroNode cur = head.next;
        //指向當前節點的下一個節點
        HeroNode next;
        HeroNode reverseHead = new HeroNode(0, "", "");
        //從頭到尾遍歷原來的鏈表，每遍歷一個節點，就將其取出，並放在新的鏈表reverseHead 的最前端
        while (cur != null) {
            //先暫時保存當前節點的下一個節點，因為後面會用到
            next = cur.next;
            //將cur的下一個節點指向新的鏈表的最前端
            cur.next = reverseHead.next;
            //將cur連接到新的鏈表上
            reverseHead.next = cur;
            //讓cur後移
            cur = next;
        }
        //將head.next 指向reverseHead.next ，實現反轉
        head.next = reverseHead.next;
    }

    //方法，獲取單鏈表的節點個數（如果是帶頭節點的鏈表，需要不統計頭節點）

    /**
     * @param head 鍊表頭節點
     * @return 返回就是有效節點個數
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        //定義一個輔助變量，這裡沒有統計頭節點
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //查找單鏈表中的倒數第k個結點
    /*
       思路：
       1. 編寫一個方法，接收head節點，同時接收一個index
       2. index 表示倒數第index個節點
       3. 先把鏈表從頭遍歷，得到總長度 （getLength()）
       4. 得到size後，我們從鏈表第一個開始遍歷（size - index）個，就可以得到
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            //沒有找到
            return null;
        }
        //第一次遍歷得到鏈表的長度（節點個數）
        int size = getLength(head);
        //第二次遍歷的到倒數第k個節點
        //先做index校驗
        if (index <= 0 || index > size) {
            return null;
        }
        //定義一個輔助變量，for循環定位到倒數index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 返回鏈表的倒數第n個節點
     * temp 先走 index 步
     * temp 和 temp2 同时走 length - index 步
     * temp2 现在指向第 length - index + 1 個節點，即倒數第 index 個節點
     * @param head 頭節點
     * @param index 到數最後幾個節點
     * @return 哪一個節點
     */
    public static HeroNode findLastIndexBest(HeroNode head,int index){
        HeroNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        HeroNode temp2 = head;
        while(temp != null){
            temp2 = temp2.next;
            temp = temp.next;
        }
        return temp2;
    }
}

//定義SingleLinkedList 管理我們的英雄
class SingleLinkedList {
    //先初始化頭節點，頭節點不要動，不存放具體數據
    private final HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //添加節點到單向鍊錶
    /*
        思路，當不考慮編號順序時
        1. 找到當前鍊錶的最後節點
        2. 將最後這個節點的next，指向新的節點
     */
    public void add(HeroNode heroNode) {
        //因為頭節點不能動，所以需要一個輔助指針遍歷linkedList
        HeroNode temp = head;
        //  遍歷練表，找到最後
        while (true) {
            //找到鍊錶的最後
            if (temp.next == null) {
                break;
            }
            //如果沒找到temp後移
            temp = temp.next;
        }
        //當退出while循環時，temp就指向了鍊錶的最後
        //將最後這個節點的next，指向新的節點
        temp.next = heroNode;
    }

    //顯示鍊錶
    public void list() {
        //  判斷鍊錶是否為空
        if (head.next == null) {
            System.out.println("LinkedList is empty.");
            return;
        }
        //因為頭節點不能動，所以需要一個輔助指針遍歷linkedList
        HeroNode temp = head.next;
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

    //第二種方式添加英雄時，根據排名將英雄插入指定位置
    //如果有這個排名，則添加失敗，並給出提示
    public void addByOrder(HeroNode heroNode) {
        //因為頭節點不能動，因此透過一個輔助指針來幫助找到添加位置
        //因為是單鏈表，因為我們找的temp是位於添加位置的前一個節點，否則加入不了
        HeroNode temp = head;
        //標示添加編號是否存在，默認為false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //位置找到，就在temp的後面插入
            if (temp.next.no > heroNode.no) {
                break;
                //說明希望添加的heroNode編號已然存在
            } else if (temp.next.no == heroNode.no) {
                //說明編號存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判斷flag
        if (flag) {
            //編號存在，不能添加
            System.out.printf("準備加入的英雄編號%d已經存在，不能加入\n", heroNode.no);
        } else {
            //加入到鏈表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //根據編號（no），來修改節點訊息
    //1. 根據newHeroNode 的no 來修改即可
    public void update(HeroNode heroNode) {
        //判斷是否為空
        if (this.head.next == null) {
            System.out.println("This linkedList is null");
            return;
        }
        //找到需要修改的節點，根據no編號，定義一個輔助變量
        HeroNode temp = this.head.next;
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

    //刪除節點
    /*
       1. head 不能動，因此我們需要一個temp輔助節點找到刪除的前一個節點
       2. 說明我們在比較時，是temp.next.no和需要刪除的節點no比較
     */
    public void delete(int no) {
        HeroNode temp = head;
        //標示是否找到刪除節點
        boolean flag = false;
        while (true) {
            //已經到鏈表最後
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("Want to delete node%d is not exist.\n", no);
        }
    }
}

//定義HeroNode，每個HeroNode對象就是一個節點
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    //指向下一個節點
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //為了顯示方式，重寫toString()方法

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}


