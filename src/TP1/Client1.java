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
        	System.out.println("Je suis un client connecté");
            InetAddress IA = InetAddress.getByName("10.27.13.29");
		    InetSocketAddress ISA = new InetSocketAddress(IA,1234);

		    Socket client = new Socket();
            client.connect(ISA);
            System.out.println("Je suis un client connecté");

            InputStream is = client.getInputStream();
            OutputStream os = client.getOutputStream();
            
            Scanner scanner = new Scanner(System.in);
            int nb = scanner.nextInt();
        
            os.write(nb);
            int res = is.read();
            System.out.println(res);

            client.close();
        }
        catch (IOException e)
		{
			System.out.println("error");
		};
    }
}

