<%@page import="board.controller.BoardDao"%>
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
	if (client == null) {
		response.sendRedirect("login");
	}

	else {
		BoardDao boardDao = BoardDao.getInstance();
		String boardNum = boardDao.getBoardNumMax() + "";

		if (boardNum == null) {
			boardNum = request.getParameter("boardNum");
		}
		
		String boardType = request.getParameter("boardType");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	%>
	<section>
		<h2>게시판</h2>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="board">
			<table>
				<tr>
					<td>게시글 번호</td>
					<td><input type="number" id="boardNum" name="boardNum"
						value="<%=boardNum%>" readonly></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" id="clientId" name="clientId"
						value="<%=client.getId()%>" readonly></td>
				</tr>
				<tr>
					<td>게시글 종류</td>
					<td><select id="boardType" name="boardType">
							<option value="문의"
								<%=boardType == null || boardType.equals("문의") ? "selected" : ""%>>문의</option>
							<option value="후기"
								<%=boardType != null && boardType.equals("후기") ? "selected" : ""%>>후기</option>
					</select></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" id="title" name="title"
						placeholder="제목을 입력하세요" value="<%=title != null ? title : ""%>"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" id="content" name="content"
						value="<%=content != null ? content : ""%>"></td>
				</tr>
			</table>
			<input type="button" value="작성하기" onclick="checkValues()">
		</form>
	</section>
	<script src="../resources/boardValidation.js" charset="UTF-8"></script>
</body>
<jsp:include page="footer"></jsp:include>
</html>
<%
}
%>