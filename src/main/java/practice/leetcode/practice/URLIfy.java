package practice.leetcode.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class URLIfy {

    @Test
    public void space_to_percent20() {
        String str = "Mr John Smith";
        String result = space2Percent20(str);
        Assertions.assertEquals("Mr%20John%20Smith", result);
    }

    private String space2Percent20(String str) {
        String[] split = str.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(" ")) {
                split[i] = "%20";
            }
            sb.append(split[i]);
        }
        return sb.toString();
    }


}
