package model;

public enum Plane {

	A330(375),
	A340(380),
	B747(416),
	A380(525);
	
	private int maxSeat;
	
	Plane(int passenger)
	{
		setMaxSeat(passenger);
	}

	public int getMaxSeat() {
		return maxSeat;
	}

	public void setMaxSeat(int maxSeat) {
		this.maxSeat = maxSeat;
	}
}
