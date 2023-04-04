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
	String id = request.getParameter("id");

	ClientDao clientDao = ClientDao.getInstance();
	Client client = clientDao.getClientById(id);
	%>

	<section>
		<h2>회원 정보 수정</h2>
		<form method="POST" action="../UpdateAction">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input type="text" id = "id" name="id" value="<%=id%>"
						readonly></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" id = "password" name="password" value="<%=client.getPw()%>"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" id = "name" name="name"
						value="<%=client.getName()%>"></td>
				</tr>
			</table>
			<input type="submit" value="수정">
			<input type="button"
				value="취소" onclick="location.href = "/">
		</form>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>