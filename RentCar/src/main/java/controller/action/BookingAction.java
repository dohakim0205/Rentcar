package controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookingAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookingNum = Integer.parseInt(request.getParameter("bookingNum"));
		String type = request.getParameter("type");
		String vehicleId = request.getParameter("vehicleId");
		String clientId = request.getParameter("clientId");
		Timestamp approvalTime = new Timestamp(System.currentTimeMillis());
		String bookingD = request.getParameter("bookingDate");
		System.out.println(bookingD);
		String bookingT = request.getParameter("bookingTime");
		System.out.println(bookingT);
//		Timestamp bookingTime = new Timestamp

		int rentDay = Integer.parseInt(request.getParameter("rentDay"));
		int rentHour = Integer.parseInt(request.getParameter("rentHour"));
		int payment = Integer.parseInt(request.getParameter("payment"));
	}

}
