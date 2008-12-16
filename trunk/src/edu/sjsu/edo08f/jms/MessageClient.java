package edu.sjsu.edo08f.jms;

import javax.jms.Topic;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

/**
 * Created by: Alex Yarmula
 * Date: Dec 6, 2008
 */
public class MessageClient extends AbstractJMSPort {

    private Topic replyTopic;

    public static void main(String args[]) {
        new MessageClient();
    }

     public void sendAsynchronousMessage (String messageText) throws JMSException {
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

        makeCallSafely();
    }


    private void prepareResources () {
        activateJndi();
        createConnection();
        createSession();
        lookUpTheTopicByName ("UniversitySystemTopic");
        startConnection();
    }

    private void makeCallSafely () {
        try {
            makeCall ();
        }   catch(JMSException JMSException) {
            System.out.println("JMS Exception: "+JMSException);
        }
    }

    private void makeCall () throws JMSException {
        String reply;
        sendAsynchronousMessage(
                "<request>" +
                "        <studentService>" +
                "            <getAll/>" +
                "        </studentService>" +
                "    </request>"
        );
        reply = getReply();
        System.out.println(reply);



    }

}
