package practice.nio.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class EchoHandler implements Runnable {

    final SocketChannel socketChannel;
    final SelectionKey sk;
    private final int CAPACITY = 1024;
    final ByteBuffer byteBuffer = ByteBuffer.allocate(CAPACITY);
    // 處理器的狀態： 發送和接收，一個連接對應一個處理器
    static final int RECEIVING = 0, SENDING = 1;
    int state = RECEIVING;

    public EchoHandler(Selector selector, SocketChannel channel) throws IOException {
        socketChannel = channel;
        // 設置非阻塞
        channel.configureBlocking(false);
        sk = channel.register(selector, 0);
        // 將 Handler 自身作為選擇鍵的附件，一個連接對應一個處理器實例
        sk.attach(this);
        // 註冊 Read 就緒事件
        sk.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    @Override
    public void run() {
        try {
            if (state == SENDING) {
                // 寫操作，把數據寫入通道
                socketChannel.write(byteBuffer);
                // 將 bytebuffer 切換為寫入模式，寫完後準備讀取
                byteBuffer.clear();
                // 再次註冊 Read 就緒事件
                sk.interestOps(SelectionKey.OP_READ);
                state = RECEIVING;
            } else if (state == RECEIVING) {
                // 讀操作
                int length;
                while ((length = socketChannel.read(byteBuffer)) > 0) {
                    System.out.println(new String(byteBuffer.array(), 0, length));
                }
                // 讀取完畢後，翻轉 Buffer的讀取模式
                byteBuffer.flip();
                // 註冊 Write 就緒事件
                sk.interestOps(SelectionKey.OP_WRITE);
                state = SENDING;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
