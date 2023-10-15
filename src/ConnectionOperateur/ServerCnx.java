package ConnectionOperateur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCnx {
    public static void  main(String[] args){
        try(ServerSocket ss = new ServerSocket(1234))
        {
            Socket clientSocket = ss.accept();

            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(isr);

            int op1 = Integer.parseInt(br.readLine());
            int op2 = Integer.parseInt(br.readLine());
            String op = br.readLine();

            int resultat = 0;
            switch(op)
            {
                case "+" : resultat = op1 + op2;break;
                case "-" : resultat = op1 - op2;break;
                case "*" : resultat = op1 * op2;break;
                case "/" : resultat = op1 / op2;break;
            }
            
            PrintWriter pw = new PrintWriter(output,true);
            pw.println(resultat);
        }
        catch (IOException e) 
        {
            System.out.println("here");
            throw new RuntimeException(e);
        };
    }
}
