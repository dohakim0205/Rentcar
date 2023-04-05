package client.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import client.Client;
import client.ClientRequestDto;
import util.DBManager;

public class ClientDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private ClientDao() {}

	private static ClientDao instance = new ClientDao();

	public static ClientDao getInstance() {
		return instance;
	}
	
	public void createClient (ClientRequestDto clientDto) {
		Client client = new Client(clientDto);

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "INSERT INTO Client VALUES(?, ?, ?, ?);";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, client.getId());
				this.pstmt.setString(2, client.getPw());
				this.pstmt.setString(3, client.getName());
				this.pstmt.setTimestamp(4, client.getRegistDate());
				this.pstmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
	
	public ArrayList<Client> getClientAll() {
		ArrayList<Client> list = new ArrayList<Client>();
		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM client ORDER BY regist_date";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String id = this.rs.getString(1);
					String pw = this.rs.getString(2);
					String name = this.rs.getString(3);
					Timestamp registDate = this.rs.getTimestamp(4);

					Client client = new Client(id, pw, name, registDate);
					list.add(client);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	public Client getClientById(String id) {
		Client client = null;
		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM client WHERE client_id=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, id);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String pw = this.rs.getString(2);
					String name = this.rs.getString(3);
					Timestamp registDate = this.rs.getTimestamp(4);

					client = new Client(id, pw, name, registDate);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return client;
	}

	// U
	public void updateClient(ClientRequestDto clientDto) {
		Client client = new Client(clientDto);

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null && client != null) {
			String sql = "UPDATE client SET client_pw=?, client_name=? WHERE client_id=?";
			try {
				this.pstmt = conn.prepareStatement(sql);
				this.pstmt.setString(1, client.getPw());
				this.pstmt.setString(2, client.getName());
				this.pstmt.setString(3, client.getId());
				this.pstmt.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
}
