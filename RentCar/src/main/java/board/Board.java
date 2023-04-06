package board;

import java.sql.Timestamp;

import board.controller.BoardDao;

public class Board {
	private int boardNum;
	private String boardType;
	private String clientId;
	private Timestamp publishDate;
	private Timestamp modifyDate;
	private String title;
	private String content;

	public Board(int boardNum, String boardType, String clientId, Timestamp publishDate, Timestamp modifyDate, String title, String content) {
		this.boardNum = boardNum;
		this.boardType = boardType;
		this.clientId = clientId;
		this.publishDate = publishDate;
		this.modifyDate = modifyDate;
		this.title = title;
		this.content = content;
	}
	
	public Board(int boardNum, String boardType, String clientId, Timestamp publishDate, String title, String content) {
		this.boardNum = boardNum;
		this.boardType = boardType;
		this.clientId = clientId;
		this.publishDate = publishDate;
		this.title = title;
		this.content = content;
	}

	public Board(int boardNum, Timestamp modifyDate, String title, String content) {
		this.boardNum = boardNum;
		this.modifyDate = modifyDate;
		this.title = title;
		this.content = content;
	}

	public Board(BoardRequestDto boardDto) {
		this.boardNum = boardDto.getBoardNum();
		this.boardType = boardDto.getBoardType();
		this.clientId = boardDto.getClientId();
		this.publishDate = boardDto.getPublishDate();
		this.title = boardDto.getTitle();
		this.content = boardDto.getContent();
	}

	public int getBoardNum() {
		return boardNum;
	}

	public String getBoardType() {
		return boardType;
	}

	public String getClientId() {
		return clientId;
	}

	public Timestamp getPublishDate() {
		return publishDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	
}
