package edu.sjsu.edo08f.jms;

import javax.jms.Topic;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

/**
 * Created by: Oleksiy Yarmula
 * Date: Dec 6, 2008
 */
public class MessageClient extends AbstractJMSPort {

    private static String topicName = "UniversitySystemTopic";
    private Topic replyTopic;

    public static void main(String args[]) {
        new MessageClient();
    }

    protected void sendAsynchronousMessage (String messageText) throws JMSException {
        MessageProducer messageProducer = session.createProducer(counterTopic);

        TextMessage textMessage = session.createTextMessage(messageText);

        if (replyTopic == null ) {
            replyTopic = session.createTemporaryTopic();
            consumer = session.createConsumer( replyTopic );
        }

        textMessage.setJMSReplyTo(replyTopic);
        messageProducer.send(textMessage);

        messageProducer.close();
    }

    public String getReply () throws JMSException {
        TextMessage reply = (TextMessage)consumer.receive();
        return reply.getText();
    }

    public MessageClient() {

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
