package rmiServer;

import rmiService.ConversionImpl;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ConversionServer {
    public static void main(String[] args) {
        try {
            // Creating a RMI registry on port 1234
            LocateRegistry.createRegistry(1234);

            // Creating an instance of the ConversionImpl class (the remote object)
            ConversionImpl od = new ConversionImpl();

            // Printing information about the created remote object
            System.out.println("Remote object details: " + od.toString());

            // Binding the remote object to the RMI registry with the specified name and URL
            Naming.rebind("rmi://localhost:1234/ConversionObject", od);

        } catch (Exception e) {
            // Handling exceptions by printing the stack trace
            e.printStackTrace();
        }
    }
}