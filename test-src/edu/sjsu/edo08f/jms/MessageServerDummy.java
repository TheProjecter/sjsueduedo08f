package edu.sjsu.edo08f.jms;

import javax.jms.JMSException;

/**
 * Author: Alex Yarmula
 * Date: Dec 11, 2008
 */
public class MessageServerDummy extends MessageServer {

    public void closeConnection () {
        try {
            connection.close();
        } catch (JMSException jmsException) {
            jmsException.printStackTrace();
        }
    }

}
