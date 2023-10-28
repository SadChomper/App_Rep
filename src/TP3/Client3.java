package TP3;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client3 {
    public static void main(String[] args) {
        try {
            // Définir l'adresse IP et le port du serveur
            InetAddress serverAddress = InetAddress.getByName("Donner l'ip a connecter");
            InetSocketAddress serverSocketAddress = new InetSocketAddress(serverAddress, 1234);

            // Créer une socket pour se connecter au serveur
            Socket clientSocket = new Socket();

            // Se connecter au serveur
            clientSocket.connect(serverSocketAddress);

            // Creation du flux de sortie pour l'envoi d'un objet Operation au serveur
            OutputStream output = clientSocket.getOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(output);

            // Créer un objet Opération (9 - 4)
            Operation op = new Operation(9, 4, '-');

            // Envoi de l'objet Operation au serveur
            os.writeObject(op);

            // Mise en place d'un flux d'entrée pour recevoir du serveur un objet Operation modifié
            InputStream input = clientSocket.getInputStream();
            ObjectInputStream is = new ObjectInputStream(input);

            // Réception et lecture de l'objet Operation modifié
            op = (Operation) is.readObject();

            // Afficher la resultat
            System.out.println("Resultat reçu du serveur: " + op.getRes());

        } catch (IOException e) {
            System.out.println("erreur");
            throw new RuntimeException(e);
        }
    }
}