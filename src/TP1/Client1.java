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
        	//La connection à un serveur d'aprés son adresse IP
            InetAddress IA = InetAddress.getByName ("inserer IP ici");
		    InetSocketAddress ISA = new InetSocketAddress (IA,9000);
		    Socket client = new Socket();
            client.connect(ISA);
            System.out.println("Je suis un client connecté");

            //La creation du flux d'entrée et sortie
            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();
            
            //La creation du scanner et l'envoi du nb vers le serveur
            Scanner scanner = new Scanner (System.in);
            int nb = scanner.nextInt();
            os.write(nb);
            
            //Le reçu du resultat d'apres le serveur
            int res = is.read();
            System.out.println(res);

            client.close();
        }
        catch (IOException e)
		{
			System.out.println("erreur");
		};
    }
}

