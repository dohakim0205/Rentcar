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
	String vehicleId = (String) request.getParameter("vehicleId");
	BookingDao bookingDao = BookingDao.getInstance();

	int bookingNum = bookingDao.getBookingNumMax();
	Client client = (Client) session.getAttribute("log");

	if (client != null) {

		if (vehicleId == null) {
			vehicleId = request.getParameter("vehicleId");
		}

		String bookingDate = request.getParameter("bookingDate");
		String bookingTime = request.getParameter("bookingTime");
		String type = request.getParameter("type");
		String rentDay = request.getParameter("rentDay");
		String rentHour = request.getParameter("rentHour");
	%>
	<section>
		<h2>예약화면</h2>
		<form method="POST" action="pay">
			<input type="hidden" name="command" value="booking">
			<table>
				<tr>
					<td>예약번호</td>
					<td><input type="number" id="bookingNum" name="bookingNum"
						value="<%=bookingNum%>" readonly></td>
				</tr>
				<tr>
					<td>차량아이디</td>
					<td><input type="text" id="vehicleId" name="vehicleId"
						value="<%=vehicleId%>" readonly></td>
				</tr>
				<tr>
					<td>예약 고객</td>
					<td><input type="text" id="clientId" name="clientId"
						value="<%=client.getId()%>" readonly></td>
				</tr>

				<tr>
					<td>장기(L)/단기(S) 렌트</td>
					<td><select id="type" name="type">
							<option value="L"
								<%=type != null && type.equals("L") ? "selected" : ""%>>L</option>
							<option value="S"
								<%=type == null || type.equals("S") ? "selected" : ""%>>S</option>
					</select></td>
				</tr>
				<tr>
					<td>예약 날짜 및 시간</td>
					<td><input type="date" id="bookingDate" name="bookingDate"
						value="<%=bookingDate == null ? "" : bookingDate%>"></td>
					<td><input type="time" id="bookingTime" name="bookingTime"
						value="<%=bookingTime == null ? "" : bookingTime%>"></td>
				</tr>
				<tr>
					<td>이용 일수(장기 렌트시에만 기재)</td>
					<td><input type="number" id="rentDay" name="rentDay"
						value="<%=rentDay == null ? "" : rentDay%>"></td>

					<td>이용 시간(단기 렌트시에만 기재)</td>
					<td><input type="number" id="rentHour" name="rentHour"
						value="<%=rentHour == null ? "" : rentHour%>"></td>
				</tr>
			</table>
			<input type="button" value="다음으로" onclick="checkBookingValues(form)">
		</form>
	</section>
	<script type="text/javascript" src="../resources/bookingValidation.js"
		charset="UTF-8"></script>
</body>
<jsp:include page="footer"></jsp:include>
</html>

<%
}
%>