package vehicle;

public class Vehicle {
	private String vehicleId;
	private String vehicleName;
	private String vehicleLocation;
	private int pricePerDay;
	private int pricePerHour;
	
	public Vehicle(String vehicleId, String vehicleName, String vehicleLocation, int pricePerDay, int pricePerHour) {
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.vehicleLocation = vehicleLocation;
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
	}
	
	public Vehicle(VehicleRequestDto vehicleDto) {
		this.vehicleId = vehicleDto.getVehicleId();
		this.vehicleName = vehicleDto.getVehicleName();
		this.vehicleLocation = vehicleDto.getVehicleLocation();
		this.pricePerDay = vehicleDto.getPricePerDay();
		this.pricePerHour = vehicleDto.getPricePerHour();
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public String getVehicleLocation() {
		return vehicleLocation;
	}

	public int getPricePerDay() {
		return pricePerDay;
	}

	public int getPricePerHour() {
		return pricePerHour;
	}
}
