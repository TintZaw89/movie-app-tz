package com.entity;

public class Subscriber {
	private String subsNbr;
	private String subsName;
	private String simProfile;
	private String accountNbr;
	private String offer;
	private String mainProd;
	private String billCycle;
	private String lang;
	private String createdDate;
	private String activeDate;
	private String expDate;
	private String bal;
	private String quota;
	private String state;
	private String blockReason;
	private String city;
	private String township;
	private String address;
	private String subsId;
	private String acctId;
	
	public Subscriber(String subsNbr, String subsName, String simProfile, String accountNbr, String offer,
			String mainProd, String billCycle, String lang, String createdDate, String activeDate, String expDate,
			String bal, String quota, String state, String blockReason, String city, String township, String address,
			String subsId, String acctId) {
		super();
		this.subsNbr = subsNbr;
		this.subsName = subsName;
		this.simProfile = simProfile;
		this.accountNbr = accountNbr;
		this.offer = offer;
		this.mainProd = mainProd;
		this.billCycle = billCycle;
		this.lang = lang;
		this.createdDate = createdDate;
		this.activeDate = activeDate;
		this.expDate = expDate;
		this.bal = bal;
		this.quota = quota;
		this.state = state;
		this.blockReason = blockReason;
		this.city = city;
		this.township = township;
		this.address = address;
		this.subsId = subsId;
		this.acctId = acctId;
	}

	public String getSubsNbr() {
		return subsNbr;
	}

	public void setSubsNbr(String subsNbr) {
		this.subsNbr = subsNbr;
	}

	public String getSubsName() {
		return subsName;
	}

	public void setSubsName(String subsName) {
		this.subsName = subsName;
	}

	public String getSimProfile() {
		return simProfile;
	}

	public void setSimProfile(String simProfile) {
		this.simProfile = simProfile;
	}

	public String getAccountNbr() {
		return accountNbr;
	}

	public void setAccountNbr(String accountNbr) {
		this.accountNbr = accountNbr;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public String getMainProd() {
		return mainProd;
	}

	public void setMainProd(String mainProd) {
		this.mainProd = mainProd;
	}

	public String getBillCycle() {
		return billCycle;
	}

	public void setBillCycle(String billCycle) {
		this.billCycle = billCycle;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getBal() {
		return bal;
	}

	public void setBal(String bal) {
		this.bal = bal;
	}

	public String getQuota() {
		return quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBlockReason() {
		return blockReason;
	}

	public void setBlockReason(String blockReason) {
		this.blockReason = blockReason;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubsId() {
		return subsId;
	}

	public void setSubsId(String subsId) {
		this.subsId = subsId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	@Override
	public String toString() {
		return "Subscriber [subsNbr=" + subsNbr + ", subsName=" + subsName + ", simProfile=" + simProfile
				+ ", accountNbr=" + accountNbr + ", offer=" + offer + ", mainProd=" + mainProd + ", billCycle="
				+ billCycle + ", lang=" + lang + ", createdDate=" + createdDate + ", activeDate=" + activeDate
				+ ", expDate=" + expDate + ", bal=" + bal + ", quota=" + quota + ", state=" + state + ", blockReason="
				+ blockReason + ", city=" + city + ", township=" + township + ", address=" + address + ", subsId="
				+ subsId + ", acctId=" + acctId + "]";
	}
	

}
