package org.example;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
public class Producer {
    public static void main(String[] args) {
        try {
            //Connexion ou broker ActiveMQ
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            //Creation d'une connection et lancement
            Connection connection = connectionFactory.createConnection();
            connection.start();
            //creation d'une session
            Session session = ((javax.jms.Connection) connection).createSession(true, Session.AUTO_ACKNOWLEDGE);
            //Definir la destination du msg
            Destination destination = session.createTopic("myTopic.topic");
            //Creation du MessageProducer
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            //Creation du smg
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("Hello world!");
            producer.send(textMessage);
            //commit de la transaction
            session.commit();
            System.out.println("Envoi du message...");
            //Fermeture
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}