package vehicle.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import board.Board;
import util.DBManager;
import vehicle.Vehicle;
import vehicle.VehicleRequestDto;

public class VehicleDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private VehicleDao() {
	}

	private static VehicleDao instance = new VehicleDao();

	public static VehicleDao getInstance() {
		return instance;
	}

	public void createVehicle(VehicleRequestDto vehicleDto) {
		Vehicle vehicle = new Vehicle(vehicleDto);

		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "INSERT INTO Vehicle VALUES(?, ?, ?, ?, ?)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, vehicle.getVehicleId());
				this.pstmt.setString(2, vehicle.getVehicleName());
				this.pstmt.setString(3, vehicle.getVehicleLocation());
				this.pstmt.setInt(4, vehicle.getPricePerDay());
				this.pstmt.setInt(5, vehicle.getPricePerHour());
				this.pstmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
	
	public Vehicle getVehicleById(String vehicleId) {
		Vehicle vehicle = null;
		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM Vehicle WHERE vehicle_id=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, vehicleId);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String vehicleName = this.rs.getString(2);
					String VehicleLocation = this.rs.getString(3);
					int pricePerDay = this.rs.getInt(4);
					int pricePerHour = this.rs.getInt(5);

					vehicle = new Vehicle(vehicleId, vehicleName, VehicleLocation, pricePerDay, pricePerHour);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return vehicle;
	}

	public ArrayList<Vehicle> getVehicleAll() {
		ArrayList<Vehicle> list = new ArrayList<Vehicle>();
		this.conn = DBManager.getConnectionFromMySQL();
		if (this.conn != null) {
			String sql = "SELECT * FROM Vehicle ORDER BY vehicle_id";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					String vehicleId = this.rs.getString(1);
					String vehicleName = this.rs.getString(2);
					String VehicleLocation = this.rs.getString(3);
					int pricePerDay = this.rs.getInt(4);
					int pricePerHour = this.rs.getInt(5);

					Vehicle vehicle = new Vehicle(vehicleId, vehicleName, VehicleLocation, pricePerDay, pricePerHour);
					list.add(vehicle);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}
		return list;
	}
}
