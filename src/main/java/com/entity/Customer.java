package com.entity;

public class Customer {

	private String customerId;
	private String customerCode;
	private String customerName;
	private String custType;
	private String certType;
	private String certNbr;
	private String firstPhone;
	private String firstMail;
	private String secondPhone;
	private String secondMail;
	private String address;
	private String grade;
	private String gender;
	private String birthday;
	private String brand;
	private String org;
	private String catg;
	
	public Customer(String customerId, String customerCode, String customerName, String custType, String certType,
			String certNbr, String firstPhone, String firstMail, String secondPhone, String secondMail, String address,
			String grade, String gender, String birthday, String brand, String org, String catg) {
		super();
		this.customerId = customerId;
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.custType = custType;
		this.certType = certType;
		this.certNbr = certNbr;
		this.firstPhone = firstPhone;
		this.firstMail = firstMail;
		this.secondPhone = secondPhone;
		this.secondMail = secondMail;
		this.address = address;
		this.grade = grade;
		this.gender = gender;
		this.birthday = birthday;
		this.brand = brand;
		this.org = org;
		this.catg = catg;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getCertType() {
		return certType;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
	public String getCertNbr() {
		return certNbr;
	}
	public void setCertNbr(String certNbr) {
		this.certNbr = certNbr;
	}
	public String getFirstPhone() {
		return firstPhone;
	}
	public void setFirstPhone(String firstPhone) {
		this.firstPhone = firstPhone;
	}
	public String getFirstMail() {
		return firstMail;
	}
	public void setFirstMail(String firstMail) {
		this.firstMail = firstMail;
	}
	public String getSecondPhone() {
		return secondPhone;
	}
	public void setSecondPhone(String secondPhone) {
		this.secondPhone = secondPhone;
	}
	public String getSecondMail() {
		return secondMail;
	}
	public void setSecondMail(String secondMail) {
		this.secondMail = secondMail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getCatg() {
		return catg;
	}
	public void setCatg(String catg) {
		this.catg = catg;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerCode=" + customerCode + ", customerName="
				+ customerName + ", custType=" + custType + ", certType=" + certType + ", certNbr=" + certNbr
				+ ", firstPhone=" + firstPhone + ", firstMail=" + firstMail + ", secondPhone=" + secondPhone
				+ ", secondMail=" + secondMail + ", address=" + address + ", grade=" + grade + ", gender=" + gender
				+ ", birthday=" + birthday + ", brand=" + brand + ", org=" + org + ", catg=" + catg + "]";
	}
	
	
}
