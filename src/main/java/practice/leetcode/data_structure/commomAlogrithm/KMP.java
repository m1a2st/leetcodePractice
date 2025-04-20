package practice.leetcode.data_structure.commomAlogrithm;

import java.util.Arrays;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class KMP {
    public static void main(String[] args) {
        String str1 = "ABCDABD";
        int[] ints = kmpNext(str1);
        System.out.println(Arrays.toString(ints));
    }

    public static int violenceMatch(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int len1 = s1.length();
        int len2 = s2.length();
        int index1 = 0;
        int index2 = 0;

        while (index1 < len1 && index2 < len2) {//保證匹配時不越界
            if (c1[index1] == c2[index2]) {
                index1++;
                index2++;
            } else {
                index1 = index1 - (index2 - 1);
                index2 = 0;
            }
        }
        //判斷是否匹配成功
        if (index2 == len2) {
            return index1 - index2;
        }
        return -1;
    }

    /**
     * kmp搜尋法
     *
     * @param s1   原字符串
     * @param s2   子串
     * @param next 子串的部分匹配表
     * @return 如果是返回-1就是沒有匹配到，否則返回匹配的第一個位置
     */
    public static int KMP(String s1, String s2, int[] next) {
        //遍歷s1
        for (int i = 0, j = 0; i < s1.length(); i++) {
            //需要處理s1.charAt(i) != s2.charAt(j)
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = next[j - 1];
            }
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            if (j == s2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 獲取到一個字符串的部分匹配表
     *
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {
        //創建一個next 陣列保存部分匹配值
        int[] next = new int[dest.length()];
        //如果字符串是長度為1部分匹配值就是0
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            //當dest.charAt(i) != dest.charAt(j)，需要從next[j-1]獲取新的j
            //直到發現有dest.charAt(i) == dest.charAt(j)才退出
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            //當滿足dest.charAt(i) == dest.charAt(j)，部分匹配值+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
