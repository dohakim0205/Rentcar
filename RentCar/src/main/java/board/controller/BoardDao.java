package board.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import board.Board;
import board.BoardRequestDto;
import util.DBManager;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BoardDao() {
	}

	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	public void createBoard(BoardRequestDto boardDto) {
		Board board = new Board(boardDto);

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "INSERT INTO Client (board_num, board_type, client_id, publish_date, title, content) VALUES(?, ?, ?, ?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, board.getBoardNum());
				this.pstmt.setString(2, board.getBoardType());
				this.pstmt.setString(3, board.getClientId());
				this.pstmt.setTimestamp(4, board.getPublishDate());
				this.pstmt.setString(5, board.getTitle());
				this.pstmt.setString(6, board.getContent());
				this.pstmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	public ArrayList<Board> getBoardAll() {
		ArrayList<Board> list = new ArrayList<Board>();
		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM Board ORDER BY board_num";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int boardNum = this.rs.getInt(1);
					String boardType = this.rs.getString(2);
					String clientId = this.rs.getString(3);
					Timestamp publish_date = this.rs.getTimestamp(4);
					Timestamp modify_date = this.rs.getTimestamp(5);
					String title = this.rs.getString(6);
					String content = this.rs.getString(7);

					Board board = new Board(boardNum, boardType, clientId, publish_date, modify_date, title, content);
					list.add(board);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	public Board getBoardByBoardNum(int boardNum) {
		Board board = null;
		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM Board WHERE board_num=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, boardNum);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String boardType = this.rs.getString(2);
					String clientId = this.rs.getString(3);
					Timestamp publish_date = this.rs.getTimestamp(4);
					Timestamp modify_date = this.rs.getTimestamp(5);
					String title = this.rs.getString(6);
					String content = this.rs.getString(7);

					board = new Board(boardNum, boardType, clientId, publish_date, modify_date, title, content);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return board;
	}

	public ArrayList<Board> getBoardByClientId(String clientId) {
		ArrayList<Board> list = new ArrayList<Board>();
		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM Board WHERE client_id=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, clientId);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int boardNum = this.rs.getInt(1);
					String boardType = this.rs.getString(2);
					Timestamp publish_date = this.rs.getTimestamp(4);
					Timestamp modify_date = this.rs.getTimestamp(5);
					String title = this.rs.getString(6);
					String content = this.rs.getString(7);

					Board board = new Board(boardNum, boardType, clientId, publish_date, modify_date, title, content);
					list.add(board);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	// U
	public void updateBoard(BoardRequestDto boardDto) {
		Board board = new Board(boardDto);

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null && board != null) {
			String sql = "UPDATE Board SET modify_date=?, title=?, content=? WHERE boardNum=?";

			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setTimestamp(1, board.getModifyDate());
				this.pstmt.setString(2, board.getTitle());
				this.pstmt.setString(3, board.getContent());
				this.pstmt.setInt(4, board.getBoardNum());
				this.pstmt.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	public int getBoardNumMax() {
		int boardNum = -1;
		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT MAX(board_num) as max_num FROM Board";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				this.rs.next();
				boardNum = this.rs.getInt(1) + 1;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return boardNum;
	}
}
