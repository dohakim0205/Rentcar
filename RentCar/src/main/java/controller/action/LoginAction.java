package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.Client;
import client.controller.ClientDao;

public class LoginAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		ClientDao clientDao = ClientDao.getInstance();
		Client client = clientDao.getClientById(id);

		if (client != null && pw.equals(client.getPw())) {
			HttpSession session = request.getSession();
			session.setAttribute("log", client);
			response.sendRedirect("/");
		}
	}
}
