package vehicle;

public class VehicleRequestDto {
	private String vehicleId;
	private String vehicleName;
	private String vehicleLocation;
	private int pricePerDay;
	private int pricePerHour;
	
	public VehicleRequestDto(String vehicleId, String vehicleName, String vehicleLocation, int pricePerDay, int pricePerHour) {
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.vehicleLocation = vehicleLocation;
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleLocation() {
		return vehicleLocation;
	}

	public void setVehicleLocation(String vehicleLocation) {
		this.vehicleLocation = vehicleLocation;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public int getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(int pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

}
