package TP4;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client4_3 {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 1234;

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverIP = InetAddress.getByName(serverAddress);

            // 2. Le client connecté permet aux utilisateurs d'entrer leur nom d'utilisateur
            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrez votre nom d'utilisateur : ");
            String username = scanner.nextLine();
            /* Il permet d'envoyer des messages de chat qui sont ensuite diffusés
            à tous les autres clients connectés en temps réel */
            while (true) {
                System.out.print("Message : ");
                String message = username + ": " + scanner.nextLine();
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, serverPort);
                clientSocket.send(sendPacket);
            }
        }
        catch (IOException e)
        {e.printStackTrace();}
    }
}