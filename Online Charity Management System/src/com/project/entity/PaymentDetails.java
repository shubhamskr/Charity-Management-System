package com.project.entity;


public class PaymentDetails {

	private String paymentId;
	private String Name;
	private String Number;
	private String Month;
	private String Year;
	private String Cvv;
	private String bookingId;
	
	public String getPAYMENTID() {
		return paymentId;
	}
	public void setPAYMENTID(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getNAME() {
		return Name;
	}
	public void setNAME(String Name) {
		this.Name = Name;
	}
	public String getNUMBER() {
		return Number;
	}
	public void setNUMBER(String Number) {
		this.Number = Number;
	}
	public String getMONTH() {
		return Month;
	}
	public void setMONTH(String Month) {
		this.Month = Month;
	}
	public String getYEAR() {
		return Year;
	}
	public void setYEAR(String Year) {
		this.Year = Year;
	}
	public String getCVV() {
		return Cvv;
	}
	public void setCVV(String Cvv) {
		this.Cvv = Cvv;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", Name=" + Name + ", Number=" + Number + ", Month=" + Month
				+ ", Year=" + Year + ", Cvv=" + Cvv + ", bookingId=" + bookingId + "]";
	}
	
	
}
