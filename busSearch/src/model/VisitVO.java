package model;

public class VisitVO {
	int stop_number;
	String stop_name;
	int bus_number;
	public VisitVO() {
		
	}
	public VisitVO(int stop_number, String stop_name, int bus_number) {
		super();
		this.stop_number = stop_number;
		this.stop_name = stop_name;
		this.bus_number = bus_number;
	}
	public int getStop_number() {
		return stop_number;
	}
	public void setStop_number(int stop_number) {
		this.stop_number = stop_number;
	}
	public String getStop_name() {
		return stop_name;
	}
	public void setStop_name(String stop_name) {
		this.stop_name = stop_name;
	}
	public int getBus_number() {
		return bus_number;
	}
	public void setBus_number(int bus_number) {
		this.bus_number = bus_number;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("정류장: ").append(stop_name)
				.append("\t버스번호: ").append(bus_number);
		return builder.toString();
	}
	
	
	
}
