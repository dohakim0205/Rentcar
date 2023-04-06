<%@page import="java.util.ArrayList"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@page import="vehicle.Vehicle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<jsp:include page="header"></jsp:include>
<body>

	<section>
		<h2>예약하기</h2>
		<%
		VehicleDao vehicleDao = VehicleDao.getInstance();
		ArrayList<Vehicle> list = vehicleDao.getVehicleAll();
		
		if(request.getAttribute("list") != null)
			list = (Arraylist<Vehicle>) request.getAttribute("list");
		%>

		<form method="POST" action="../service">
			<h3>현위치로 검색</h3>
			<input type="hidden" name="command" value="address">
			<input type="text" id="sample4_postcode" placeholder="우편번호">
			<input type="button" onclick="searchZoneCode()" value="우편번호 찾기"><br> 
				<input type="text" id="roadAddress" placeholder="도로명주소"> 
				<input type="text" id="sample4_jibunAddress" placeholder="지번주소"> 
				<span id="guide" style="color: #999; display: none"></span> 
				<input type="text" id="sample4_detailAddress" placeholder="상세주소"> 
				<input	type="text" id="sample4_extraAddress" placeholder="참고항목">
				<input type="summit" value="검색하기">
		</form>
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
				<%
				for (int i = 0; i < list.size(); i++) {
					Vehicle car = list.get(i);
				%>
				<tr>
					<td><a
						href="carDetail?vehicleId=<%=car.getVehicleId()%>&imgSrc=../resources/images/car<%=i + 1%>.png">
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
				%>
			</tbody>
		</table>
	</section>


	<script src="../resources/address.js"></script>
</body>
<jsp:include page="footer"></jsp:include>
</html>
