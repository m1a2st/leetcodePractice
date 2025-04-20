package practice.se.ex1.module09_11;

/*
 * 此範例為傳值傳址測試
 */
public class PassArgTest {

    static void passValue(double value) {
        value = 20.0;
    }

    static void passReference(Pen reference) {
        reference.price = 20.0;
    }

    public static void main(String[] args) {
        double price = 10.0;
        passValue(price);
        System.out.println(price);        // 10

        Pen myPen = new Pen();
        myPen.price = 10.0;
        passReference(myPen);
        System.out.println(myPen.price);  // 20
    }
}
