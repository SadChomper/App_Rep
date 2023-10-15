package TP1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main (String[] args)
    {
    	try(ServerSocket ss = new ServerSocket(1234))
    		{
    		System.out.println("Je suis un server en attente la connexion d'un client");
    		Socket s = ss.accept();
    		System.out.println("un client est connecté");

    		InputStream is = s.getInputStream();
    		OutputStream os = s.getOutputStream();

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
