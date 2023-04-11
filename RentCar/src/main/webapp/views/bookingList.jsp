<%@page import="booking.controller.BookingDao"%>
<%@page import="booking.Booking"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<jsp:include page="header"></jsp:include>
<body>
	<section>
		<%
		int bookingNum = Integer.parseInt(request.getParameter("bookingNum"));
		String vehicleName = request.getParameter("vehicleName");
		String time = request.getParameter("time");
		BookingDao bookingDao = BookingDao.getInstance();
		Booking booking = bookingDao.getBookingByNum(bookingNum);
		%>
		<table>
		<td>예약번호</td>
		<td><%=bookingNum%></td>
		</tr>
		<tr>
			<td>차량아이디</td>
			<td><%=booking.getVehicleId()%></td>
		</tr>
		<tr>
			<td>차량 이름</td>
			<td><%=vehicleName%></td>
		</tr>
		<tr>
			<td>예약 고객</td>
			<td><%=booking.getClientId()%></td>
		</tr>
		<tr>
			<td>장기(L)/단기(S) 렌트</td>
			<td><%=booking.getType()%></td>
		</tr>
		<tr>
			<td>예약 날짜 및 시간</td>
			<td><%=time%></td>
		</tr>
		<tr>

			<%
			if (booking.getType().equals("L")) {
			%>
			<td>이용 일수</td>
			<td><%=booking.getRentDay()%>일</td>
			<%
			}

			else {
			%>
			<td>이용 시간</td>
			<td><%=booking.getRentHour()%>시간</td>
			<%
			}
			%>
		</tr>
		</table>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>