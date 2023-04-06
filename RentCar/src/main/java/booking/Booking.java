package booking;

import java.sql.Timestamp;

import booking.controller.BookingDao;

public class Booking {

	private int bookingNum;
	private String type;
	private String vehicleId;
	private String clientId;
	private Timestamp approvalTime;
	private Timestamp bookingTime;
	private int rentDay;
	private int rentHour;
	private int payment;

	public Booking(int bookingNum, String type, String vehicleId, String clientId, Timestamp approvalTime,
			Timestamp bookingTime, int rentDay, int rentHour, int payment) {
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

	public Booking(BookingRequestDto bookingDto) {
		BookingDao bookingDao = BookingDao.getInstance();
		this.bookingNum = bookingDao.getBookingNumMax();
		this.type = bookingDto.getType();
		this.vehicleId = bookingDto.getVehicleId();
		this.clientId = bookingDto.getClientId();
		this.approvalTime = bookingDto.getApprovalTime();
		this.bookingTime = bookingDto.getBookingTime();
		this.rentDay = bookingDto.getRentDay();
		this.rentHour = bookingDto.getRentHour();
		this.payment = bookingDto.getPayment();
	}

	public int getBookingNum() {
		return bookingNum;
	}

	public String getType() {
		return type;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public String getClientId() {
		return clientId;
	}

	public Timestamp getApprovalTime() {
		return approvalTime;
	}

	public Timestamp getBookingTime() {
		return bookingTime;
	}

	public int getRentDay() {
		return rentDay;
	}

	public int getRentHour() {
		return rentHour;
	}

	public int getPayment() {
		return payment;
	}

}
