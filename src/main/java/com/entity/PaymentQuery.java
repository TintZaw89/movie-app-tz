package com.entity;

public class PaymentQuery {
	private String msisdn;
	private String transId;
	private String invNbr;
	private String paymentDate;
	private String amount;
	private String paymentMethod;
	private String reversedTransId;
	private String contactChannel;
	private String staffCode;
	private String balBefore;
	private String balAfter;
	private String refundReason;
	private String acctId;
	
	public PaymentQuery(String msisdn, String transId, String invNbr, String paymentDate, String amount,
			String paymentMethod, String reversedTransId, String contactChannel, String staffCode, String balBefore,
			String balAfter, String refundReason, String acctId) {
		super();
		this.msisdn = msisdn;
		this.transId = transId;
		this.invNbr = invNbr;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.reversedTransId = reversedTransId;
		this.contactChannel = contactChannel;
		this.staffCode = staffCode;
		this.balBefore = balBefore;
		this.balAfter = balAfter;
		this.refundReason = refundReason;
		this.acctId = acctId;	
		}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getInvNbr() {
		return invNbr;
	}

	public void setInvNbr(String invNbr) {
		this.invNbr = invNbr;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getReversedTransId() {
		return reversedTransId;
	}

	public void setReversedTransId(String reversedTransId) {
		this.reversedTransId = reversedTransId;
	}

	public String getContactChannel() {
		return contactChannel;
	}

	public void setContactChannel(String contactChannel) {
		this.contactChannel = contactChannel;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getBalBefore() {
		return balBefore;
	}

	public void setBalBefore(String balBefore) {
		this.balBefore = balBefore;
	}

	public String getBalAfter() {
		return balAfter;
	}

	public void setBalAfter(String balAfter) {
		this.balAfter = balAfter;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	
	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}


	@Override
	public String toString() {
		return "PaymentQuery [msisdn=" + msisdn + ", transId=" + transId + ", invNbr=" + invNbr + ", paymentDate="
				+ paymentDate + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", reversedTransId="
				+ reversedTransId + ", contactChannel=" + contactChannel + ", staffCode=" + staffCode + ", balBefore="
				+ balBefore + ", balAfter=" + balAfter + ", refundReason=" + refundReason + ", acctId=" + acctId + "]";
	}
	
}
