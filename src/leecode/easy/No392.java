package leecode.easy;

public class No392 {

    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0) return true;
            int pointer = 0;
            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == s.charAt(pointer)) {
                    pointer++;
                    if(pointer == s.length()){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
