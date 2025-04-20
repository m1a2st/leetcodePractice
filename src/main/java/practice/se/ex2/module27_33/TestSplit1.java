package practice.se.ex2.module27_33;

import java.util.StringTokenizer;

public class TestSplit1 {
    public static void main(String[] args) {

        String str = "This is a book";

        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        System.out.println("-----------------------");

        // 比較
        String[] tokens = str.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }

        System.out.println("-----------------------");

        String str1 = "That-is-a-pen";

        StringTokenizer st1 = new StringTokenizer(str1, "-");
        while (st1.hasMoreTokens()) {
            System.out.println(st1.nextToken());
        }

        System.out.println("-----------------------");

        // 比較
        String[] tokens1 = str1.split("-");
        for (int i = 0; i < tokens1.length; i++) {
            System.out.println(tokens1[i]);
        }

    }
}
