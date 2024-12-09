package main.java.parctice.se.ex1.module20_23;

public class TestManager {

    public static void main(String[] args) {
        Manager m1 = new Manager(7003, "Vlady", 50000.0, 10000.0);
        m1.display();

        String ename = m1.getEname();  //雖自己沒有getName()方法, 但來自父-祖父類別
        System.out.println("》來自父類別的getName()=" + ename);
    }

}
