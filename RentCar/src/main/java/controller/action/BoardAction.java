package controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardRequestDto;
import board.controller.BoardDao;

public class BoardAction implements Action{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int boardNum = Integer.parseInt(request.getParameter("boardNum"));
	String clientId = request.getParameter("clientId");
	String boardType = request.getParameter("boardType");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	Timestamp publishDate = new Timestamp(System.currentTimeMillis());
	
	BoardRequestDto boardDto = new BoardRequestDto(boardNum, boardType, clientId, publishDate, title, content);
	BoardDao boardDao = BoardDao.getInstance();
	boardDao.createBoard(boardDto);
	
	response.sendRedirect("board");
	}

}
