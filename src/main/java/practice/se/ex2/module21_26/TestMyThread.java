package practice.se.ex2.module21_26;

public class TestMyThread {

    public static void main(String[] args) {
        MyThread[] nt = new MyThread[]{
                new MyThread(),
                new MyThread("NT2", 2),
                new MyThread("NT3", 3),
                new MyThread("NT6", 6, true),
                new MyThread("NT9", 9, true)
        };

        for (int i = 0; i < nt.length; i++)
            nt[i].start();

        //將執行緒物件中的ready變數設為true時，
        //才會離開永久迴圈而執行下去
        MyThread.ready = true;
    }

}
