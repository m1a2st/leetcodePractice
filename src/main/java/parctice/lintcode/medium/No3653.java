package main.java.parctice.lintcode.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

public class No3653 {

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // slots1 = [(10,50),(60,120),(140,210)]
    // slots2 = [(0,15),(60,70)]
    // duration = 8
    @Test
    public void test() {
        Interval i1 = new Interval(10, 50);
        Interval i2 = new Interval(60, 120);
        Interval i3 = new Interval(140, 210);
        Interval i4 = new Interval(0, 15);
        Interval i5 = new Interval(60, 70);
        List<Interval> slots1 = List.of(i1, i2, i3);
        List<Interval> slots2 = List.of(i4, i5);
        Interval interval = new Solution().earliestAppropriateDuration(slots1, slots2, 8);
        System.out.println(interval.start + " " + interval.end);
    }

    // slots1 = [(10,50),(60,120),(140,210)]
    // slots2 = [(0,15),(60,70)]
    // duration = 12
    @Test
    public void test2() {
        Interval i1 = new Interval(10, 50);
        Interval i2 = new Interval(60, 120);
        Interval i3 = new Interval(140, 210);
        Interval i4 = new Interval(0, 15);
        Interval i5 = new Interval(60, 70);
        List<Interval> slots1 = List.of(i1, i2, i3);
        List<Interval> slots2 = List.of(i4, i5);
        Interval interval = new Solution().earliestAppropriateDuration(slots1, slots2, 12);
        System.out.println(interval.start + " " + interval.end);
    }

    public class Solution {
        public Interval earliestAppropriateDuration(List<Interval> slots1,
                                                    List<Interval> slots2,
                                                    int duration) {
            int lastTime = Math.max(slots1.get(slots1.size() - 1).end, slots2.get(slots2.size() - 1).end);
            int s1Index = 0;
            int s2Index = 0;
            int counter = 0;
            int start = Integer.MAX_VALUE;
            Interval i1 = slots1.get(s1Index);
            Interval i2 = slots2.get(s2Index);
            for (int i = 0; i < lastTime; i++) {
                if (i >= i1.start && i <= i1.end) {
                    if (i >= i2.start && i <= i2.end) {
                        start = Math.min(start, i);
                        if (counter++ == duration) {
                            return new Interval(start, i + 1);
                        }
                    }
                } else {
                    counter = 0;
                    start = Integer.MAX_VALUE;
                }
                if (i > i1.end && ++s1Index < slots1.size()) {
                    i1 = slots1.get(s1Index);
                }
                if (i > i2.end && ++s2Index < slots2.size()) {
                    i2 = slots2.get(s2Index);
                }
            }
            return new Interval(-1, -1);
        }
    }
}
