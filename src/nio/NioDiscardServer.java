package nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import static java.nio.channels.SelectionKey.OP_ACCEPT;
import static java.nio.channels.SelectionKey.OP_READ;

public class NioDiscardServer {

    public static void main(String[] args) throws IOException {

        // 1. 獲取選擇器
        Selector selector = Selector.open();

        // 2. 打開通道
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        // 3. 設置非阻塞
        socketChannel.configureBlocking(false);
        // 4. 綁定端口
        socketChannel.bind(new java.net.InetSocketAddress(6000));
        System.out.println("Server started at port 6000");
        // 5. 將通道註冊的"接受新連接"IO事件註冊到選擇器上
        socketChannel.register(selector, OP_ACCEPT);

        //6. 輪巡感興趣的IO事件
        while (selector.select() > 0) {
            // 7. 獲取選擇器中所有的選擇鍵
            var keys = selector.selectedKeys();
            for (var key : keys) {
                // 8. 根據具體的IO事件類型處理
                if (key.isAcceptable()) {
                    // 9. 若選擇器的 IO 事件是"連接就緒"，則接受新的連接
                    SocketChannel channel = socketChannel.accept();
                    // 10. 將新連接設置非阻塞
                    channel.configureBlocking(false);
                    // 11. 將新連接註冊的"讀取"IO事件註冊到選擇器上
                    channel.register(selector, OP_READ);
                } else if (key.isReadable()) {
                    // 12. 若選擇器的 IO 事件是"讀取就緒"，則讀取數據
                    SocketChannel channel = (SocketChannel) key.channel();

                    // 13. 創建緩衝區
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length;
                    // 14. 讀取數據
                    while ((length = channel.read(byteBuffer)) > 0) {
                        // 15. 切換緩衝區的模式
                        byteBuffer.flip();
                        // 16. 打印數據
                        System.out.println(new String(byteBuffer.array(), 0, length));
                        // 17. 清空緩衝區
                        byteBuffer.clear();
                    }
                    // 18. 關閉通道
                    channel.close();
                }
                // 19. 移除選擇鍵
                keys.remove(key);
            }
        }
        socketChannel.close();
    }
}
