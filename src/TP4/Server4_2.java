package TP4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server4_2 {
    private static final int PORT = 1234;
    private static byte[] buffer = new byte[1234];

    // Méthode pour obtenir l'heure actuelle sous forme de chaîne de caractères
    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYY MM DD HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    public static void main(String[] args) {
        try {
            // Crée un socket Datagram en écoutant sur le port spécifié (PORT)
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Démarrage du serveur");
            // Boucle infinie pour écouter en continu les requêtes des clients
            while (true) {
                // Prépare un paquet pour recevoir les données du client
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                // Attend la réception du paquet contenant les données du client
                socket.receive(packet);
                // Obtient l'heure actuelle sous forme de chaîne de caractères
                String time = getCurrentTime();
                // Crée un paquet pour envoyer l'heure au client
                DatagramPacket msgToSend = new DatagramPacket(time.getBytes(), time.length(), packet.getAddress(), packet.getPort());
                // Envoie le paquet contenant l'heure au client
                socket.send(msgToSend);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}