package test;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestClass {

    @Test
    public void test() {
        StringBuilder sb = new StringBuilder();
        sb.append("123");
        app(sb);
        System.out.println(sb);
    }

    void app(StringBuilder sb) {
        sb.append("456");
    }

    @Test
    public void test1() {
        System.out.println(Test.class.getSimpleName());
    }

    @Test
    public void test2() {
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("java.version"));
    }

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
