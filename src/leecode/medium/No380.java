package leecode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class No380 {

    class RandomizedSet {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            } else {
                map.put(val, 1);
                ls.add(val);
                return true;
            }
        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                map.remove(val);
                ls.remove((Object)val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            int r = random.nextInt(map.size() + 1);
            return ls.get(r);
        }
    }
}
