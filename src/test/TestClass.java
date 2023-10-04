package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestClass {

    @Test
    public void test1(){
        System.out.println(Test.class.getSimpleName());
    }

    @Test
    public void test2() {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("java.version"));
    }

//    @Test
//    public void test() {
//        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            list.add("a" + i);
//        }
//
//        for (String s : list) {
//            if (s.equals("a3")) {
//                list.remove(s);
//            }
//        }
//    }

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
    public void test3() {
        Map<String, List<Cat>> map = new HashMap<>() {{
            put("a", List.of(new Cat(1)));
            put("b", List.of(new Cat(2)));
            put("c", List.of(new Cat(3)));
            put("d", List.of(new Cat(4)));
            put("e", List.of(new Cat(5)));
        }};
        Map<String, List<NewCat>> collect = map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .map(Cat::toNewCat).collect(Collectors.toList())));


    }


    class Cat {
        int age;

        public Cat(int age) {
            this.age = age;
        }

        public NewCat toNewCat() {
            return new NewCat(age);
        }
    }

    class NewCat {
        int age;

        public NewCat(int age) {
            this.age = age;
        }
    }
}
