package org.jboss.labs.jms.ejb;

public interface MessageSenderBeanRemote {
	public void sendMessage(String message, String destinationType, String destination);
	public void sendMessage(String message);
}
