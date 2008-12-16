package edu.sjsu.edo08f.gui;

import edu.sjsu.edo08f.jms.MessageClient;

import javax.jms.Topic;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
/**
 * Created by IntelliJ IDEA.
 * User: TanTan
 * Date: Dec 15, 2008
 * Time: 11:16:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonClient extends MessageClient {
    public String getAllPersons() throws JMSException {
        sendAsynchronousMessage(
                "<request>" +
                        "        <personService>" +
                        "            <getAll/>" +
                        "        </personService>" +
                        "    </request>"
        );
        String reply = getReply();
        return reply;
    }


}
