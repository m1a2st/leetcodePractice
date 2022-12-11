package leecode.easy;

import java.util.Arrays;
import java.util.stream.Stream;

public class No14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int index = 0;
            while ((index < prefix.length() && index < strs[i].length() && prefix.charAt(index) == strs[i].charAt(index)))
            {
                index++;
            }
            prefix=prefix.substring(0,index);
        }
        if(prefix.length()>0){
            return prefix;
        }
        return "";
    }
}
