package test;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestClass {

    @Test
    public void test() {
        HashSet<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        Integer[] arr = new Integer[1];
        arr[0] = 1;
        Arrays.stream(arr)
                .filter(i -> integers.contains(i))
                .findFirst()
                .orElseThrow(RuntimeException::new);
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
