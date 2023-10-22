package TP3;

import ConnectionOperateur.IOException;
import ConnectionOperateur.RuntimeException;

public class Server3 extends Threads{

	public static void main(String[] args) 
	{
		private int nombreClient;
		(new Serveur()).start();
	}
	
	@Override
	public void run()
	{
		try 
		{
			ServerSocket ss = new ServerSocker(1234);
			System.out.println("Démarrage du serveur");
			while(true)
			{
				Socket s = ss.accept();
				new ClientProcess(s,++nombreClient).start();
			}
		}
		catch (IOException e) 
		{
	        System.out.println("erreur");
	        throw new RuntimeException(e);
		}
	}
	public class ClientProcess extends Thread
	{
		private int numClient;
		private Socket s;
		public ClientProcess(Socket s, int numClient);
		{
			this.s = s;
			this.numClient = numClient;
		}
		@Override
		public void run()
		{
			System.out.println("le client numero: "+numClient+"de l'adresse IP: "+s.getRemoteSocketAddress());
			(new PrintWriter(s.getOutputStream(), true)).println("Bienvenu, vous etes le client numero"+numClient)
		}
	}
}
//fel cmd, nekteb: telnet localhost 1234