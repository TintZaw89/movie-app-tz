package com.entity;

public class Order {
	
	private String orderNbr;
	private String msisdn;
	private String acctNbr;
	private String subsPlan;
	private String creator;
	private String channel;
	private String event;
	private String state;
	private String created_date;
	private String completed_date;
	
	public Order(String orderNbr, String msisdn, String acctNbr, String subsPlan, String creator, String channel,
			String event, String state, String created_date, String completed_date) {
		super();
		this.orderNbr = orderNbr;
		this.msisdn = msisdn;
		this.acctNbr = acctNbr;
		this.subsPlan = subsPlan;
		this.creator = creator;
		this.channel = channel;
		this.event = event;
		this.state = state;
		this.created_date = created_date;
		this.completed_date = completed_date;
	}

	public String getOrderNbr() {
		return orderNbr;
	}

	public void setOrderNbr(String orderNbr) {
		this.orderNbr = orderNbr;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getAcctNbr() {
		return acctNbr;
	}

	public void setAcctNbr(String acctNbr) {
		this.acctNbr = acctNbr;
	}

	public String getSubsPlan() {
		return subsPlan;
	}

	public void setSubsPlan(String subsPlan) {
		this.subsPlan = subsPlan;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getCompleted_date() {
		return completed_date;
	}

	public void setCompleted_date(String completed_date) {
		this.completed_date = completed_date;
	}

	@Override
	public String toString() {
		return "Order [orderNbr=" + orderNbr + ", msisdn=" + msisdn + ", acctNbr=" + acctNbr + ", subsPlan=" + subsPlan
				+ ", creator=" + creator + ", channel=" + channel + ", event=" + event + ", state=" + state
				+ ", created_date=" + created_date + ", completed_date=" + completed_date + "]";
	}
	
	
	

}
