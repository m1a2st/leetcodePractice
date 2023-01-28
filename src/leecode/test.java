package leecode;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Ken
 * @Date
 * @Version
 * @Description
 */
public class test {
    public static void main(String[] args) throws IOException {
//        String[] parameter = {"/Users/ken/Desktop/test.sh","1","22","333","4444"};
//
//        Process process = Runtime.getRuntime().exec(parameter);
//        process.destroy();
//        InputStream inputStream = process.getInputStream();
//        BufferedInputStream bis = new BufferedInputStream(inputStream);
//        byte[] buffer = new byte[1024];
//        int bytesRead = 0;
//        while ((bytesRead = bis.read(buffer)) != -1) {
//            String topString = new String(buffer, 0, bytesRead);
//            System.out.println(topString);
//        }

//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE,7);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//        String format = sdf.format(calendar.getTime());
//        System.out.println(format);

        HashMap<Integer, Integer> hashMap = new HashMap<>() {{
            put(1, 10);
            put(2, 20);
            put(3, 30);
            put(4, 40);
            put(5, 50);
            put(6, 60);
        }};
        Supplier<Stream<Map.Entry<Integer,Integer>>> sup = () -> hashMap.entrySet().stream();
        List<Integer> collect = sup.get().map(Map.Entry::getKey).collect(Collectors.toList());
        List<Integer> collect1 = sup.get().map(s -> s.getValue()).collect(Collectors.toList());

        collect.forEach(System.out::println);
        collect1.forEach(System.err::println);

    }
}

