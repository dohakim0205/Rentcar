package board;

import java.sql.Timestamp;

public class BoardRequestDto {
	private int boardNum;
	private String boardType;
	private String clientId;
	private Timestamp publishDate;
	private Timestamp modifyDate;
	private String title;
	private String content;
	
	public BoardRequestDto(int boardNum, String boardType, String clientId, Timestamp publishDate, Timestamp modifyDate, String title, String content) {
		this.boardNum = boardNum;
		this.boardType = boardType;
		this.clientId = clientId;
		this.publishDate = publishDate;
		this.modifyDate = modifyDate;
		System.out.println(this.modifyDate);
		this.title = title;
		this.content = content;
	}

	public BoardRequestDto(int boardNum, String boardType, String clientId, Timestamp publishDate, String title, String content) {
		this.boardNum = boardNum;
		this.boardType = boardType;
		this.clientId = clientId;
		this.publishDate = publishDate;
		this.title = title;
		this.content = content;
	}
	
	public BoardRequestDto(int boardNum, Timestamp modifyDate, String title, String content) {
		this.boardNum = boardNum;
		this.modifyDate = modifyDate;
		this.title = title;
		this.content = content;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Timestamp getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	public Timestamp getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
