package ConnectionOperateur;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class ClientCnx {
    public static void main(String[] args){
        try
        {
            InetAddress IA = InetAddress.getByName("donner ip ici");
		    InetSocketAddress ISA = new InetSocketAddress(IA,1234);
		    Socket client2 = new Socket();
            client2.connect(ISA);
            
            InputStream input = client2.getInputStream();
            OutputStream output = client2.getOutputStream();
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(isr);

            Scanner scanner = new Scanner(System.in);

            System.out.println("donner le premier nombre = ");
            int op1 = scanner.nextInt();
            System.out.println("donner le deuxieme nombre = ");
            int op2 = scanner.nextInt();
            
            String op;
            do{
                System.out.println("donner l'operateur= ");
                op = scanner.nextLine();
            }
            while(!(op.equals("+")) && !(op.equals("-")) && !(op.equals("*")) && !(op.equals("/")));

            PrintWriter pw = new PrintWriter(output,true);
            pw.println(op1);
            pw.println(op2);
            pw.println(op);
            
            //La reception du resultat et l'affichage
            System.out.println("la resultat de "+op1+" "+op+" "+op2+" = "+br.readLine());

        }
        catch(IOException e)
        {
            System.out.println("Erreur");
            throw new RuntimeException(e);
        }
    }
}