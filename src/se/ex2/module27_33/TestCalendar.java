package se.ex2.module27_33;

import java.util.Calendar;

public class TestCalendar {

    static String[] week = {"日", "一", "二", "三", "四", "五", "六"};

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DATE);
        int h = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        System.out.print("今天是: ");
        System.out.println(y + "年" + m + "月" + d + "日");
        System.out.print("現在是: ");
        System.out.println(h + "點" + min + "分" + sec + "秒");

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println("星期" + week[w]);
    }
}
