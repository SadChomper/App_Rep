package rmiClient

import rmiService.IConversion;
import java.rmi.Naming;
import java.rmi.Remote;

public class ConversionClient{
    public static void main(String[] args) {
        try {
            // Recherche de l'objet distant par son URL RMI
            IConversion stub = (IConversion)Naming.lookup("rmi://localhost:1099/OD");
            // Appel de méthodes distantes et impression des résultats
            System.out.println("Conversion result for 7000.0: " + stub.convertirMontant(420.0));
            System.out.println("Conversion result for 60.0: " + stub.convertirMontant(64.0));
        }
        catch (Exception e)
        {e.PrintStackTrace();}
    }
}