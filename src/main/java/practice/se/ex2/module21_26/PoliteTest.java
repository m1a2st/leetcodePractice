package practice.se.ex2.module21_26;

public class PoliteTest {

    private final static int NUMRUNNERS = 2;

    public static void main(String[] args) {
        PoliteRunner[] runners = new PoliteRunner[NUMRUNNERS];

        for (int i = 0; i < NUMRUNNERS; i++) {
            runners[i] = new PoliteRunner(i);
            runners[i].setPriority(2);
        }
        for (int i = 0; i < NUMRUNNERS; i++)
            runners[i].start();
    }
}
