package org.jboss.labs.jms.ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
/**
 * Session Bean implementation class MessageSenderSLSB
 */

@Stateless(mappedName = "MessageSenderBean")
public class MessageSenderBean implements MessageSenderBeanRemote, MessageSenderBeanLocal {

	@Inject
    @JMSConnectionFactory("java:/JmsXA")
    private JMSContext jmsContext;

    @Resource(mappedName = "java:/jms/queue/A")
    private Queue queue;

    public MessageSenderBean() { }
    
    @Override
    public void sendMessage(String message, String destinationType, String destination) {
    }

    @Override
    public void sendMessage(String message) {
        jmsContext.createProducer().send(queue,message);
    }
    
}
