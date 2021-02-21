package com.project.entity;


public class BookingDetails {

	private String bookingId;
	private String charity;
	private String email;
	private String bookedDate;
	private String Amount;
	private String fullName;
	private String paymentId;
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getCharity() {
		return charity;
	}
	public void setCharity(String charity) {
		this.charity = charity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}
	public String getAMOUNT() {
		return Amount;
	}
	public void setAMOUNT(String Amount) {
		this.Amount = Amount;
	}
	public String getFULLNAME() {
		return fullName;
	}
	public void setFULLNAME(String fullName) {
		this.fullName = fullName;
	}
	public String getPAYMENTID() {
		return paymentId;
	}
	public void setPAYMENTID(String paymentId) {
		this.paymentId = paymentId;
	}
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", charity=" + charity + ", email=" + email + ", bookedDate="
				+ bookedDate + ", Amount=" + Amount + ", fullName=" + fullName + ", paymentId=" + paymentId + "]";
	}
	
	
	
}
