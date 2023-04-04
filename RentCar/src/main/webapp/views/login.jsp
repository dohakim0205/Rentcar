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
		<h2>로그인</h2>
		<form method="POST" action="../LoginAction">
			<table>
				<tr>
					<td class="kind">아이디</td>
					<td><input type="text" id="id" name="id" placeholder="아이디"></td>
				</tr>
				<tr>
					<td class="kind">비밀번호</td>
					<td><input type="password" id="pw" name="pw"
						placeholder="비밀번호"></td>
				</tr>
			</table>
			<input type="submit" value="로그인">
		</form>
	</section>
	<script src="../resources/loginCheck.js"></script>
</body>
<jsp:include page="footer"></jsp:include>
</html>