package com.chainsys.busticketapp.model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BusTiming {


	
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	@Override
	public String toString() {
		return "BusTiming [busNo=" + busNo + ", amount=" + amount + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + "]";
	}

	private int busNo;
	private int amount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime departureTime;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime arrivalTime;
	
	

	

}
