package model;

public class PassengerVO {
	String passenger_id;
	String passenger_password;
	String passenger_name;
	
	

	public PassengerVO(String passenger_id, String passenger_password, String passenger_name) {
		super();
		this.passenger_id = passenger_id;
		this.passenger_password = passenger_password;
		this.passenger_name = passenger_name;
	}
	public String getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(String passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getPassenger_password() {
		return passenger_password;
	}
	public void setPassenger_password(String passenger_password) {
		this.passenger_password = passenger_password;
	}
	public String getPassenger_name() {
		return passenger_name;
	}
	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PassengerVO [passenger_id=").append(passenger_id).append(", passenger_password=")
				.append(passenger_password).append(", passenger_name=").append(passenger_name).append("]");
		return builder.toString();
	}
	
	
	
}
