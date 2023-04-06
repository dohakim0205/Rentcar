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

	<section>
		<h2>게시판</h2>
		<%
		BoardDao boardDao = BoardDao.getInstance();
		ArrayList<Board> list = boardDao.getBoardAll();
		%>

		<form>
		<table border="1">
			<thead>
				<tr>
					<th>게시글 번호</th>
					<th>종류</th>
					<th>아이디</th>
					<th>작성일</th>
					<th>수정일</th>
					<th>제목</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < list.size(); i++) {
					Board text = list.get(i);
					String pDate = text.getPublishDate().toString().substring(0, 11);

					String mDate = "";
					if (text.getModifyDate() == null) {
						mDate = "없음";
					}

					else {
						mDate = text.getModifyDate().toString().substring(0, 11);
					}
				%>
				<tr>
					<td><%=text.getBoardNum()%></td>
					<td><%=text.getBoardType()%></td>
					<td><%=text.getClientId()%></td>
					<td><%=pDate%></td>
					<td><%=mDate%></td>
					<td><a
						href="content?boardNum=<%=text.getBoardNum()%>&pDate=<%=pDate%>&mDate=<%=mDate%>"><%=text.getTitle()%></a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<input type="button" onclick="location.href = 'write'" value="작성하기"></input>
	</form>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>