package parctice.se.ex1.module16_19;

public class Count {
    // 產品序號
    private final int serialNumber;

    public int getSerialNumber() {
        return serialNumber;
    }

    // 產品數量
    private static int counter;

    public static int getTotalCount() {
        return counter;
    }

    // 建構式
    public Count() {
        counter++;
        serialNumber = 1000 + counter;
    }
}
