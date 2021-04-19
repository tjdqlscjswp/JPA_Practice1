package model;

public class BusStopsVO {
	int stop_number;
	String stop_name;
	public BusStopsVO() {
		
	}
	public BusStopsVO(String stop_name) {
		this.stop_name = stop_name;
	}
	public BusStopsVO(int stop_number, String stop_name) {
		super();
		this.stop_number = stop_number;
		this.stop_name = stop_name;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("정류장번호: ").append(stop_number).append(" 정류장이름: ").append(stop_name);
			
		return builder.toString();
	}
	
	
}
