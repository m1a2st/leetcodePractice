package main.java.parctice.leetcode.test;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;

public class TestSomething {

    @Test
    public void test() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMdd");
        System.out.println(pattern.parse("20240101"));
        pattern = DateTimeFormatter.ofPattern("yyyyMM");
        System.out.println(pattern.parse("202311"));
    }
}


