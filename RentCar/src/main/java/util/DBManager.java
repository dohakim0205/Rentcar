package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	
	public static Connection getConnectionFromMySQL() {
		Connection conn = null;

		// JNDI
		// Java Naming and Directory Interface
		
		try {
			Context init = new InitialContext();
			DataSource source = (DataSource) init.lookup("java:comp/env/jdbc/test");
			conn = source.getConnection();
			
			System.out.println("mysql DB 연동 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mysql DB 연동 실패");
		}

		return conn;
	}
	

	public static Connection getConnection() {
		Connection conn = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "C##SYSTEM";
		String password = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DB 연동 성공");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연동 실패");
		}

		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
