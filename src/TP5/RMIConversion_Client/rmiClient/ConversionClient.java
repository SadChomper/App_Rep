package rmiClient

import service.IConversion

public class ConversionClient{
    public static void main(String[] args) {
        try {
            IConversion stub = (IConversion)Naming.lookup("rmi://localhost:1099/OD");
            System.out.println(stub.convert(150.00));
            System.out.println(stub.convert(1000.00));
        }
        catch (Exception e)
        {e.PrintStackTrace();}
    }
}