package com.chainsys.busticketapp.model;

public class SeatAvailability {
	private int busNo;

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	private int availableSeats;
	private int totalSeats;

	@Override
	public String toString() {
		return "SeatAvailability [busNo=" + busNo + ", availableSeats=" + availableSeats + ", totalSeats=" + totalSeats
				+ "]";
	}

}
