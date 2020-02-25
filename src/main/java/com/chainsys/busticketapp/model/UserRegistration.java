package com.chainsys.busticketapp.model;

public class UserRegistration {
	private String UserName;

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	private String EmailId;
	private String password;
	private Long contactNumber;
	private int UserId;

	@Override
	public String toString() {
		return "UserLogin [UserName=" + UserName + ", EmailId=" + EmailId + ", password=" + password
				+ ", contactNumber=" + contactNumber + ", UserId=" + UserId + "]";
	}

}
