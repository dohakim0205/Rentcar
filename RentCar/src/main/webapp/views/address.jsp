<%@page import="vehicle.Vehicle"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@page import="java.util.ArrayList"%>
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
	<h3>현위치 검색 결과</h3>

	<%
	ArrayList<Vehicle> list = (ArrayList<Vehicle>) request.getAttribute("list");

	if (list == null) {
	%>
	<p>검색 결과가 없습니다</p>
	<%
	} else {
	%>
	<table>
		<%
		for (int i = 0; i < list.size(); i++) {
			Vehicle car = list.get(i);
			int num = Integer.parseInt(car.getVehicleId().substring(3));
		%>
		<tr>
			<td><a
				href="carDetail?vehicleId=<%=car.getVehicleId()%>&imgSrc=../resources/images/car<%=num%>.png">
					<img src="../resources/images/car<%=num%>.png"></img>
			</a></td>
			<td><a href="carDetail?vehicleId=<%=car.getVehicleId()%>"><%=car.getVehicleId()%></a></td>
			<td><%=car.getVehicleName()%></td>
			<td><%=car.getVehicleLocation()%></td>
			<td><%=car.getPricePerDay()%>0000원</td>
			<td><%=car.getPricePerHour()%>0000원</td>
		</tr>
		<%
		}
		}
		%>
	</table>

	<button onclick="location.href='list'">돌아가기</button>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>