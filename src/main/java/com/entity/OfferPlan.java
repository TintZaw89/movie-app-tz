package com.entity;

public class OfferPlan {
	private String accNbr;
	private String offer;
	private String price;
	private String createdDate;
	private String effDate;
	private String expDate;
	private String status;
	
	public OfferPlan(String accNbr, String offer, String price, String createdDate, String effDate, String expDate,
			String status) {
		super();
		this.accNbr = accNbr;
		this.offer = offer;
		this.price = price;
		this.createdDate = createdDate;
		this.effDate = effDate;
		this.expDate = expDate;
		this.status = status;
	}

	public String getAccNbr() {
		return accNbr;
	}

	public void setAccNbr(String accNbr) {
		this.accNbr = accNbr;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getEffDate() {
		return effDate;
	}

	public void setEffDate(String effDate) {
		this.effDate = effDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OfferPlan [accNbr=" + accNbr + ", offer=" + offer + ", price=" + price + ", createdDate=" + createdDate
				+ ", effDate=" + effDate + ", expDate=" + expDate + ", status=" + status + "]";
	}
	

}
