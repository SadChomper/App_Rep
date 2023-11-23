package rmiService;

import metier.Compte;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

// La classe BanqueImpl implémente l'interface IBanque
// et fournit une implémentation RMI des opérations bancaires
public class BanqueImpl extends UnicastRemoteObject implements IBanque {

    // Liste pour stocker les comptes bancaires
    private List<Compte> comptes;

    // Constructeur de la classe
    public BanqueImpl() throws RemoteException {
        // Initialisation de la liste des comptes lors de la création de l'objet
        comptes = new ArrayList<>();
    }

    // Implémentation de la méthode de création de compte
    @Override
    public String creerCompte(Compte c) throws RemoteException {
        // Ajout du compte à la liste
        comptes.add(c);

        // Retourne un message indiquant que le compte a été ajouté avec succès
        return c + " a été ajouté avec succès.";
    }

    // Implémentation de la méthode pour obtenir les informations d'un compte
    @Override
    public String getInfoCompte(int code) throws RemoteException {
        // Parcourt la liste des comptes
        for (Compte compte : comptes) {
            // Vérifie si le code du compte correspond à celui recherché
            if (compte.getCode() == code) {
                // Retourne les informations du compte formatées
                return "Code: " + compte.getCode() +
                        "\nSolde: " + compte.getSolde() +
                        "\nDate de création: " + compte.getDateCreation();
            }
        }
        // Retourne un message indiquant que le compte n'existe pas
        return "Le compte n'existe pas.";
    }
}

