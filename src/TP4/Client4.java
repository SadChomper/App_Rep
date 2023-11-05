package TP4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.InetAddress;
import java.util.Scanner;

public class Client4 {
    private static final int PORT = 1234;
    private static byte[] buffer = new byte[1234]

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();
        InetAddress adress = InetAddress.getByName("localhost");
        DatagramPacket dataToSend = new DatagramPacket(userName.getBytes(), userName.length(), adress, PORT);
        socket.send(dataToSend);
        DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(receivedPacket);
        System.out.println("Serveur: " + new String(receivedPacket.getData(), 0, receivedPacket.getLength()));
    }
}