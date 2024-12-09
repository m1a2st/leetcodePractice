package main.java.parctice.se.ex2.module01_05;

public class TestThrows1 {
    String[] strs = {"Hello1", "Hello2", "Hello3"};

    public void printStrs(int i) throws Exception {
        System.out.println(strs[i]);
    }

    public static void main(String[] args) {
        int i = 0;
        TestThrows1 t1 = new TestThrows1();
        while (i < 4) {
            try {
                t1.printStrs(i);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("1-已超出陣列的長度");
            } catch (Exception e) {
                System.out.println("2-發生Exception");
            }
            i++;
        }
    }

}
