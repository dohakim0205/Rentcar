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
	<section>
		<h2>메인화면</h2>
		<%
		//ClientDao clientDao = ClientDao.getInstance();
		//Client client = clientDao.getClientById("asdf1234");
		//session.setAttribute("log", client);
		%>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>