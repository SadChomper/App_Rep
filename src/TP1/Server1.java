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
    		Socket s = ss.accept();
    		System.out.println("un client est connecté");

    		//La creation du flux d'entrée et sortie
    		InputStream is = s.getInputStream();
    		OutputStream os = s.getOutputStream();

    		//Le reçu du nombre d'aprés le client et le renvoie aprés une modification
    		int in = is.read();
    		in *= 5;
    		System.out.println(in);
    		os.write(in);

    		s.close();
    		ss.close();
    	}
    	catch (IOException e)
    		{
    			System.out.println("error");
    		};
    }
}