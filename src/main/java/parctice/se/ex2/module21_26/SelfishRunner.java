package parctice.se.ex2.module21_26;

/**
 * 自私的執行緒 -自私的執行緒(selfish thread): 實踐了 "socially-impaired" 特性
 * <p>
 * -即 :
 * 1.自私的執行緒擁有"密實迴圈(tight loop)" . 如下面所示之 while loop.
 * 2.該迴圈會佔住CPU不放, (尤其, 如果系統不支援Time-Slice則易完全獨佔 ) 除非:
 * a. 該迴圈執行完畢
 * b. 或被更高Priority之其它執行緒搶走cpu執行權
 * (指有更高Priority之其它執行緒進入ready狀態,此即是preemptive的特性)
 */

public class SelfishRunner extends Thread {

    private int tick = 1;
    private final int num;

    public SelfishRunner(int num) {
        this.num = num;
    }

    public void run() {
        while (tick < 40000000) { // 原來為400000
            tick++;
            if ((tick % 50000) == 0)
                System.out.println("Thread #" + num + ", tick = " + tick);
        }
    }
}
