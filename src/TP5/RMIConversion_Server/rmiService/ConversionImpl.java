package rmiService;

public class ConversionImpl extends UnicastRremoteObject implements IConversion{
    //public si la classe ConversioNServer existe ailleur du package
    protected  ConversionImpl() throws RemoteException;
    {super();}
    @override
    public double convertirMontant (double mt) throws RemoteException
    {return mt*3.3;}
}