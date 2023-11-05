package TP4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Client4_2 {
    private static final int PORT = 1234;
    private static byte[] buffer = new byte[1234];

    public static void main(String[] args) throws Exception {
        // Crée un socket Datagram pour la communication avec le serveur
        DatagramSocket socket = new DatagramSocket();
        // Message à envoyer au serveur (actuellement vide)
        String msg = "";
        // Crée un paquet de données à envoyer au serveur
        DatagramPacket dataToSend = new DatagramPacket(msg.getBytes(), 0, InetAddress.getByName("localhost"), PORT);
        // Envoie le paquet de données au serveur
        socket.send(dataToSend);
        // Prépare un paquet pour recevoir les données du serveur
        DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
        // Attend la réception du paquet de données du serveur
        socket.receive(receivedPacket);
        // Affiche le message reçu du serveur
        System.out.print("Server: " + new String(receivedPacket.getData(), 0, receivedPacket.getLength()));
    }
}