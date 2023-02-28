package leecode;

import org.junit.platform.commons.util.StringUtils;

import java.io.IOException;
import java.util.Optional;

/**
 * @Author Ken
 * @Date
 * @Version
 * @Description
 */
public class test {
    public static void main(String[] args) throws IOException {
//        String s = "0123456789";
//        System.out.println(s.substring(0, 4));
//        String s = null;
//        System.out.println(Optional.of(s).filter(StringUtils::isNotBlank).map(Integer::valueOf).orElse(0));
        String s = "fewfuwgfi";
        Optional.ofNullable(s).orElseThrow(()->new IndexOutOfBoundsException());
    }
}

