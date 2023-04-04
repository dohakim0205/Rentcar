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
	ClientDao clientDao = ClientDao.getInstance();

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	%>

	<section>
		<h2>회원등록</h2>
		<form method="POST" action="../RegistAction">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input type="text" id="id" name="id"
						value="<%=id != null ? id : ""%>"
						<%=id == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" id="pw" name="pw"
						value="<%=pw != null ? pw : ""%>"
						<%=pw == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" id="name" name="name"
						value="<%=name != null ? name : ""%>"
						<%=name == null ? "autofocus" : ""%>></td>
				</tr>
			</table>
			<input type="button" value="가입" onclick="checkValues(form)">
		</form>
	</section>

	<script src="../resources/validation.js"></script>
</body>
<jsp:include page="footer"></jsp:include>
</html>