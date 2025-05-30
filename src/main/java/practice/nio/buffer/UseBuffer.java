package practice.nio.buffer;

import java.nio.IntBuffer;

public class UseBuffer {

    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(20);

        for (int i = 0; i < 5; i++) {
            buffer.put(i);
        }
        System.out.println("==============================");
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

        buffer.flip();

        System.out.println("==============================");
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

        while (buffer.hasRemaining()) {
            buffer.get();
        }

        System.out.println("==============================");
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

        buffer.rewind();

        System.out.println("==============================");
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

        for (int i = 0; i < 2; i++) {
            buffer.get();
        }

        buffer.mark();

        System.out.println("==============================");
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

        for (int i = 2; i < 5; i++) {
            buffer.get();
        }

        System.out.println("==============================");
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());

        buffer.reset();

        System.out.println("==============================");
        System.out.println("position: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        System.out.println("capacity: " + buffer.capacity());
    }
}
