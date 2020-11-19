package org.jboss.labs.jms.ejb;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * Session Bean implementation class MessageSender
 */
@Stateless(mappedName = "MessageSender")
@LocalBean
public class MessageSender {

    /**
     * Default constructor. 
     */
    public MessageSender() {
        // TODO Auto-generated constructor stub
    }
    
    @Inject
	private JMSContext jmsContext;
	
	@Resource(mappedName = "java:/jms/queue/B")
	private Queue queue;
	
	public void sendMessage(String message) {
        jmsContext.createProducer().send(queue,message);
    }
}
