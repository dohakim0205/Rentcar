package controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.ClientRequestDto;
import client.controller.ClientDao;

public class RegistAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		Timestamp registDate = new Timestamp(System.currentTimeMillis());
		ClientRequestDto clientDto = new ClientRequestDto(id, pw, name, registDate);
		ClientDao clientDao = ClientDao.getInstance();
		clientDao.createClient(clientDto);

		response.sendRedirect("/");
	}
}
