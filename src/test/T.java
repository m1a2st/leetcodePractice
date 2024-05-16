package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class T {

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
            // FIXME
            if (index >= windowSize) {
                // 當讀取的行數大於窗口大小時，就輸出當前窗口中的最大值
                System.out.println(maxInWin.max());
            }
            index++;
        }
    }
}

class MaxInSlidingWindow {
    // 使用一個雙端隊列 Deque 來存儲滑動窗口中的元素的索引值，將最大的始終存放在隊首
    Deque<Long> deq = new LinkedList<>();
    // 因應使用 BufferReader 讀取輸入，因此使用一個雙端隊列 Deque 來儲存索引
    Deque<Long> indices = new LinkedList<>();

    public void in(long num, long index, long windowSize) {
        // 移除窗口外的元素
        while (!indices.isEmpty() && indices.peekFirst() < index - windowSize + 1) {
            deq.removeFirst();
            indices.removeFirst();
        }

        // 從 'deq' 中移除所有小於 'num' 的數字
        while (!deq.isEmpty() && deq.peekLast() < num) {
            deq.removeLast();
            indices.removeLast();
        }

        // 加入 'num' 到 'deq'
        deq.addLast(num);
        // 加入 'index' 到 'indices'
        indices.addLast(index);
    }

    public long max() {
        // 'deq' 的第一個元素即為窗口中的最大值
        return deq.peekFirst();
    }
}
