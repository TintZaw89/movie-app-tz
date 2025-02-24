package com.entity;

public class PaymentMethod {
	private String paymentMethodId;
	private String paymentMethodName;
	
	public PaymentMethod(String paymentMethodId, String paymentMethodName) {
		super();
		this.paymentMethodId = paymentMethodId;
		this.paymentMethodName = paymentMethodName;
	}

	public String getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentMethodName() {
		return paymentMethodName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	@Override
	public String toString() {
		return "PaymentMethod [paymentMethodId=" + paymentMethodId + ", paymentMethodName=" + paymentMethodName + "]";
	}
	
	
}
