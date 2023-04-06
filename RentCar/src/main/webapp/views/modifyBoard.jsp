<%@page import="board.controller.BoardDao"%>
<%@page import="board.Board"%>
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
	
	int num = Integer.parseInt(request.getParameter("boardNum"));
	BoardDao boardDao = BoardDao.getInstance();
	Board board = boardDao.getBoardByBoardNum(num);
	
	String boardNum = num + "";
	String boardType = board.getBoardType();
	String title = board.getTitle();
	String content = board.getContent();

	if (boardNum == null) {
		boardNum = request.getParameter("boardNum");
	}

	if (boardType == null) {
		boardType = request.getParameter("boardType");
	}

	if (title == null) {
		title = request.getParameter("title");
	}

	if (content == null) {
		content = request.getParameter("content");
	}
	
	board = boardDao.getBoardByBoardNum(Integer.parseInt(boardNum));
	String pDate = board.getPublishDate().toString().substring(0, 11);
	String mDate = "";
	if (board.getModifyDate() == null) {
		mDate = "없음";
	}

	else {
		mDate = board.getModifyDate().toString().substring(0, 11);
	}
	%>

	<section>
		<h2>게시글 수정</h2>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="modifyBoard">
			<table border="1">
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
							<option value="문의" <%=boardType == null || boardType.equals("문의") ? "selected" : ""%>>문의</option>
							<option value="후기"
								<%=boardType != null && boardType.equals("후기") ? "selected" : ""%>>후기</option>
					</select></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input class="title-content" type="text" id="title"
						name="title" placeholder="제목을 입력하세요"
						value="<%=title != null ? title : ""%>"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input class="content" type="text" id="content"
						name="content" value="<%=content != null ? content : ""%>"></td>
				</tr>
				<%
				
				%>
				<tr>
					<td><%=pDate%></td>
					<td><%=mDate%></td>
				</tr>
				</tbody>
			</table>
			<input type="button" onclick="checkBoardValues(form)" value="수정하기"></input>
		</form>
	</section>
	<script src="../resources/boardValidation.js" charset="UTF-8"></script>
</body>
<jsp:include page="footer"></jsp:include>
</html>