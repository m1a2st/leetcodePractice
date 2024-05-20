package se.ex2.module01_05;

public class TestMyException {

    public static void main(String[] args) {
        try {

            throw new MyException("發生自訂的例外了!");

        } catch (MyException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}
