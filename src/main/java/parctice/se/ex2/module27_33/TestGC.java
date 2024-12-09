package parctice.se.ex2.module27_33;

public class TestGC {
    public static void main(String[] args) {
        Object obj;
        for (int i = 1; i <= 100000; i++) {
            obj = new Object();
        }
        System.out.print("剩餘記憶體:");
        System.out.println(Runtime.getRuntime().freeMemory());

        System.out.println("強制進行垃圾收集");
        System.gc();

        System.out.print("剩餘記憶體:");
        System.out.println(Runtime.getRuntime().freeMemory());

    }
}
