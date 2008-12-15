package edu.sjsu.edo08f.jms;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by: Oleksiy Yarmula
 * Date: Nov 5, 2008
 */
abstract class AbstractJMSPort {

    protected Connection connection;
    protected Session session;
    protected Topic counterTopic;
    protected MessageConsumer consumer;
    protected InitialContext jndi;

    
    protected void activateJndi () {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
        properties.put(Context.PROVIDER_URL, "localhost");
        try {
            jndi  = new InitialContext(properties);
        } catch (NamingException namingException) {
            namingException.printStackTrace();
        }
    }

    protected void createConnection () {
        try {
            ConnectionFactory conFactory = (ConnectionFactory) jndi.lookup("XAConnectionFactory");
            connection = conFactory.createConnection();
        } catch (NamingException namingException ) {
            namingException.printStackTrace();
        } catch (JMSException jmsException) {
            jmsException.printStackTrace();
        }
    }

    protected  void createSession () {
        try {
            session = connection.createSession( false, Session.AUTO_ACKNOWLEDGE );
        } catch (JMSException jmsException) {
            jmsException.printStackTrace();
        }
    }

    protected void lookUpTheTopicByName (String topicName) {
        try {
            counterTopic = (Topic)jndi.lookup(topicName);
        }
        catch(NamingException namingException) {
        }
    }

    protected void startConnection () {
        try {
            connection.start();
        } catch (JMSException jmsException) {
            jmsException.printStackTrace();
        }
    }

}
