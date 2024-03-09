package nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.HashMap;

import static java.nio.channels.SelectionKey.OP_ACCEPT;
import static java.nio.channels.SelectionKey.OP_READ;

public class NioFileServer {

    public static void main(String[] args) {

    }

    static class NioServer {
        private static final String RECEIVE_PATH = "./receive/";
        private static final Charset charset = Charset.forName("UTF-8");
        private ByteBuffer buffer = ByteBuffer.allocate(1024);
        private HashMap<SelectableChannel, ClientFile> clientMap = new HashMap();

        public void startServer() throws IOException {

            // 1. 獲取選擇器
            Selector selector = Selector.open();

            // 2. 打開通道
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            ServerSocket socket = serverChannel.socket();
            // 3. 設置非阻塞
            serverChannel.configureBlocking(false);
            // 4. 綁定端口
            InetSocketAddress address = new InetSocketAddress(6000);
            socket.bind(address);
            System.out.println("Server started at port 6000");
            // 5. 將通道註冊的"接受新連接"IO事件註冊到選擇器上
            serverChannel.register(selector, OP_ACCEPT);

            // 6. 輪巡感興趣的IO事件
            while (selector.select() > 0) {
                // 7. 獲取選擇器中所有的選擇鍵
                var keys = selector.selectedKeys();
                for (SelectionKey key : keys) {
                    // 8. 根據具體的IO事件類型處理
                    if (key.isAcceptable()) {
                        // 9. 若選擇器的 IO 事件是"連接就緒"，則接受新的連接
                        SocketChannel channel = serverChannel.accept();
                        // 10. 將新連接設置非阻塞
                        channel.configureBlocking(false);
                        // 11. 將新連接註冊的"讀取"IO事件註冊到選擇器上
                        channel.register(selector, OP_READ);
                        // 12. 創建客戶端文件對象
                        ClientFile clientFile = new ClientFile();
                        clientFile.inetAddress = (InetSocketAddress) channel.getRemoteAddress();
                        clientMap.put(channel, clientFile);
                        System.out.println("Client " + clientFile.inetAddress + " connected");
                    } else if (key.isReadable()) {
                        processData(key);
                    }
                    // 19. 移除選擇鍵
                    keys.remove(key);
                }
            }

        }

        private void processData(SelectionKey key) throws IOException {
            ClientFile clientFile = clientMap.get(key.channel());
            clientFile.startTime = System.currentTimeMillis();
            SocketChannel channel = (SocketChannel) key.channel();
            int num;
            buffer.clear();
            while ((num = channel.read(buffer)) > 0) {
                buffer.flip();
                if (clientFile.filename == null) {
                    if (buffer.capacity() < 4) {
                        continue;
                    }
                    int fileNameLen = buffer.getInt();
                    byte[] filenameBytes = new byte[fileNameLen];
                    buffer.get(filenameBytes);
                    String filename = new String(filenameBytes, charset);
                    File directory = new File(RECEIVE_PATH);
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                    System.out.println("target directory: " + directory.getAbsolutePath());
                    clientFile.filename = filename;
                    String fullName = directory.getAbsolutePath() + File.separator + filename;
                    System.out.println("target file: " + fullName);
                    File file = new File(fullName.trim());
                    if (file.exists()) {
                        file.delete();
                    } else {
                        file.createNewFile();
                    }
                    FileChannel fileChannel = new FileOutputStream(file).getChannel();
                    clientFile.fileChannel = fileChannel;
                    if (buffer.capacity() < 8) {
                        continue;
                    }
                    long fileLength = buffer.getLong();
                    clientFile.fileLength = fileLength;
                    clientFile.startTime = System.currentTimeMillis();
                    System.out.println("start receiving file: " + filename + ", file length: " + fileLength);
                    clientFile.receivedLength += buffer.capacity();
                    if (buffer.capacity() > 0) {
                        clientFile.fileChannel.write(buffer);
                    }
                } else {
                    clientFile.receivedLength += buffer.capacity();
                    clientFile.fileChannel.write(buffer);
                }
                if (clientFile.isFinished()) {
                    finished(key, clientFile);
                }
                buffer.clear();
                key.cancel();
            }
        }

        private void finished(SelectionKey key, ClientFile clientFile) {
            System.out.println("finished receiving file: " + clientFile.filename + ", file length: " + clientFile.fileLength);
            try {
                clientFile.fileChannel.close();
                key.cancel();
                long endTime = System.currentTimeMillis();
                System.out.println("time spent: " + (endTime - clientFile.startTime) + "ms");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    static class ClientFile {

        /**
         * 文件名
         */
        String filename;
        /**
         * 文件長度
         */
        long fileLength;
        /**
         * 開始時間
         */
        long startTime;
        /**
         * 客戶端地址
         */
        InetSocketAddress inetAddress;
        /**
         * 文件通道
         */
        FileChannel fileChannel;
        /**
         * 已接收文件長度
         */
        long receivedLength;

        public boolean isFinished() {
            return fileLength <= receivedLength;
        }
    }
}
