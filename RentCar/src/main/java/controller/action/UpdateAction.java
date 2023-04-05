package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import client.Client;
import client.ClientRequestDto;
import client.controller.ClientDao;

public class UpdateAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientDao clientDao = ClientDao.getInstance();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		ClientRequestDto clientDto = new ClientRequestDto(id, pw, name);
		clientDao.updateClient(clientDto);
		Client client = clientDao.getClientById(id);
		HttpSession session = request.getSession();
		session.setAttribute("log", client);
		response.sendRedirect("/");
	}

}
