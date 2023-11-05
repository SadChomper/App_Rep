package TP4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server4_2 {
    private static final int PORT = 1234;
    private static byte[] buffer = new byte[1234];
    private String getCurrentTime()
    {
        
    }
    public static void main(String[] args){
        try {
            DatagramSocket ds = new DatagramSocket(PORT);
            System.out.println("Démarrage du serveur");
            while(true){
            DatagramPacket userNamePacket = new DatagramPacket(buffer, buffer.length)
            ds.receive(userNamePacket);
            String userName = new String(userNamePacket.getData(),0,userNamePacket.getLength());
            System.out.println(userNamePacket?getAddress()+" : "+userName);
            userName = "Bienvenu " + userName;
            DatagramPacket msgToSend = new DatagramPacket(userName.getBytes(), userNamePacket.getPort());
            socket.send(msgToSend);
            }
        }
        catch(SocketException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}