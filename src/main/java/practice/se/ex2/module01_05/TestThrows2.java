package practice.se.ex2.module01_05;

public class TestThrows2 {
    String[] strs = {"Hello1", "Hello2", "Hello3"};

    public void printStrs(int i) throws Exception {
        System.out.println(strs[i]);
    }

    public static void main(String[] args) throws Exception {
        int i = 0;
        TestThrows2 t2 = new TestThrows2();
        while (i < 4) {
            t2.printStrs(i);
            i++;
        }
    }
}
