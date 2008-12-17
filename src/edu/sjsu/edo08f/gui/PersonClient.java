package edu.sjsu.edo08f.gui;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;

import edu.sjsu.edo08f.jms.MessageClient;
import edu.sjsu.edo08f.domain.Person;

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
    public String getAll() throws JMSException {
        sendAsynchronousMessage(
            "<request>" +
                "<personService>"  +
                    "<getAll/>"    +
                "</personService>" +
            "</request>"
        );
        String reply = getReply();
        return reply;
    }

    public String search(String searchedFieldName, String searchedValue) throws JMSException {

        sendAsynchronousMessage(
            "<request>" +
                "<personService>" +
                    "<search>" +
                        "<searched-field-name>" + searchedFieldName + "</searched-field-name>" +
                        "<searched-value>"      + searchedValue     +  "</searched-value>"     +
                    "</search>" +
                "</personService>" +
            "</request>"
        );
        String reply = getReply();
        return reply;
    }

        public String getById(String id) throws JMSException {

        sendAsynchronousMessage(
            "<request>" +
                "<personService>"  +
                    "<getbyid>"    +
                        "<id>"     + id  +  "</id>" +
                    "</getbyid>"   +
                "</personService>" +
            "</request>"
        );
        String reply = getReply();
        return reply;
    }
}
