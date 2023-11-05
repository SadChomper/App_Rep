package TP4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.InetAddress;
import java.util.Scanner;
public class Client4 {
    // Définition du port de communication
    private static final int PORT = 1234;
    // Un tableau de bytes qui sera utilisé pour stocker les données reçues
    private static byte[] buffer = new byte[1234];
    public static void main(String[] args) throws Exception {
        // Création d'une instance de DatagramSocket pour la communication réseau
        DatagramSocket socket = new DatagramSocket();
        // Création d'un objet Scanner pour lire l'entrée utilisateur
        Scanner scan = new Scanner(System.in);
        // Demande à l'utilisateur de saisir son nom d'utilisateur
        System.out.print("Veuillez entrer votre nom d'utilisateur : ");
        String userName = scan.nextLine();
        // Obtention de l'adresse "localhost" (l'adresse de la machine locale)
        InetAddress adress = InetAddress.getByName("localhost");
        // Création d'un paquet de données à envoyer au serveur
        DatagramPacket dataToSend = new DatagramPacket(userName.getBytes(), userName.length(), adress, PORT);
        // Envoi du paquet de données au serveur
        socket.send(dataToSend);
        // Préparation d'un paquet pour recevoir les données du serveur
        DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
        // Réception des données du serveur dans le paquet
        socket.receive(receivedPacket);
        // Affichage des données reçues du serveur sous forme de chaîne de caractères
        System.out.println("Serveur: " + new String(receivedPacket.getData(), 0, receivedPacket.getLength()));
    }
}