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
		String searchAddress = request.getParameter("searchAddress");
		
		VehicleDao vehicleDao = VehicleDao.getInstance();
		ArrayList<Vehicle> list = vehicleDao.getVehicleAll();
		ArrayList<Vehicle> searchList = new ArrayList<Vehicle>();
		
		for(int i = 0; i < list.size(); i ++) {
			if(list.get(i).getVehicleLocation().contains(searchAddress)) {
				searchList.add(list.get(i));
			}
		}
		
		request.setAttribute("list", searchList);
		request.getRequestDispatcher("/address").forward(request, response);
	}

}
