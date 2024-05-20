package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

import static java.nio.channels.SelectionKey.OP_ACCEPT;

public class UseSelector {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();

        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.bind(new InetSocketAddress(5000));
        socketChannel.register(selector, OP_ACCEPT);

        while (selector.select() > 0) {
            Set<SelectionKey> keys = selector.selectedKeys();
            for (SelectionKey key : keys) {
                if (key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                } else if (key.isReadable()) {
                    // a channel is ready for reading
                } else if (key.isWritable()) {
                    // a channel is ready for writing
                }
                keys.remove(key);
            }

        }
    }
}
