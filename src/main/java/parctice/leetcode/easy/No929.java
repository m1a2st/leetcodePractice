package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class No929 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int i = solution.numUniqueEmails(new String[]{
                "a@leetcode.com", "b@leetcode.com", "c@leetcode.com"
        });
        System.out.println(i);
    }

    class Solution {
        public int numUniqueEmails(String[] emails) {
            HashMap<String, Set<String>> receive = new HashMap<>();
            for (String email : emails) {
                String[] splitAt = email.split("@");
                String account = splitAt[0].split("\\+")[0]
                        .replaceAll("\\.", "");
                String domain = splitAt[1];
                if (!receive.containsKey(domain)) {
                    Set<String> accounts = new HashSet<>();
                    accounts.add(account);
                    receive.put(domain, accounts);
                } else {
                    Set<String> accounts = receive.get(domain);
                    accounts.add(account);
                }
            }
            return receive.entrySet().stream().flatMap(e -> e.getValue().stream()).toList().size();
        }
    }
}
