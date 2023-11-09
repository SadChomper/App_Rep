import rmiServer;

public class ConversionServer {
    public static void main(String[] args) {
        try {
            locate Registry.createRegistry(1099);
            ConversionImpl od = new ConversionImpl();
            System.out.println(od.toString());
            //publication de la reference de l'object distant
            Naming.rebind("rmi ://localhost:1099/OD", od)
        } catch (Exception e)
        {e.PrintStackTrace();}
    }
}