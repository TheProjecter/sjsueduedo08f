package edu.sjsu.edo08f.jms;

import edu.sjsu.edo08f.xml.XmlReceiver;
import edu.sjsu.edo08f.BeanRetriever;

import javax.jms.*;
import javax.naming.*;

public class MessageServer extends AbstractJMSPort implements MessageListener {

    private String topicName = "UniversitySystemTopic";
    private XmlReceiver xmlReceiver;

    public void setXmlReceiver(XmlReceiver xmlReceiver) {
        this.xmlReceiver = xmlReceiver;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public static void main(String args[]) {
        BeanRetriever.getBeanFactory().getBean("messageServer");
    }

    public void onMessage(Message message) {

        processMessage(message);

    }


    private void processMessage (Message message) {
        String textMessage = getMessageText(message);

        String reply = xmlReceiver.processRequest(textMessage);

        sendReply(message, reply);

    }

    private String getMessageText (Message message) {
        try {
            return ((TextMessage) message).getText();
        } catch (JMSException jmsException) {
            jmsException.printStackTrace();
            return null;
        }
    }

    private void sendReply(Message request, String message) {
        try {

            MessageProducer messageProducer = session.createProducer(null);
            Destination replyDestination = request.getJMSReplyTo();
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText(message);
            messageProducer.send(replyDestination, textMessage);
            messageProducer.close();
        }
        catch(JMSException JMSE) {
            System.out.println("JMS Exception: "+JMSE);
        }
    }


    public MessageServer() {

        prepareResources();
        createTopicIfDoesntExist (topicName);
        createAndPrepareConsumer();
        startConnection ();

    }

    private void prepareResources () {

        activateJndi ();
        createConnection ();
        createSession();
        lookUpTheTopicByName (topicName);

    }

    private void createTopicIfDoesntExist (String topicName) {
        if ( null == counterTopic ) {

            createTopic (topicName);

            bindTopicWithJndi (topicName);
        }
    }

    private void createTopic (String topicName) {
        try {
            counterTopic = session.createTopic(topicName);
        } catch (JMSException jmsException) {
            jmsException.printStackTrace();
        }
    }

    private void bindTopicWithJndi (String topicName) {
        try {
            jndi.rebind(topicName, counterTopic);
        } catch (NamingException namingException ) {
            namingException.printStackTrace();
        }
    }

    private void createAndPrepareConsumer() {
        try {
            consumer = session.createConsumer( counterTopic );
            consumer.setMessageListener(this);
        } catch (JMSException jmsException) {
            jmsException.printStackTrace();
        }
    }



}