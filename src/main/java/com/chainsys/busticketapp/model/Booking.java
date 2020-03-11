package com.chainsys.busticketapp.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Booking {



	


	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
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
	public int getNoOfTicket() {
		return noOfTicket;
	}
	public void setNoOfTicket(int noOfTicket) {
		this.noOfTicket = noOfTicket;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDateTime getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDateTime journeyDate) {
		this.journeyDate = journeyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Booking [ticketNo=" + ticketNo + ", busNo=" + busNo + ", passengerId=" + passengerId + ", noOfTicket="
				+ noOfTicket + ", totalAmount=" + totalAmount + ", journeyDate=" + journeyDate + ", status=" + status
				+ ", userId=" + userId + "]";
	}

	private int ticketNo;
	private int busNo;
	private int passengerId;
	private int noOfTicket;
	private int totalAmount;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")	
	private LocalDateTime journeyDate;
	private String status;
	private int userId;

}
