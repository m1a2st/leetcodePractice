package practice.thread.basic;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueuePetStore {

    public static final int MAX_AMOUNT = 10;

    static class DataBuffer<T> {

        private final ArrayBlockingQueue<T> dataList = new ArrayBlockingQueue<>(MAX_AMOUNT);

        public void put(T data) throws Exception {
            dataList.put(data);
        }

        public T fetch() throws Exception {
            return dataList.take();
        }
    }

    public static void main(String[] args) {

    }
}
