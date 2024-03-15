package leetcode.practice;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class CharCantRepeat {
    public static void main(String[] args) {
        String str = "wqazsx";
        System.out.println(compareChar(str));
    }

    public static boolean compareChar(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            System.out.println(val);
            if((checker & (1 << val)) > 0){
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
