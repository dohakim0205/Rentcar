package controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardRequestDto;
import board.controller.BoardDao;

public class ModifyBoardAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String clientId = request.getParameter("clientId");
		String boardType = request.getParameter("boardType");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDao boardDao = BoardDao.getInstance();
		Board board = boardDao.getBoardByBoardNum(boardNum);
		Timestamp publishDate = board.getPublishDate();
		Timestamp modifyDate = new Timestamp(System.currentTimeMillis());
		
		BoardRequestDto boardDto = new BoardRequestDto(boardNum, boardType, clientId, publishDate, modifyDate, title, content);
		System.out.println(boardDto.getModifyDate());
		boardDao.updateBoard(boardDto);
		
		response.sendRedirect("boardList");
	}
}
