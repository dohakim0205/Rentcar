<%@page import="vehicle.Vehicle"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@page import="booking.Booking"%>
<%@page import="java.util.ArrayList"%>
<%@page import="booking.controller.BookingDao"%>
<%@page import="client.Client"%>
<%@page import="client.controller.ClientDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<jsp:include page="header"></jsp:include>
<body>
	<%
	Client client = (Client) session.getAttribute("log");
	if (client == null) {
		response.sendRedirect("login");
	}

	else {
		BookingDao bookingDao = BookingDao.getInstance();
		ArrayList<Booking> list = bookingDao.getBookingByClientId(client.getId());
	%>
	<section>
		<h2>회원 정보</h2>
		<table>
			<tr>
				<td class="kind">아이디</td>
				<td><%=client.getId()%></td>
			</tr>
			<tr>
				<td class="kind">이름</td>
				<td><%=client.getName()%></td>
			</tr>
			<tr>
				<td class="kind">가입일자</td>
				<td><%=client.getRegistDate()%></td>
			</tr>
			<tr>
				<td colspan="2"><a href="boardList" class="my-board">내가 쓴 게시글</a></td>
			</tr>
		</table>
		<table>
			<tr>
				<td colspan="6">예약 정보</td>
			</tr>
			<%
			for (int i = 0; i < list.size(); i++) {
				Booking booking = list.get(i);
				VehicleDao vehicleDao = VehicleDao.getInstance();
				Vehicle vehicle = vehicleDao.getVehicleById(booking.getVehicleId());
				String time = booking.getBookingTime().toString().substring(0, 16);
			%>
			<tr>
				<td>예약번호</td>
				<td><a
					href="bookingList?bookingNum=<%=booking.getBookingNum()%>&vehicleName=<%=vehicle.getVehicleName()%>&time=<%=time%>"><%=booking.getBookingNum()%></a></td>
				<td>차량이름</td>
				<td><a
					href="bookingList?bookingNum=<%=booking.getBookingNum()%>&vehicleName=<%=vehicle.getVehicleName()%>&time=<%=time%>"><%=vehicle.getVehicleName()%></a></td>
				<td>예약 날짜 및 시간</td>
				<td><a
					href="bookingList?bookingNum=<%=booking.getBookingNum()%>&vehicleName=<%=vehicle.getVehicleName()%>&time=<%=time%>"><%=time%></a></td>
			</tr>
			<%
			}
			%>
		</table>
		<button onclick="location.href = 'update'">회원 정보 수정</button>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>
<%
}
%>