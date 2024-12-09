package main.java.parctice.networking.fileserver;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author CBaba
 */


import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            ServerSocket serverSocket = new ServerSocket(80); // create a server socket object
            boolean isStop = false;

            while (!isStop) // while server is not stopped
            {
                Socket clientSocket = serverSocket.accept(); //accept a client
                System.out.println("Client " + clientSocket.getInetAddress().getHostAddress() + " is connected"); // print client ip address
                ClientThread clientThread = new ClientThread(clientSocket); // create a new thread for each client
                clientThread.start(); //start the thread
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
