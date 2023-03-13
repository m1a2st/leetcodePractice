package leecode;

import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        IntStream.range(1, 100).map(s -> random.nextInt(10)).forEach(System.out::println);
        Optional.ofNullable(null).orElseThrow(() -> new IndexOutOfBoundsException(""));
    }
}
