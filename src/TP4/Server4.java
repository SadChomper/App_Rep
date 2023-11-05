package TP4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server4 {
    private static final int PORT = 1234;
    private static byte[] buffer = new byte[1234];
    private String getCurrentTime()
    {
        
    }
    public static void main(String[] args) {
        try {
            // Crée un socket Datagram en écoutant sur le port spécifié (PORT)
            DatagramSocket ds = new DatagramSocket(PORT);
            System.out.println("Démarrage du serveur");

            // Boucle pour écouter en continu les requêtes des clients
            while (true) {
                // Prépare un paquet pour recevoir le nom d'utilisateur du client
                DatagramPacket userNamePacket = new DatagramPacket(buffer, buffer.length);

                // Attend la réception du paquet contenant le nom d'utilisateur
                ds.receive(userNamePacket);

                // Extrait le nom d'utilisateur des données reçues
                String userName = new String(userNamePacket.getData(), 0, userNamePacket.getLength());

                // Affiche l'adresse IP du client et le nom d'utilisateur reçu
                System.out.println(userNamePacket.getAddress() + " : " + userName);

                // Modifie le message pour accueillir l'utilisateur
                userName = "Bienvenue " + userName;

                // Crée un paquet pour envoyer le message modifié au client
                DatagramPacket msgToSend = new DatagramPacket(userName.getBytes(), userNamePacket.getPort());

                // Envoie le paquet au client
                ds.send(msgToSend);
            }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}