package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.stream.Collectors;

public class TestClass {

    @Test
    public void drainTo() {
        ArrayBlockingQueue<Integer> deque = new ArrayBlockingQueue<>(10, true);
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        List<Integer> ls = new ArrayList<>();
        deque.drainTo(ls, 3);
        ls.forEach(System.out::println);
        deque.forEach(System.out::println);
    }

    @Test
    public void test() {
        BigDecimal b = new BigDecimal("1222.2232323");
        System.out.printf("%s%n", b);
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

    @Test
    public void test4() {
        ArrayList<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        Iterator<Integer> iterator = ls.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i == 1) {
                iterator.remove();
            }
        }
        ls.forEach(System.out::println);
    }

    @Test
    public void test5() {
        double d = 1.0;
        double d1 = 5.0;
        for (Operator value : Operator.values()) {
            System.out.println(value.apply((int) d, (int) d1));
        }
    }

    @Test
    public void test6() {
        new Cat(1);
    }
    
    @Test
    public void test7() {
        List<String> assignmentStrategies = null;
        Assertions.assertDoesNotThrow(() -> checkPartitionAssigmentStrategy(assignmentStrategies));
        List<String> assignmentStrategies1 = new ArrayList<>();
        Assertions.assertDoesNotThrow(() -> checkPartitionAssigmentStrategy(assignmentStrategies1));
        List<String> assignmentStrategies2 = List.of("a", "b", "c");
        Assertions.assertThrows(RuntimeException.class, () -> checkPartitionAssigmentStrategy(assignmentStrategies2));
    }
    
    @Test
    public void test8() {
        Map<String, Object> map = new HashMap<>();
        map.put("a", List.of(1, 2, 3));
        map.put("b", List.of(4, 5, 6));
        List<String> a = (List<String>) map.get("a");
        
    }
    
    @Test
    public void testTriFunction() {
        TriFunction<Integer, Integer, Integer, String> triFunction = (a, b, c) -> String.valueOf(a + b + c);
        String apply = triFunction.apply(1, 2, 3);
        System.out.println(apply);
    }

    private void checkPartitionAssigmentStrategy(List<String> assignmentStrategies) {
        if (assignmentStrategies != null && !assignmentStrategies.isEmpty()) {
            throw new RuntimeException();
        }
    }

    class Cat {
        int age;

        public Cat(int age) {
            System.out.println("constructor Cat");
            this.age = age;
        }

        static {
            System.out.println("static Cat");
        }

        {
            System.out.println("{} Cat " + age);
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

    @FunctionalInterface
    interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }
}
