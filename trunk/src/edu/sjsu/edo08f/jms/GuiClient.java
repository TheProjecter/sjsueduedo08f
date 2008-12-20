package edu.sjsu.edo08f.jms;

import javax.jms.Topic;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

/**
 * Created by: Oleksiy Yarmula
 * Date: Dec 6, 2008
 */
public class GuiClient extends AbstractJMSPort {

    private static String topicName = "UniversitySystemTopic";
    private Topic replyTopic;

    protected void sendAsynchronousMessage (String messageText) throws JMSException {
        MessageProducer messageProducer = session.createProducer(counterTopic);

        TextMessage textMessage = session.createTextMessage(messageText);

        if (replyTopic == null ) {
            replyTopic = session.createTemporaryTopic();
            consumer = session.createConsumer( replyTopic );
        }

        textMessage.setJMSReplyTo(replyTopic);
        messageProducer.send(textMessage);

        System.out.println("=============================REQUEST=========================");
        System.out.println(messageText);

        messageProducer.close();
    }

    public String getReply () throws JMSException {
        TextMessage reply = (TextMessage)consumer.receive();
        System.out.println("=============================RESPONSE=======================");
        System.out.println(reply.getText());
        return reply.getText();
    }

    public GuiClient() {

        prepareResources ();

    }


    private void prepareResources () {
        activateJndi();
        createConnection();
        createSession();
        lookUpTheTopicByName (topicName);
        startConnection();
    }


}
