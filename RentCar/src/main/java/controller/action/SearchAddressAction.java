package controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vehicle.Vehicle;
import vehicle.controller.VehicleDao;

public class SearchAddressAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String address = request.getParameter("address");
		
		VehicleDao vehicleDao = VehicleDao.getInstance();
		ArrayList<Vehicle> list = vehicleDao.getVehicleAll();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/list").forward(request, response);
		
	}

}
