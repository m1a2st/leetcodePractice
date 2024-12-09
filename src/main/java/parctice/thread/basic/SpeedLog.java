package parctice.thread.basic;

import java.util.HashMap;
import java.util.Map;

public class SpeedLog {

    private static final ThreadLocal<Map<String, Long>> TIME_RECORD_LOCAL =
            ThreadLocal.withInitial(SpeedLog::initialStartTime);
    private static final String START = "start";
    private static final String LAST = "last";

    public static Map<String, Long> initialStartTime() {
        HashMap<String, Long> map = new HashMap<>();
        map.put(START, System.currentTimeMillis());
        map.put(LAST, System.currentTimeMillis());
        return map;
    }

    public static void beginSpeedLog() {
        System.out.println("開始耗時記錄");
        TIME_RECORD_LOCAL.get();
    }

    public static void endSpeedLog() {
        TIME_RECORD_LOCAL.remove();
        System.out.println("結束耗時記錄");
    }

    public static void logPoint(String point) {
        Long last = TIME_RECORD_LOCAL.get().get(LAST);
        Long cost = System.currentTimeMillis() - last;
        TIME_RECORD_LOCAL.get().put(point + " cost:", cost);
        TIME_RECORD_LOCAL.get().put(LAST, System.currentTimeMillis());
    }

    public static void printCost() {
        TIME_RECORD_LOCAL.get().forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
