package client.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;
import client.ClientRequestDto;

/**
 * Servlet implementation class UpdateAction
 */
public class UpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientDao clientDao = ClientDao.getInstance();
		String id = request.getParameter("id"); 
		Client client = clientDao.getClientById(id);
		
			String pw = request.getParameter("pw"); 
			String name = request.getParameter("name"); 
			Timestamp registDate = client.getRegistDate();
			
			ClientRequestDto clientDto = new ClientRequestDto(id, pw, name, registDate);
			clientDao.updateClient(clientDto);
			
			response.sendRedirect("update");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
