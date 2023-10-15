package ConnectionOperateur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCnx {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1234)) 
        {
            // Attendre un client a connecter
            Socket clientSocket = ss.accept();

            // Définir l'adresse IP et le port du serveur
            InputStream input = clientSocket.getInputStream();
            ObjectInputStream oi = new ObjectInputStream(input);

            // Lire l'objet reçu (Opération)
            Operation op = (Operation) oi.readObject();

            // Extraire les données nécessaires de l'objet de l'opération
            int op1 = op.getOp1();
            int op2 = op.getOp2();
            char ops = op.getOp();

            int result = 0;

            // Effectuer l'opération demandée
            switch (ops) {
                case '+': result = op1 + op2; break;
                case '-': result = op1 - op2; break;
                case '*': result = op1 * op2; break;
                case '/': result = op1 / op2; break;
            }

            // Stocker le résultat dans l'objet Operation
            op.setRes(result);

            // Configuration du flux de sortie pour l'envoi de l'objet Operation modifié
            OutputStream output = clientSocket.getOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(output);

            // Renvoyer l'objet Operation modifié au client
            oo.writeObject(op);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}