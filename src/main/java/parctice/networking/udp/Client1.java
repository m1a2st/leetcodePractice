package parctice.networking.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author CBaba
 */
public class Client1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData;

        boolean stop = false;

        while (!stop) {
            String stringSendData = "Client 1 text message";
            sendData = stringSendData.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9090);
            clientSocket.send(sendPacket);
        }
        clientSocket.close();
    }
}
