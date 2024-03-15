package leetcode.practice;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class DynamicFib {
    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(fib(i));
//        }
        allFib(4);
    }

    public static void allFib(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int fib = fib(i, memo);
            System.out.println(i + ":" + fib);
        }
    }

    /**
     * fib(0) -> return 0;
     * fib(1) -> return 1;
     * fib(2)
     *  fib(0) -> return 0;
     *  fib(1) -> return 1;
     *  store 1 at memo[2]
     * fib(3)
     *  fib(2) -> lookup memo[2] -> return 1;
     *  fib(1) -> return 1;
     *  store 2 at memo[3]
     * ...
     * @param n 費波那契數列第n項
     * @param memo 儲存費波那契數列的值
     * @return 費波那契數列第n項的值
     */
    private static int fib(int n, int[] memo) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (memo[n] > 0) return memo[n];
        memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        return memo[n];
    }

    private static int fib(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else return fib(n-1)+fib(n-2);
    }
}
