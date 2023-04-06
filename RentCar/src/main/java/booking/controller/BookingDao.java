package booking.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import booking.Booking;
import booking.BookingRequestDto;
import util.DBManager;

public class BookingDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private BookingDao() {
	}

	private static BookingDao instance = new BookingDao();

	public static BookingDao getInstance() {
		return instance;
	}

	public void createBookingForLongRent(BookingRequestDto bookingDto) {
		Booking booking = new Booking(bookingDto);

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "INSERT INTO Booking (booking_num, booking_type, vehicle_id, client_id, booking_approval_time, booking_time, rent_day, payment) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, booking.getBookingNum());
				this.pstmt.setString(2, booking.getType());
				this.pstmt.setString(3, booking.getVehicleId());
				this.pstmt.setString(4, booking.getClientId());
				this.pstmt.setTimestamp(5, booking.getApprovalTime());
				this.pstmt.setTimestamp(6, booking.getBookingTime());
				this.pstmt.setInt(7, booking.getRentDay());
				this.pstmt.setInt(8, booking.getPayment());

				this.pstmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	public void createBookingForShortRent(BookingRequestDto bookingDto) {
		Booking booking = new Booking(bookingDto);

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "INSERT INTO Booking (booking_num, booking_type, vehicle_id, client_id, booking_approval_time, booking_time, rent_hour, payment) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, booking.getBookingNum());
				this.pstmt.setString(2, booking.getType());
				this.pstmt.setString(3, booking.getVehicleId());
				this.pstmt.setString(4, booking.getClientId());
				this.pstmt.setTimestamp(5, booking.getApprovalTime());
				this.pstmt.setTimestamp(6, booking.getBookingTime());
				this.pstmt.setInt(7, booking.getRentHour());
				this.pstmt.setInt(8, booking.getPayment());

				this.pstmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}

	public Booking getBookingByNum(int bookingNum) {
		Booking booking = null;
		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM Booking WHERE booking_num=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setInt(1, bookingNum);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String type = this.rs.getString(2);
					String vehicleId = this.rs.getString(3);
					String clientId = this.rs.getString(4);
					Timestamp approvalTime = this.rs.getTimestamp(5);
					Timestamp bookingTime = this.rs.getTimestamp(6);
					int rentDay = this.rs.getInt(7);
					int rentHour = this.rs.getInt(8);
					int payment = this.rs.getInt(9);

					booking = new Booking(bookingNum, type, vehicleId, clientId, approvalTime, bookingTime, rentDay,
							rentHour, payment);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return booking;
	}

	public ArrayList<Booking> getBookingByClientId(String clientId) {
		ArrayList<Booking> list = new ArrayList<Booking>();
		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM Booking WHERE client_id=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, clientId);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int bookingNum = this.rs.getInt(1);
					String type = this.rs.getString(2);
					String vehicleId = this.rs.getString(3);
					Timestamp approvalTime = this.rs.getTimestamp(5);
					Timestamp bookingTime = this.rs.getTimestamp(6);
					int rentDay = this.rs.getInt(7);
					int rentHour = this.rs.getInt(8);
					int payment = this.rs.getInt(9);

					Booking booking = new Booking(bookingNum, type, vehicleId, clientId, approvalTime, bookingTime,
							rentDay, rentHour, payment);
					list.add(booking);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}

	public int getBookingNumMax() {
		int bookingNum = -1;
		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT MAX(booking_num) as max_num FROM Booking";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				this.rs.next();
				bookingNum = this.rs.getInt(1) + 1;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return bookingNum;
	}

}
