package org.jboss.labs.jms.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.labs.jms.ejb.*;

/**
 * Servlet implementation class MessageSenderServlet
 */
@WebServlet("/messagesendersvlt")
public class MessageSenderServlet extends HttpServlet {
	
	private static final long serialVersionUID = -6581740275740382616L;

	@Inject
	MessageSender messageSender;
	//MessageSenderBeanLocal messageSenderBeanLocal;
	
	public MessageSenderServlet() {
    }
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		messageSender.sendMessage("Test Message");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
