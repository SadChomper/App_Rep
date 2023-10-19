package ConnectionOperateur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCnx {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1234)) 
        {
            // Attendre un client pour se connecter
            Socket clientSocket = ss.accept();

            // Définir l'adresse IP et le port du serveur
            InputStream input = clientSocket.getInputStream();
            ObjectInputStream oi = new ObjectInputStream(input);

            // Lire l'objet reçu 
            Operation op = (Operation) oi.readObject();

            // Extraire les données nécessaires de l'objet de l'opération
            int nb1 = op.getNb1();
            int nb2 = op.getNb2();
            char ops = op.getOp();

            int result = 0;

            // Effectuer l'opération demandée
            switch (ops) {
                case '+': result = nb1 + nb2; break;
                case '-': result = nb1 - nb2; break;
                case '*': result = nb1 * nb2; break;
                case '/': result = nb1 / nb2; break;
            }

            // Stocker le résultat dans l'objet Operation
            op.setRes(result);

            // Configuration du flux de sortie pour l'envoi de l'objet Operation modifié
            OutputStream output = clientSocket.getOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(output);

            // Renvoyer l'objet Operation modifié au client
            oo.writeObject(op);

        } catch (IOException e) {
            System.out.println("erreur");
            throw new RuntimeException(e);
        }
        
        /*METHODE PLUS COURT
        init ServerSocket, Socket,
        Operation op = (Operation)(new ObjectInputStream(socket.getInputStream()));
        switch (op.getOpeartion())
        {case '+: op.setResult(op.getOp1()+op.geOp2()); break;
        ....
        }
        (new ObjectOutputStream(socket.getOutputStream())).writeObject(op);
        */
    }
}