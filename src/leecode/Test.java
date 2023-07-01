package leecode;


import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class Test {

    public static void main(String[] args) {
        int i = 1;
        switch (i) {
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            default:
                System.out.println("default");
        }
    }


    public static List<Integer> ss(List<Integer> ss) {
        return ss.stream().filter(s -> s / 2 == 0).collect(Collectors.toList());
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

    public static String convertToCamelCase(String kebabCaseInput) {
        kebabCaseInput = kebabCaseInput.toLowerCase();
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = false;

        for (int i = 0; i < kebabCaseInput.length(); i++) {
            char currentChar = kebabCaseInput.charAt(i);

            if (currentChar == '-') {
                capitalizeNext = true;
            } else {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(currentChar));
                    capitalizeNext = false;
                } else {
                    result.append(currentChar);
                }
            }
        }

        return result.toString();
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

record Person(String name, int age, String date) implements Comparable<Person> {

    @Override
    public int compareTo(Person o) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            return sdf.parse(this.date()).compareTo(sdf.parse(o.date()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

class Constant {
    public static final String A = "a";
    public static final String B = "b";
    public static final String C = "c";
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
