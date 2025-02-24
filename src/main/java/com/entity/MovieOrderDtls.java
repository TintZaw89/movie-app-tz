package com.entity;

public class MovieOrderDtls {
	
	private int id;
	private String orderId;
	private int cartId;
	private String movieName;
	private String director;
	private String price;
	private int movieid;
	private int userid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "MovieOrderDtls [id=" + id + ", orderId=" + orderId + ", cartId=" + cartId + ", movieName=" + movieName
				+ ", director=" + director + ", price=" + price + ", movieid=" + movieid + ", userid=" + userid + "]";
	}
	
	
}
