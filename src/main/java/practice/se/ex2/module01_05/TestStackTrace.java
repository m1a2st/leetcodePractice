package practice.se.ex2.module01_05;

public class TestStackTrace {

    public static void main(String[] args) {
        try {
            methodC();
        } catch (NullPointerException ne) {
            ne.printStackTrace();
        }
    }

    static void methodC() {
        methodB();
    }

    static void methodB() {
        methodA();
    }

    static String methodA() {
        String str = null;
        return str.toUpperCase();
    }
}
