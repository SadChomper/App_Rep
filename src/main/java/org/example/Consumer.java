package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {
    public static void main(String[] args) {
        try {
            //etablissement d'une connexion au broker ActiveMQ et lancement
            ConnectionFactory conx = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = conx.createConnection();
            connection.start();
            //creation d'une session (representant le context)
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            //Definir la destination du message
            Destination destination = session.createTopic("MyTopic.topic");
            //Creation du MessageConsumer (Lier entre la session et la destination)
            MessageConsumer consumer = session.createConsumer(destination);
            //Creation d'un JMS Listener pour traiter les messages dès leur disponibilité
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        try {
                            System.out.println("Message reçu :" + textMessage);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
