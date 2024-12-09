package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class No1993 {

    @Test
    public void test() {
        LockingTree tree = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(tree.lock(2, 2));    // 返回 true ，因为节点 2 未上锁。
        System.out.println(tree.unlock(2, 3));  // 返回 false ，因为指定节点 2 已经上锁。
        System.out.println(tree.unlock(2, 2));  // 返回 true ，因为指定节点 2 未上锁且当前节点 2 的上层节点未上锁。
        System.out.println(tree.lock(4, 5));    // 返回 true ，因为节点 4 未上锁。
        System.out.println(tree.upgrade(0, 1)); // 返回 false ，因为节点 0 有一个被上锁的后代节点 4 。
        System.out.println(tree.upgrade(2, 1)); // 返回 false ，因为节点 2 的子节点未全部上锁。
        System.out.println(tree.lock(2, 1));    // 返回 true ，因为节点 2 的所有前代节点都未上锁且节点 2 未上锁。
        System.out.println(tree.upgrade(2, 1)); // 返回 true ，因为节点 2 的所有前代节点都未上锁且节点 2 未上锁且节点 2 没有被上锁的后代节点。
    }

    class Node {
        public List<Integer> children = new ArrayList<>();
        public int lockedBy = -1;
    }

    class LockingTree {

        private final int[] parent;
        private final Node[] nodes;

        public LockingTree(int[] parent) {
            this.parent = parent;
            nodes = new Node[parent.length];
            for (int i = 0; i < parent.length; ++i) {
                nodes[i] = new Node();
            }
            for (int i = 1; i < parent.length; ++i) {
                nodes[parent[i]].children.add(i);
            }
        }

        public boolean lock(int num, int user) {
            if (nodes[num].lockedBy != -1) {
                return false;
            }
            nodes[num].lockedBy = user;
            return true;
        }

        public boolean unlock(int num, int user) {
            if (nodes[num].lockedBy != user)
                return false;
            nodes[num].lockedBy = -1;
            return true;
        }

        public boolean upgrade(int num, int user) {
            if (nodes[num].lockedBy != -1)
                return false;
            if (!anyLockedDescendant(num))
                return false;

            // Walk up the hierarchy to ensure that there are no locked ancestors.
            for (int i = num; i != -1; i = parent[i])
                if (nodes[i].lockedBy != -1)
                    return false;

            unlockDescendants(num);
            nodes[num].lockedBy = user;
            return true;
        }

        private boolean anyLockedDescendant(int i) {
            return nodes[i].lockedBy != -1 ||
                    nodes[i].children
                            .stream()
                            .anyMatch(this::anyLockedDescendant);
        }

        private void unlockDescendants(int i) {
            nodes[i].lockedBy = -1;
            for (final int child : nodes[i].children)
                unlockDescendants(child);
        }

    }

}
