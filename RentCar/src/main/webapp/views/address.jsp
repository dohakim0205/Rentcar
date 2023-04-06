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
	<%
	String roadAddress = request.getParameter("roadAddress");
	System.out.println(roadAddress);
	VehicleDao vehicleDao = VehicleDao.getInstance();
	ArrayList<Vehicle> list = vehicleDao.getVehicleAll();
	ArrayList<Vehicle> userList = new ArrayList<Vehicle>();
	int count = 0;
	for (int i = 0; i < list.size(); i++) {
		Vehicle car = list.get(i);

		if (car.getVehicleLocation().contains(roadAddress)) {
			userList.add(car);
		}
	}

	if (count == 0) {
	%>
	<p>검색 결과가 없습니다</p>
	<%
	} else {
	%>
	<table>
		<%
		for (int i = 0; i < userList.size(); i++) {
			Vehicle car = list.get(i);
		%>
		<tr>
			<td><a
				href="carDetail?vehicleId=<%=car.getVehicleId()%>&imgSrc=../resources/images/car<%=car.getVehicleId().substring(5, 7)%>.png">
					<img src="../resources/images/car<%=i + 1%>.png"></img>
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

	<button onclick="list">돌아가기</button>
</body>
<jsp:include page="footer"></jsp:include>
</html>