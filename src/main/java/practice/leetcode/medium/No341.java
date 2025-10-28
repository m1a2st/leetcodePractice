package practice.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class No341 {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        private final Queue<Integer> q = new ArrayDeque<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            addInteger(nestedList);
        }

        @Override
        public Integer next() {
            return q.poll();
        }

        @Override
        public boolean hasNext() {
            return !q.isEmpty();
        }

        private void addInteger(final List<NestedInteger> nestedList) {
            for (final NestedInteger ni : nestedList)
                if (ni.isInteger())
                    q.offer(ni.getInteger());
                else
                    addInteger(ni.getList());
        }
    }
}
