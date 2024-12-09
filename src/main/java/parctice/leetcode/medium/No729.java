package parctice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class No729 {

    class MyCalendar {

        private final List<int[]> timeline = new ArrayList<>();
        
        public boolean book(int start, int end) {
            for (int[] t : timeline)
                if (Math.max(t[0], start) < Math.min(t[1], end))
                    return false;
            timeline.add(new int[] {start, end});
            return true;
        }
    }
}
