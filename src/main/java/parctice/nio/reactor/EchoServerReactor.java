package main.java.parctice.nio.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class EchoServerReactor implements Runnable {

    Selector selector;
    ServerSocketChannel serverSocketChannel;

    public EchoServerReactor() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(6000));
            SelectionKey sk = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            sk.attach(new AcceptorHandler()); // 將 AcceptorHandler 作為附件綁定到選擇鍵
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();
                if (keys == null || keys.isEmpty()) {
                    continue;
                }
                for (SelectionKey key : keys) {
                    // 反應器負責 dispatch 收到的事件
                    dispatch(key);
                }
                keys.clear();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 反應器的事件分發
    private void dispatch(SelectionKey key) {
        Runnable handler = (Runnable) key.attachment();
        // 調用之前註冊的handler處理器對事件進行處理
        if (handler != null) {
            handler.run();
        }
    }

    class AcceptorHandler implements Runnable {
        @Override
        public void run() {
            try {
                SocketChannel channel = serverSocketChannel.accept();
                if (channel != null) {
                    new EchoHandler(selector, channel);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
