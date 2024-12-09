package main.java.parctice.se.ex2.module01_05;

public class TestImprovedRethrow {
    static class ExceptionA extends Exception {
    }

    static class ExceptionB extends Exception {
    }

    // before
    public static void methodA(String exceptionName) throws Exception {
        try {
            if (exceptionName.equals("A")) {
                throw new ExceptionA();
            } else {
                throw new ExceptionB();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    // Java 7
    public static void methodB(String exceptionName) throws ExceptionA, ExceptionB {
        try {
            if (exceptionName.equals("A")) {
                throw new ExceptionA();
            } else {
                throw new ExceptionB();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            methodB("B");
        } catch (ExceptionA | ExceptionB e) {
            e.printStackTrace();
        }
    }
}
