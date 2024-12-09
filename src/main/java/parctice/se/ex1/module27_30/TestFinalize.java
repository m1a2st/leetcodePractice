package main.java.parctice.se.ex1.module27_30;

class ClassFinalize {
    protected void finalize() {
        System.out.println("finalize方法執行了");
    }
}

public class TestFinalize {
    public static void main(String[] args) {
        ClassFinalize fin = new ClassFinalize();
        fin = null;
        System.out.println("強制進行垃圾收集");
        System.gc();
    }
}
