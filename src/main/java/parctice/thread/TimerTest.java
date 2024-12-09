package main.java.parctice.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author m1a2st
 * @Date 2023/8/15
 * @Version v1.0
 */
public class TimerTest extends TimerTask {

    private final Long time;

    public TimerTest(Long time) {
        this.time = time;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis() - time;
        System.out.println(start);
    }
}

class TimerTestMain {
    public static void main(String[] args) {
        TimerTest timerTest = new TimerTest(1000L);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTest, 1000L, 5);
    }
}
