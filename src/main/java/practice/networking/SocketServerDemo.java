package practice.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {

    public static void main(String[] args) {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(9090);
                 Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                out.println("hello world");
                System.out.println("server start");
                System.out.println(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
