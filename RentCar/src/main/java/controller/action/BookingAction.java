package controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import booking.Booking;
import booking.BookingRequestDto;
import booking.controller.BookingDao;

public class BookingAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookingNum = Integer.parseInt(request.getParameter("bookingNum"));
		String type = request.getParameter("type");
		String vehicleId = request.getParameter("vehicleId");
		String clientId = request.getParameter("clientId");
		Timestamp approvalTime = new Timestamp(System.currentTimeMillis());
		String bookingD = request.getParameter("bookingDate");
		String[] date = bookingD.split("-");
		String bookingT = request.getParameter("bookingTime");
		String[] time = bookingT.split(":");
		Timestamp bookingTime = new Timestamp(Integer.parseInt(date[0]) - 1900, Integer.parseInt(date[1]) - 1,
				Integer.parseInt(date[2]), Integer.parseInt(time[0]), Integer.parseInt(time[1]), 0, 0);

		int rentDay = request.getParameter("rentDay") != null ? Integer.parseInt(request.getParameter("rentDay")) : 0;
		int rentHour = request.getParameter("rentHour") != null ? Integer.parseInt(request.getParameter("rentHour")) : 0;
		int payment = Integer.parseInt(request.getParameter("payment"));

		BookingDao bookingDao = BookingDao.getInstance();
		BookingRequestDto bookingDto = new BookingRequestDto(bookingNum, type, vehicleId, clientId, approvalTime,
				bookingTime, rentDay, rentHour, payment);
		
		if (type.equals("L")) {
			bookingDao.createBookingForLongRent(bookingDto);
		}

		else {
			bookingDao.createBookingForShortRent(bookingDto);
		}
		
		Booking booking = bookingDao.getBookingByNum(bookingNum); 
		if (booking != null) {
			response.sendRedirect("mypage");
		}
	}

}
