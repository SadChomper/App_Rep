package rmiServer;

import rmiService.BanqueImpl;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class BanqueServer {
    public static void main(String[] args) {
        try {
            // Crée un registre RMI sur le port 1090
            LocateRegistry.createRegistry(1090);

            // Crée une instance de l'implémentation du service bancaire
            BanqueImpl bi = new BanqueImpl();

            // Affiche les informations de l'objet BanqueImpl
            System.out.println(bi.toString());

            // Lie l'objet BanqueImpl au registre RMI avec le nom "BanqueService"
            Naming.rebind("rmi://localhost:1080/BanqueService", bi);

            // Affiche un message indiquant que le serveur est en cours d'exécution
            System.out.println("Server is running...");
        }
        // En cas d'erreur, lance une exception RuntimeException avec l'erreur d'origine
        catch (RemoteException | MalformedURLException e)
        {throw new RuntimeException(e);}
    }
}

