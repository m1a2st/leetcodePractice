package leecode.easy;

/**
 * @Author m1a2st
 * @Date 2023/4/15
 * @Version v1.0
 */
public class No28 {

    public static void main(String[] args) {
        Solution.strStr("a","a");
    }

    static class Solution {
        public static int strStr(String haystack, String needle) {
            int needLen = needle.length();
            int hayLen = haystack.length();
            for (int i = 0; i <= hayLen - needLen; i++) {
                if (haystack.substring(i, i + needLen).equals(needle)) {
                    return i;
                }
            }
            return -1;
        }

//        public static int strStr(String haystack, String needle) {
//            return haystack.indexOf(needle);
//        }
    }
}
