package booking;

import java.sql.Timestamp;

public class BookingRequestDto {

	private int bookingNum;
	private String type;
	private String vehicleId;
	private String clientId;
	private Timestamp approvalTime;
	private  Timestamp bookingTime;
	private int rentDay;
	private int rentHour;
	private int payment;
	

	public BookingRequestDto(int bookingNum, String type, String vehicleId, String clientId, Timestamp approvalTime, Timestamp bookingTime, int rentDay, int rentHour, int payment) {
		this.bookingNum = bookingNum;
		this.type = type;
		this.vehicleId = vehicleId;
		this.clientId = clientId;
		this.approvalTime = approvalTime;
		this.bookingTime = bookingTime;
		this.rentDay = rentDay;
		this.rentHour = rentHour;
		this.payment = payment;
	}


	public int getBookingNum() {
		return bookingNum;
	}


	public void setBookingNum(int bookingNum) {
		this.bookingNum = bookingNum;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getVehicleId() {
		return vehicleId;
	}


	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}


	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public Timestamp getApprovalTime() {
		return approvalTime;
	}


	public void setApprovalTime(Timestamp approvalTime) {
		this.approvalTime = approvalTime;
	}


	public Timestamp getBookingTime() {
		return bookingTime;
	}


	public void setBookingTime(Timestamp bookingTime) {
		this.bookingTime = bookingTime;
	}


	public int getRentDay() {
		return rentDay;
	}


	public void setRentDay(int rentDay) {
		this.rentDay = rentDay;
	}


	public int getRentHour() {
		return rentHour;
	}


	public void setRentHour(int rentHour) {
		this.rentHour = rentHour;
	}


	public int getPayment() {
		return payment;
	}


	public void setPayment(int payment) {
		this.payment = payment;
	}
}
