package TP3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.lang.RuntimeException;

public class Server3 extends Thread {
	private int nombreClient; //Créez un entier qui contient le numero du client
	public static void main(String[] args) {
		Server3 server = new Server3(); // Créez une instance de la classe Server3
		server.start(); // Démarrez le serveur
	}

	@Override
/**
 * Cette méthode est exécutée lorsque le serveur est lancé en tant que thread.
 * Elle crée un serveur socket pour écouter les connexions entrantes et gérer les clients.
 */
	public void run() {
		try {
			// Crée un serveur socket qui écoute sur le port 1234.
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("Démarrage du serveur");

			// Cette boucle s'exécute en continu, attendant de nouvelles connexions clients.
			while (true) {
				Socket s = ss.accept(); // Attend qu'un client se connecte et accepte la connexion.
				new ClientProcess(s, ++nombreClient).start(); // Crée un nouveau thread ClientProcess pour gérer le client.
			}
		}
		catch (IOException e) {
			System.out.println("Une erreur est survenue");
			throw new RuntimeException(e);
		}

	public class ClientProcess extends Thread {
		private int numClient;
		private Socket s;

		public ClientProcess(Socket s, int numClient) {
			this.s = s;
			this.numClient = numClient;
		}

		@Override
		public void run() {
			System.out.println("le client numero: " + numClient + " de l'adresse IP: " + s.getRemoteSocketAddress());
			(new PrintWriter(s.getOutputStream(), true)).println("Bienvenue, vous êtes le client numéro " + numClient);
		}
	}
}