
import java.util.Properties;

import javax.jms.*;
import javax.naming.*;

public class MessageServer implements MessageListener{
private Topic topic;
private Connection connection;
private static Session session;
private MessageConsumer consumer;
private MessageProducer producer;

public static void main(String[] args){
	new MessageServer();
}
public void sendReply(Message Request, int sum){
try{
	MessageProducer producer = session.createProducer(null);
	Destination reply=Request.getJMSReplyTo();
	TextMessage TXT = session.createTextMessage();
	TXT.setText(""+sum);
	producer.send(reply,TXT);
}
catch (JMSException e){
	System.out.println("JMS Exception: "+e);
}
}
public void OnMessage(Message message){
	TextMessage TXT=(TextMessage)message;
}
public MessageServer()
	{
		try
		{
		    Properties properties = new Properties();
		    properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		    properties.put(Context.URL_PKG_PREFIXES, "org.jnp.interfaces");
		    properties.put(Context.PROVIDER_URL, "localhost");
		    
			InitialContext jndi = new InitialContext(properties);
			ConnectionFactory conFactory = (ConnectionFactory)jndi.lookup("XAConnectionFactory");
			connection = conFactory.createConnection();
			
			session = connection.createSession( false, Session.AUTO_ACKNOWLEDGE );
			
			try
			{
				topic = (Topic)jndi.lookup("Topic");
			}
			catch(NamingException NE1)
			{
				System.out.println("NamingException: "+NE1);
			}
			
			/*if( null == topic )
			{
				topic = session.createTopic("CounterTopic");
				jndi.bind("CounterTopic", topic);
			}*/
			
			consumer = session.createConsumer( topic );
			consumer.setMessageListener(this);
			
			connection.start();
		}
		catch(NamingException NE)
		{
			System.out.println("Naming Exception: "+NE);
		}
		catch(JMSException e)
		{
			System.out.println("JMS Exception: "+e);
			e.printStackTrace();
		}
	}
@Override
public void onMessage(Message arg0) {
	// TODO Auto-generated method stub
	
}}

