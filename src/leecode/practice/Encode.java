package leecode.practice;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class Encode {

    private static String caesarCipher(String pwd, int key, boolean encrypt) {
        StringBuilder sb = new StringBuilder();
        if (encrypt) {
            pwd.chars().map(s -> encode(s, key)).forEach(s -> sb.append((char) s));
        } else {
            pwd.chars().map(s -> decode(s, key)).forEach(s -> sb.append((char) s));
        }
        return sb.toString();
    }

    private static int decode(int origin, int key) {
        if (origin == 32) return 32;
        else return (origin - key - 65 + 26) % 26 + 65;
    }

    private static int encode(int origin, int key) {
        if (origin == 32) return 32;
        else return (origin + key - 65) % 26 + 65;
    }

    public static void main(String[] args) {
        System.out.println(caesarCipher("TODAY IS A GOOD DAY", 7, true));
        System.out.println(caesarCipher("AVKHF PZ H NVVK KHF", 7, false));
    }

}
