package practice.se.ex2.module37_42;

import java.time.LocalDate;

import static java.lang.System.out;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.temporal.TemporalAdjusters.next;

public class TestLocalDate {
    public static void main(String[] args) {
        LocalDate now, bDate, nowPlusMonth, nextTues;

        now = LocalDate.now();
        out.println("Now: " + now);

        bDate = LocalDate.of(1995, 5, 23); // Java's Birthday
        out.println("Java's Bday: " + bDate);
        out.println("Is Java's Bday in the past? " + bDate.isBefore(now));
        out.println("Is Java's Bday in a leap year? " + bDate.isLeapYear());
        out.println("Java's Bday day of the week: " + bDate.getDayOfWeek());

        nowPlusMonth = now.plusMonths(1);
        out.println("Now: " + now);
        out.println("The date a month from now: " + nowPlusMonth);

        nextTues = now.with(next(TUESDAY));
        out.println("Next Tuesday's date: " + nextTues);
    }
}
