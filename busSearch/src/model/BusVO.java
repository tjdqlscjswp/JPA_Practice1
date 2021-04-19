package model;

public class BusVO {
	private int bus_no;
	
	

	public BusVO(int bus_no) {
		super();
		this.bus_no = bus_no;
	}

	public int getBus_no() {
		return bus_no;
	}

	public void setBus_no(int bus_no) {
		this.bus_no = bus_no;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BusVO [bus_no=").append(bus_no).append("]");
		return builder.toString();
	}
	
	
	
	

}
