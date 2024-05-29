package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LineCode {

//    public static void main (String[] args) throws java.lang.Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//
//        // 將第一行讀到的字串轉為數字陣列
//        int[] elements = Arrays.stream(line.split(" "))
//                .mapToInt(Integer::parseInt).toArray();
//        // 目標值
//        int target = Integer.parseInt(br.readLine());
//        int[] ans = findSticks(elements, target);
//        if (ans[0] == -1) {
//            System.out.println(-1);
//        } else {
//            System.out.printf("%d %d%n", ans[0], ans[1]);
//        }
//    }

    /**
     * 時間複雜度：O(nlogn) + O(n) = O(nlogn)
     * 1. 因為答案可能有多組，而且希望找到最小的差值，所以先將木棍陣列排序
     * 2. 使用一個 Set 來存儲目標值與木棍的差值
     * 3. 如果 Set 中已經存在當前木棍
     * 4. 跟最小值比較，如果當前差值比最小值還小，則更新最小值和另一根木棍
     */
    private static int[] findSticks(int[] sticks, int target) {
        Arrays.sort(sticks);
        Set<Integer> diffSets = new HashSet<>();
        int minAns = Integer.MAX_VALUE;
        int maxAns = 0;
        for (int stick : sticks) {
            int diff = target - stick;
            if (diffSets.contains(stick)) {
                if (diff < minAns) {
                    minAns = diff;
                    maxAns = stick;
                }
            } else {
                diffSets.add(diff);
            }
        }
        return maxAns == 0 ? new int[]{-1, -1} : new int[]{minAns, maxAns};
    }

    public class CircularQueue {
        private final String[] elements;
        private int head = 0;
        private int tail = 0;
        private final int capacity;

        public CircularQueue(int capacity) {
            this.capacity = capacity;
            elements = new String[capacity];
        }

        public boolean offer(String element) {
            if (size() == capacity) {
                // The queue is full
                return false;
            }
            elements[tail] = element;
            tail = (tail + 1) % capacity;
            return true;
        }

        public String take() {
            if (size() == 0) {
                // The queue is empty
                return null;
            }
            String result = elements[head];
            head = (head + 1) % capacity;
            return result;
        }

        public int size() {
            return (tail + capacity - head) % capacity;
        }
    }

    public class Main {

        enum State {
            INIT, VISITING, VISITED
        }

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // 讀取節點數量
            int n = Integer.parseInt(reader.readLine());

            // 建立邊的數據結構
            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                edges.add(new ArrayList<>());
            }

            // 使用鄰接表存儲有向圖
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                String[] splitLine = line.split(" ");
                int fromNode = Integer.parseInt(splitLine[0]);
                int toNode = Integer.parseInt(splitLine[1]);
                edges.get(fromNode).add(toNode);
            }

            // 檢查有向圖中是否存在循環
            State[] visited = new State[n];
            for (int i = 0; i < n; i++) {
                if (hasCycle(i, visited, edges)) {
                    System.out.println("true");
                    return;
                }
            }
            System.out.println("false");
        }

        private static boolean hasCycle(int node, State[] visited, List<List<Integer>> edges) {
            if (visited[node] == State.VISITING) {
                // 節點已在訪問中，存在循環
                return true;
            }
            if (visited[node] == State.VISITED) {
                // 節點已被訪問過，則直接返回 false
                return false;
            }
            visited[node] = State.VISITING;
            for (int edge : edges.get(node)) {
                if (hasCycle(edge, visited, edges)) {
                    return true;
                }
            }
            visited[node] = State.VISITED;
            return false;
        }
    }

    static class Pair {
        long value;
        long index;

        public Pair(long value, long index) {
            this.value = value;
            this.index = index;
        }
    }

    static class MaxInSlidingWindow {
        // 使用一個雙端隊列 Deque 來存儲滑動窗口中的元素的索引值，將最大的始終存放在隊首
        Deque<Pair> dequeue = new ArrayDeque<>();

        /**
         * 將新的元素 num 插入到窗口中
         * 若「索引值」已超出窗口大小，則將隊首元素移除，直到隊首元素的索引值在窗口範圍內
         * 如果新的元素 num 大於隊尾元素，則將隊尾元素移除，直到隊尾元素大於等於新元素 num
         * 維持隊列中元素的降序排列
         */
        public void in(long num, long index, long windowSize) {
            while (!dequeue.isEmpty() && dequeue.peekFirst().index < index - windowSize + 1) {
                dequeue.removeFirst();
            }

            while (!dequeue.isEmpty() && dequeue.peekLast().value < num) {
                dequeue.removeLast();
            }

            dequeue.addLast(new Pair(num, index));
        }

        public long getMaxValue() {
            return dequeue.peekFirst().value;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MaxInSlidingWindow maxInWin = new MaxInSlidingWindow();

        // 從第一行讀取窗口大小
        long windowSize = Long.parseLong(reader.readLine().trim());

        String line;
        long index = 0;
        while ((line = reader.readLine()) != null) {
            long num = Long.parseLong(line);
            maxInWin.in(num, index, windowSize);
            if (index >= windowSize - 1) {
                // 當讀取的行數大於窗口大小時，就輸出當前窗口中的最大值
                System.out.println(maxInWin.getMaxValue());
            }
            index++;
        }
    }
}
