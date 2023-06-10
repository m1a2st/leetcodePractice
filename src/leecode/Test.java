package leecode;


import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.stream().map(i -> i * 2)
                .flatMap(i -> l.stream().map(j -> i * j))
                .forEach(System.out::println);
    }

    public static <T> String clazzToCSVFormat(T t) {
        Class<?> clazz = t.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            // get declared field value
            declaredField.setAccessible(true);
            // get name and value
            try {
                System.out.println(declaredField.getName() + "\t" + declaredField.get(t));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
//            System.out.println(declaredField.getName() + "\t" + );
            // get declared field type

        }
        return "";
    }

    public static <T> Predicate<T> filter(T... t) {
        Predicate<T> filter = s -> false;
        for (T t1 : t) {
            filter = filter.or(s -> s.equals(t1));
        }
        return filter;
    }

    public static List<String> getDateRange(LocalDate startDate, LocalDate endDate) {
        List<String> dateRange = new ArrayList<>();
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            dateRange.add(currentDate.toString().replaceAll("-", ""));
            currentDate = currentDate.plusDays(1);
        }
        return dateRange;
    }


    public static class Cat {
        static {
            System.out.println("in static block of cat");
        }

        static String s = init();

        static String init() {
            System.out.println("init static method");
            return "";
        }

        public Cat() {
            System.out.println("in Cat constructor");
        }
    }

    public static List<Integer> removeDuplicate(List<Integer> arr) {
        Collections.sort(arr);
        int left = 0, right = 0;
        List<Integer> result = new ArrayList<>();
        while (right < arr.size()) {
            if (arr.get(left) == arr.get(right)) {
                right++;
            } else {
                result.add(arr.get(left));
                left = right;
            }
        }
        return result;
    }

    public static String add(String context) {
        int len = context.length();
        int half = len / 2;
        StringBuilder sb = new StringBuilder(context);
        for (int i = 5 - half; i > 0; i--) {
            sb.insert(0, "-");
            sb.append("-");
        }
        return sb.toString();
    }

    public static String reverse(String input) {
        if (input.length() > 0) {
            String other = input.substring(1);
            String sub = input.substring(0, 1);
            return reverse(other) + sub;
        }
        return input;
    }

    public static String reverse1(String input) {
        List<String> s = new ArrayList<>(Arrays.stream(Optional.of(input)
                        .orElse("")
                        .split(""))
                .toList());
        Collections.reverse(s);
        return String.join("", s);
    }

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (res.containsKey(target - arr[i])) {
                return new int[]{res.get(arr[i]), i};
            } else {
                res.put(arr[i], i);
            }
        }
        return new int[]{};
    }

    public static int duplicate(int[] nums) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int num : nums) {
            if (res.containsKey(num)) {
                return num;
            } else {
                res.put(num, 1);
            }
        }
        return -1;
    }

    private static int[] removeDuplicate(int[] arr) {
        int left = 0, right = 1, point = 0;
        int len = arr.length;
        while (right < len) {
            if (arr[left] != arr[right]) {
                point++;
                arr[point] = arr[right];
                left = right;
            }
            right++;
        }
        return Arrays.copyOfRange(arr, 0, point + 1);
    }

    public static void checkPerson(Object obj) {
        if (obj instanceof Person p) {
            System.out.println(p.name());
            System.out.println(p.age());
            System.out.println("obj is a Person");
        } else {
            System.out.println("obj is not a Person");
        }

    }

}

record Person(String name, int age) {
    public Person {
        System.out.println("in Person constructor");
    }
}

//class Cat implements Serializable {
//
//    private int age;
//    private int name;
//
//    public static Builder builder() {
//        return new Builder();
//    }
//
//    public static class Builder {
//
//        private final Cat cat;
//
//        public Builder() {
//            cat = new Cat();
//        }
//
//        public Builder age(int age) {
//            cat.age = age;
//            return this;
//        }
//
//        public Cat name(int name) {
//            cat.name = name;
//            return cat;
//        }
//
//        public Cat build() {
//            return cat;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "Cat{" +
//                "age=" + age +
//                ", name=" + name +
//                '}';
//    }
//}
