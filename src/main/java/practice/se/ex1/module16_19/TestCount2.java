package practice.se.ex1.module16_19;

public class TestCount2 {

    public static void main(String[] args) {
        Count2 count1 = new Count2();
        System.out.println("累計數量:" + Count2.getTotalCount());
        System.out.println("序號:" + count1.getSerialNumber());
        Count2 count2 = new Count2();
        System.out.println("累計數量:" + Count2.getTotalCount());
        System.out.println("序號:" + count2.getSerialNumber());
    }

}
