package com.chainsys.busticketapp.model;

public class Passenger {

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public long getPassengerContact() {
		return passengerContact;
	}

	public void setPassengerContact(long passengerContact) {
		this.passengerContact = passengerContact;
	}

	private int busNo;
	private int passengerId;
	private String passengerName;
	private int passengerAge;
	private String passengerGender;
	private long passengerContact;

	@Override
	public String toString() {
		return "Passenger [busNo=" + busNo + ", passengerId=" + passengerId + ", passengerName=" + passengerName
				+ ", passengerAge=" + passengerAge + ", passengerGender=" + passengerGender + ", passengerContact="
				+ passengerContact + "]";
	}

}
