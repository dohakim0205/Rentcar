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
	if(client == null){
	System.out.println("hi");
	response.sendRedirect("login");
	}
	
	else {
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
		</table>
		<button onclick= "location.href = 'update'">회원 정보 수정</button>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>
<%
	}
%>