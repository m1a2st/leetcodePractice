package practice.networking.fileserver;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author catalin
 */
public class Server {
    public static void main(String[] args) {
        try {
            //initialize the Server Socket class
            ServerSocket serverSocket = new ServerSocket(9090);

            //boolean variable to stop the server
            boolean isStopped = false;
            while (!isStopped) {
                //create client socket object
                Socket clientSocket = serverSocket.accept();
                //create and start client thread
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            }
        } catch (IOException e) {
            System.out.println("Port 9090 is already opened! Please use another port.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
