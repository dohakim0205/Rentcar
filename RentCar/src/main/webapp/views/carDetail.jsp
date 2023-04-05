<%@page import="vehicle.Vehicle"%>
<%@page import="vehicle.controller.VehicleDao"%>
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
		<h2>예약하기</h2>
		<%
		if (session.getAttribute("log") == null) {
			response.sendRedirect("login");
		}

		else {
			String vehicleId = request.getParameter("vehicleId");
			String imgSrc = request.getParameter("imgSrc");
			VehicleDao vehicleDao = VehicleDao.getInstance();
			Vehicle car = vehicleDao.getVehicleById(vehicleId);

			if (car != null) {
		%>
		<table border="1">
			<thead>
				<tr>
					<th>차량 사진</th>
					<th>차량 아이디</th>
					<th>차량 이름</th>
					<th>현위치</th>
					<th>1일 대여 금액(장기렌트)</th>
					<th>1시간 대여 금액(단기렌트)</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><img src=<%=imgSrc%>></img></td>
					<td><%=car.getVehicleId()%></td>
					<td><%=car.getVehicleName()%></td>
					<td><%=car.getVehicleLocation()%></td>
					<td><%=car.getPricePerDay()%>0000원</td>
					<td><%=car.getPricePerHour()%>0000원</td>
				</tr>
			</tbody>
		</table>
		<button>
			<a href="booking?vehicleId=<%=car.getVehicleId()%>">차량 예약하기</a>
		</button>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>
<%
}
}
%>