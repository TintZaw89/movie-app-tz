package com.entity;

public class AcctBook {
	
	private String createdDate;
	private String acctBookId;
	private String acctBookType;
	private String acctRes;
	private String preBalance;
	private String preSuttleBal;
	private String charge;
	private String afterSubtleBal;
	private String preExpDate;
	private String extendedDay;
	private String partyType;
	private String partyCode;
	private String contactChannel;
	private String adjustReason;
	private String voucher;
	private String bank;
	private String eventName;
	private String prodName;
	private String acctItmeType;
	
	public AcctBook(String createdDate, String acctBookId, String acctBookType, String acctRes, String preBalance,
			String preSuttleBal, String charge, String afterSubtleBal, String preExpDate, String extendedDay,
			String partyType, String partyCode, String contactChannel, String adjustReason, String voucher, String bank,
			String eventName, String prodName, String acctItmeType) {
		super();
		this.createdDate = createdDate;
		this.acctBookId = acctBookId;
		this.acctBookType = acctBookType;
		this.acctRes = acctRes;
		this.preBalance = preBalance;
		this.preSuttleBal = preSuttleBal;
		this.charge = charge;
		this.afterSubtleBal = afterSubtleBal;
		this.preExpDate = preExpDate;
		this.extendedDay = extendedDay;
		this.partyType = partyType;
		this.partyCode = partyCode;
		this.contactChannel = contactChannel;
		this.adjustReason = adjustReason;
		this.voucher = voucher;
		this.bank = bank;
		this.eventName = eventName;
		this.prodName = prodName;
		this.acctItmeType = acctItmeType;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getAcctBookId() {
		return acctBookId;
	}
	public void setAcctBookId(String acctBookId) {
		this.acctBookId = acctBookId;
	}
	public String getAcctBookType() {
		return acctBookType;
	}
	public void setAcctBookType(String acctBookType) {
		this.acctBookType = acctBookType;
	}
	public String getAcctRes() {
		return acctRes;
	}
	public void setAcctRes(String acctRes) {
		this.acctRes = acctRes;
	}
	public String getPreBalance() {
		return preBalance;
	}
	public void setPreBalance(String preBalance) {
		this.preBalance = preBalance;
	}
	public String getPreSuttleBal() {
		return preSuttleBal;
	}
	public void setPreSuttleBal(String preSuttleBal) {
		this.preSuttleBal = preSuttleBal;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getAfterSubtleBal() {
		return afterSubtleBal;
	}
	public void setAfterSubtleBal(String afterSubtleBal) {
		this.afterSubtleBal = afterSubtleBal;
	}
	public String getPreExpDate() {
		return preExpDate;
	}
	public void setPreExpDate(String preExpDate) {
		this.preExpDate = preExpDate;
	}
	public String getExtendedDay() {
		return extendedDay;
	}
	public void setExtendedDay(String extendedDay) {
		this.extendedDay = extendedDay;
	}
	public String getPartyType() {
		return partyType;
	}
	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}
	public String getPartyCode() {
		return partyCode;
	}
	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}
	public String getContactChannel() {
		return contactChannel;
	}
	public void setContactChannel(String contactChannel) {
		this.contactChannel = contactChannel;
	}
	public String getAdjustReason() {
		return adjustReason;
	}
	public void setAdjustReason(String adjustReason) {
		this.adjustReason = adjustReason;
	}
	public String getVoucher() {
		return voucher;
	}
	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getAcctItmeType() {
		return acctItmeType;
	}
	public void setAcctItmeType(String acctItmeType) {
		this.acctItmeType = acctItmeType;
	}
	@Override
	public String toString() {
		return "AcctBook [createdDate=" + createdDate + ", acctBookId=" + acctBookId + ", acctBookType=" + acctBookType
				+ ", acctRes=" + acctRes + ", preBalance=" + preBalance + ", preSuttleBal=" + preSuttleBal + ", charge="
				+ charge + ", afterSubtleBal=" + afterSubtleBal + ", preExpDate=" + preExpDate + ", extendedDay="
				+ extendedDay + ", partyType=" + partyType + ", partyCode=" + partyCode + ", contactChannel="
				+ contactChannel + ", adjustReason=" + adjustReason + ", voucher=" + voucher + ", bank=" + bank
				+ ", eventName=" + eventName + ", prodName=" + prodName + ", acctItmeType=" + acctItmeType + "]";
	}

}
