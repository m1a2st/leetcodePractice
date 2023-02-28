package leecode.practice;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.sqrt;
import static java.lang.String.format;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class Gcd {

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int r = max % min;
        if (r == 0) {
            return min;
        }
        return gcd(min, r);
    }

    public static int[] linearCombination(int a, int b) {
        int[] divMod = divMod(a, b);
        int q = divMod[0];
        int r = divMod[1];
        if (r == 0) {
            return new int[]{0, 1};
        } else {
            int[] arr = linearCombination(b, r);
            return new int[]{arr[1], arr[0] - q * arr[1]};
        }
    }

    private static int[] divMod(int a, int b) {
        return new int[]{a / b, a % b};
    }

    private static boolean isPrime(int n) {
        if (n == 1) return false;
        if (n < 4) return true;
        for (int i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static String fundamental(int a) {
        StringBuilder result = new StringBuilder(format("%d = ", a));
        int i = 2;
        while (a != 1) {
            if (a % i == 0) {
                a = a / i;
                result.append(format("%d * ", i));
            } else {
                i++;
            }
        }
        return result.substring(0, result.length() - 2);
    }

    private static void totient(int a) {
        Set<Integer> set = new HashSet<>();
        int copy = a;
        int i = 2;
        while (a != 1) {
            if (a % i == 0) {
                set.add(i);
                a = a / i;
            } else {
                i++;
            }
        }
        // 120(2-1)(3-1)(5-1) / (2 * 3 * 5)
        int q = 1;
        int z = 1;
        for (Integer integer : set) {
            q *= integer - 1;
            z *= integer;
        }
        System.out.println(copy * q / z);
    }

    public static void main(String[] args) {
    }
}
