package com.chainsys.busticketapp.model;

public class Buses {

	@Override
	public String toString() {
		return "ListOfBuses [busNo=" + busNo + ", busName=" + busName + ", busSource=" + busSource + ", busDestination="
				+ busDestination + ", clazz=" + clazz + ", amount=" + amount + ", busTiming=" + busTiming
				+ ", seatAvailability=" + seatAvailability + "]";
	}

	private int busNo;
	private String busName;
	private String busSource;
	private String busDestination;
	private String clazz;
	private int amount;
	private int busCount;

	private BusTiming busTiming;
	private SeatAvailability seatAvailability;

	public int getBusCount() {
		return busCount;
	}

	public void setBusCount(int busCount) {
		this.busCount = busCount;
	}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusSource() {
		return busSource;
	}

	public void setBusSource(String busSource) {
		this.busSource = busSource;
	}

	public String getBusDestination() {
		return busDestination;
	}

	public void setBusDestination(String busDestination) {
		this.busDestination = busDestination;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public BusTiming getBusTiming() {
		return busTiming;
	}

	public void setBusTiming(BusTiming busTiming) {
		this.busTiming = busTiming;
	}

	public SeatAvailability getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(SeatAvailability seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}