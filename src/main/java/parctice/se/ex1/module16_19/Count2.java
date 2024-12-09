package main.java.parctice.se.ex1.module16_19;

public class Count2 {
    // 產品序號
    private final int serialNumber;

    public int getSerialNumber() {
        return serialNumber;
    }

    // 產品數量
    private static int counter;

    static {
        counter = 0;
        System.out.println("起始數量:" + counter + "\n");
    }

    public static int getTotalCount() {
        return counter;
    }

    // 建構式
    public Count2() {
        counter++;
        serialNumber = 1000 + counter;
    }
}
