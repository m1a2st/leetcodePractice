package leecode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author m1a2st
 * @Date 2023/6/26
 * @Version v1.0
 */
public class No981 {

    class T {
        public String value;
        public int timestamp;

        public T(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    class TimeMap {
        private final Map<String, List<T>> map = new HashMap<>();

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new T(value, timestamp));
        }

        public String get(String key, int timestamp) {
            List<T> A = map.get(key);
            if (A == null)
                return "";

            int l = 0;
            int r = A.size();

            while (l < r) {
                final int m = (l + r) / 2;
                if (A.get(m).timestamp > timestamp)
                    r = m;
                else
                    l = m + 1;
            }

            return l == 0 ? "" : A.get(l - 1).value;
        }
    }
}
