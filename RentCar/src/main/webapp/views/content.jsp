<%@page import="board.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.controller.BoardDao"%>
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
	request.setCharacterEncoding("UTF-8");
	int boardNum = Integer.parseInt(request.getParameter("boardNum"));
	String pDate = (request.getParameter("pDate"));
	String mDate = (request.getParameter("mDate"));
	BoardDao boardDao = BoardDao.getInstance();
	Board board = boardDao.getBoardByBoardNum(boardNum);
	%>
	<section>
		<h2><%=board.getTitle()%></h2>
		<table border="1">
			<thead>
				<tr>
					<th>게시글 번호</th>
					<th>종류</th>
					<th>아이디</th>
					<th>작성일</th>
					<th>수정일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=board.getBoardNum()%></td>
					<td><%=board.getBoardType()%></td>
					<td><%=board.getClientId()%></td>
					<td><%=pDate%></td>
					<td><%=mDate%></td>
				</tr>
				<tr>
					<td colspan="5" class = "title">제목</td>
				</tr>
				<tr>
					<td colspan="5" class = "title-text"><%=board.getTitle()%></td>
				</tr>
				<tr>
					<td colspan="5" class = "title">내용</td>
				</tr>
				<tr>
					<td colspan="5" class = "content"><%=board.getContent()%></td>
				</tr>
			</tbody>
		</table>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>