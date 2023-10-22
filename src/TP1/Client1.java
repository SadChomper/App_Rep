package TP1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args)
    {
        try
        {
        	//La connection à un serveur
		    Socket client = new Socket();

            //La creation du flux d'entrée et sortie
            InputStream input = client.getInputStream();
            OutputStream output = client.getOutputStream();
            System.out.println("Je suis un client connecté");

            client.close();
        }
        catch (IOException e)
		{
			System.out.println("un erreur est survenu");
		};
    }
}

