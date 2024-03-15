package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class No118 {

    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            // init first floor
            List<Integer> first = new ArrayList<>();
            first.add(1);
            ans.add(first);
            // floor
            for (int i = 2; i <= numRows; i++) {
                List<Integer> floor = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    List<Integer> beforeFloor = ans.get(i - 2);
                    if (j == 0 || j == i - 1) {
                        floor.add(1);
                    } else {
                        floor.add(beforeFloor.get(j - 1) + beforeFloor.get(j));
                    }
                }
                ans.add(floor);
            }
            return ans;
        }
    }
}
