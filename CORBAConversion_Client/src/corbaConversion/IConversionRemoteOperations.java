package corbaConversion;


/**
* corbaConversion/IConversionRemoteOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Conversion.idl
* Thursday, 30 November 2023 09:01:08 o'clock WAT
*/


// Définition de l'interface IConversionRemote
public interface IConversionRemoteOperations 
{

  // Déclaration d'une opération de conversion prenant un montant en entrée et retournant un montant converti
  double conversionMontant (float montant);
} // interface IConversionRemoteOperations