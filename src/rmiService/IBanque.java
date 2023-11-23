package rmiService;

import metier.Compte;
import java.rmi.Remote;
import java.rmi.RemoteException;

// L'interface IBanque définit les opérations bancaires exposées par le service RMI
public interface IBanque extends Remote {

    // Méthode pour créer un compte bancaire et retourner un message indicatif
    String creerCompte(Compte c) throws RemoteException;

    // Méthode pour obtenir les informations d'un compte en fonction de son code
    String getInfoCompte(int code) throws RemoteException;
}