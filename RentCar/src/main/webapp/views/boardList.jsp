<%@page import="client.Client"%>
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
		<h2>내가 쓴 게시글</h2>
		<%
		Client client = (Client) session.getAttribute("log");
		if (client == null) {
			response.sendRedirect("login");
		}

		else {
			BoardDao boardDao = BoardDao.getInstance();
			ArrayList<Board> list = boardDao.getBoardByClientId(client.getId());
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
					System.out.println(text.getModifyDate());
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
		</form>
	</section>
</body>
<jsp:include page="footer"></jsp:include>
</html>
<%
}
%>