package service;

import corbaConversion.IConversionRemotePOA;

// Classe implémentant l'interface IConversionRemotePOA
public class ConversionImpl extends IConversionRemotePOA {

    // Méthode de conversionMontant, héritée de l'interface IConversionRemote
    public double conversionMontant(double montant) {
        return montant * 3.3;
    }
}