package com.entity;

public class MovieOrderView {
	private String orderId;
	private String userName;
	private String address;
	private String phoneNumber;
	private String movieName;
	private String director;
	private String price;
	private String paymentType;
	private String email;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MovieOrderView [orderId=" + orderId + ", userName=" + userName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", movieName=" + movieName + ", director=" + director + ", price="
				+ price + ", paymentType=" + paymentType + ", email=" + email + "]";
	}
	
	
	
}
