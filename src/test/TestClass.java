package test;

import kotlin.ranges.IntRange;
import leecode.medium.No875;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class TestClass {

    @Test
    public void test() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add("a" + i);
        }

        for (String s : list) {
            if (s.equals("a3")) {
                list.remove(s);
            }
        }
    }

//    @Test
//    public void no875_1() {
//        int[] piles = {3, 6, 7, 11};
//        int h = 8;
//        No875.Solution solution = new No875.Solution();
//        int i = solution.minEatingSpeed(piles, h);
//        assertEquals(4, i);
//    }
//
//    @Test
//    public void no875_2() {
//        int[] piles = {30, 11, 23, 4, 20};
//        int h = 5;
//        No875.Solution solution = new No875.Solution();
//        int i = solution.minEatingSpeed(piles, h);
//        assertEquals(30, i);
//    }
//
//    @Test
//    public void no875_3() {
//        int[] piles = {30, 11, 23, 4, 20};
//        int h = 6;
//        No875.Solution solution = new No875.Solution();
//        int i = solution.minEatingSpeed(piles, h);
//        assertEquals(23, i);
//    }
//    @Test
//    public void no875_4() {
//        int[] piles = {805306368,805306368,805306368};
//        int h = 1000000000;
//        No875.Solution solution = new No875.Solution();
//        int i = solution.minEatingSpeed(piles, h);
//        assertEquals(3, i);
//    }

    @Test
    public void no875_5() {
        IntStream.range(0, 10)
                .mapToObj(Cat::new)
                .forEach(System.out::println);
    }

    class Cat {
        private int age;

        public Cat() {
        }

        public Cat(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "age=" + age +
                    '}';
        }
    }
}
