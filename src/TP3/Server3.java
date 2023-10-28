package TP3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.RuntimeException;

public class Server3 extends Thread {
	private int nombreClient; //Créez un entier qui contient le numero du client
	private static final PORT=1234;
	private static int nombreClient;

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
			ServerSocket ss = new ServerSocket(PORT);
			System.out.println("Démarrage du serveur");

			// Cette boucle s'exécute en continu, attendant de nouvelles connexions clients.
			while (true) {
				// Attend qu'un client se connecte et accepte la connexion.
				Socket s = ss.accept();
				// Crée un nouveau thread ClientProcess pour gérer le client.
				new ClientProcess(s, ++nombreClient).start();
			}
		} catch (IOException e) {
			System.out.println("Une erreur est survenue");
			throw new RuntimeException(e);
		}

		public class ClientProcess extends Thread {
			private int numClient;
			private Socket s;

			public ClientProcess(Socket s, int nombreClient) {
				this.s = s;
				this.nombreClient = nombreClient;
			}

			@Override
			public void run() {
				try {
					System.out.println("le client numero: " + numClient +
							" de l'adresse IP: " + s.getRemoteSocketAddress());
					(new PrintWriter(s.getOutputStream(), true)).
							println("Bienvenue, vous êtes le client numéro " + numClient);

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
						case '+':
							result = nb1 + nb2;
							break;
						case '-':
							result = nb1 - nb2;
							break;
						case '*':
							result = nb1 * nb2;
							break;
						case '/':
							result = nb1 / nb2;
							break;
					}

					// Stocker le résultat dans l'objet Operation
					op.setRes(result);

					// Configuration du flux de sortie pour l'envoi de l'objet Operation modifié
					OutputStream output = clientSocket.getOutputStream();
					ObjectOutputStream oo = new ObjectOutputStream(op);

					// Renvoyer l'objet Operation modifié au client
					oo.writeObject(op);
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}