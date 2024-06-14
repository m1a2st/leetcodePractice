package leetcode.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class Test {
    
    @org.junit.jupiter.api.Test
    public void test() {
        LocalDate startDate = LocalDate.of(2021, 1, 1);
        LocalDate endDate = LocalDate.of(2021, 1, 2);
        System.out.println(startDate.isBefore(endDate));
        System.out.println(startDate.isAfter(endDate));
    }

    @org.junit.jupiter.api.Test
    public void test1() {
        String s = "abs測試DCF123";
        System.out.println(s.toUpperCase(Locale.ENGLISH));
    }

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Test.class.getClassLoader();
        String path = classLoader.getResource("big5.txt").getPath();
        System.out.println(path);
        FileChannel open = FileChannel.open(Path.of(path));
        MappedByteBuffer map = open.map(FileChannel.MapMode.READ_ONLY, 0, open.size());
        CharBuffer decode = Charset.forName("big5").decode(map);
        System.out.println(decode);
    }


    public static class Server {
        public static void initPerson() throws Exception {
            //配置JNDI工厂和JNDI的url和端口。如果没有配置这些信息，会出现NoInitialContextException异常
            LocateRegistry.createRegistry(6666);
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
            System.setProperty(Context.PROVIDER_URL, "rmi://localhost:6666");

            //初始化
            InitialContext ctx = new InitialContext();

            //实例化person对象
            Person p = new Person();
            p.setName("0range");
            p.setPassword("Niubility!");

            //person对象绑定到JNDI服务中，JNDI的名字叫做：person。
            ctx.bind("person", p);
            ctx.close();
        }

        public static void findPerson() throws Exception {
            //因为前面已经将JNDI工厂和JNDI的url和端口已经添加到System对象中，这里就不用再绑定了
            InitialContext ctx = new InitialContext();

            //通过lookup查找person对象
            Person person = (Person) ctx.lookup("person");

            //打印出这个对象
            System.out.println(person.toString());
            ctx.close();
        }
    }

    public static class Person implements Remote, Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String toString() {
            return "name:" + name + " password:" + password;
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
//            System.out.println(p.name());
//            System.out.println(p.age());
            System.out.println("obj is a Person");
        } else {
            System.out.println("obj is not a Person");
        }

    }

}