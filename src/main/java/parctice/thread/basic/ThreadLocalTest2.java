package main.java.parctice.thread.basic;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest2 {

    public void serviceMethod() {

        // 睡眠耗時，模擬執行所需時間
        ThreadUtil.sleepMilliSeconds(500);
        SpeedLog.logPoint("point-1 service");
        daoMethod();
        rpcMethod();
    }

    private void rpcMethod() {
        ThreadUtil.sleepMilliSeconds(400);
        SpeedLog.logPoint("point-3 rpc");
    }

    private void daoMethod() {
        ThreadUtil.sleepMilliSeconds(600);
        SpeedLog.logPoint("point-2 dao");
    }

    @Test
    public void testSpeedLog() {
        new Thread(() -> {
            SpeedLog.beginSpeedLog();
            serviceMethod();
            SpeedLog.printCost();
            SpeedLog.endSpeedLog();
        }).start();
        ThreadUtil.sleepMilliSeconds(10000);
    }
}
