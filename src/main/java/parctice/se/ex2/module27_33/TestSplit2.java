package main.java.parctice.se.ex2.module27_33;

public class TestSplit2 {
    public static void main(String[] args) {

        String str1 = "boo:and:foo";

        String[] tokens1 = str1.split(":"); // { "boo", "and", "foo" }
        for (int i = 0; i < tokens1.length; i++) {
            System.out.println(tokens1[i]);
        }

        System.out.println("-----------------------");

        String[] tokens2 = str1.split("o"); // { "b", "", ":and:f" } //參考String API文件的split方法
        for (int i = 0; i < tokens2.length; i++) {
            System.out.println(tokens2[i]);
        }

        System.out.println("-----------------------");

        String[] tokens3 = str1.split("o+"); // { "b", ":and:f" } //+指任意多個重複的字元
        for (int i = 0; i < tokens3.length; i++) {
            System.out.println(tokens3[i]);
        }

        System.out.println("-----------------------");

        String str = "http://tw.yahoo.com";
        String[] tokens = str.split("[:/.]+"); // { "http", "tw", "yahoo", "com" } //[]指在[]中的任意一個字元

        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
    }
}
