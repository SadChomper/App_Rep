package TP1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server1 {
    public static void main (String[] args)
    {
    	//La creation du SS et l'linitialisation du port
    	try(ServerSocket ss = new ServerSocket(9000))
    		{
    		System.out.println("Je suis un server en attente la connexion d'un client");

    		//L'acceptation du client
    		Socket clientSocket = ss.accept();
    		System.out.println("un client est connecté");

    		//La creation du flux d'entrée et sortie
    		InputStream input = clientSocket.getInputStream();
    		OutputStream output = clientSocket.getOutputStream();

    		clientSocket.close();
    		ss.close();
    	}
    	catch (IOException e) {
			System.out.println("un erreur est survenu);
		};
    }
}
