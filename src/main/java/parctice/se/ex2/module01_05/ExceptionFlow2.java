package main.java.parctice.se.ex2.module01_05;

public class ExceptionFlow2 {

    public static void main(String[] args) {
        try {
            method();
        } catch (Exception e) {
            System.out.println("3 - Exception handling in main()");
        }
    }

//	public static void method() throws Exception {
//		try {
//			System.out.println("1 - in method()");
//			throw new Exception();
//		} catch (Exception e) {
//			System.out.println("2 - Exception handling in method()");
//		}
//	} //1,2

//	public static void method() throws Exception {
//		try {
//			System.out.println("1 - in method()");
//			throw new Exception();
//		} catch (RuntimeException e) {
//			System.out.println("2 - Exception handling in method()");
//		}
//	} //1,3

    public static void method() throws Exception {
        try {
            System.out.println("1 - in method()");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("2 - Exception handling in method()");
            throw e;
        }
    }//1,2,3

}
