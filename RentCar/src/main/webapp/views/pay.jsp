<%@page import="vehicle.controller.VehicleDao"%>
<%@page import="vehicle.Vehicle"%>
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
	String bookingNum = (String) request.getParameter("bookingNum");
	String vehicleId = (String) request.getParameter("vehicleId");
	String clientId = (String) request.getParameter("clientId");
	String type = (String) request.getParameter("type");
	String bookingDate = request.getParameter("bookingDate");
	String bookingTime = request.getParameter("bookingTime");
	String rentDay = request.getParameter("rentDay");
	String rentHour = request.getParameter("rentHour");
	
	VehicleDao vehicleDao = VehicleDao.getInstance();
	Vehicle vehicle = vehicleDao.getVehicleById(vehicleId); 
	int payment = type.equals("L") ? vehicle.getPricePerDay() * Integer.parseInt(rentDay) : vehicle.getPricePerHour() * Integer.parseInt(rentHour); 
	%>
	<section>
		<h2>예약확인/결제</h2>
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
						value="<%=clientId%>" readonly></td>
				</tr>

				<tr>
					<td>장기(L)/단기(S) 렌트</td>
					<td><input id="type" name="type" value="<%=type%>" readonly></td>
				</tr>
				<tr>
					<td>예약 날짜 및 시간</td>
					<td><input type="date" id="bookingDate" name="bookingDate"
						value="<%=bookingDate%>" readonly></td>
					<td><input type="date" id="bookingTime" name="bookingTime"
						value="<%=bookingTime%>" readonly></td>
				</tr>

				<%
				if (rentDay != "") {
				%>
				<tr>
					<td>이용 일수(장기 렌트)</td>
					<td><input type="number" id="rentDay" name="rentDay"
						value="<%=rentDay%>" readonly></td>
				</tr>
				<%
				}
				if (rentDay != "") {
				%>
				<tr>
					<td>이용 시간(단기 렌트)</td>
					<td><input type="number" id="rentHour" name="rentHour"
						value="<%=rentHour%>" readonly></td>
				</tr>
				<%
				}
				%>
				<tr>
					<td>결제 금액</td>
					<td><input type="number" id="payment" name="payment"
						value="<%=payment%>" readonly>0000원</td>
				</tr>
			</table>
			<input type="submit" value="결제"> <input type="button"
				value="취소" onclick="location.href='/'">
		</form>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>