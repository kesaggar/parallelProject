package com.cg.pwa.bean;

public class CustomerDetails {
	private String cusName;
	private int cusAge;
	private String cusAddress;
	private String cusGender;
	private String cusCity;
	
	@Override
	public String toString() {
		return "CustomerDetails [cusName=" + cusName + ", cusAge=" + cusAge
				+ ", cusAddress=" + cusAddress + ", cusGender=" + cusGender
				+ ", cusCity=" + cusCity + "]";
	}
	
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public int getCusAge() {
		return cusAge;
	}
	public void setCusAge(int cusAge) {
		this.cusAge = cusAge;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	
	public String getCusGender() {
		return cusGender;
	}
	public void setCusGender(String cusGender) {
		this.cusGender = cusGender;
	}
	public String getCusCity() {
		return cusCity;
	}
	public void setCusCity(String cusCity) {
		this.cusCity = cusCity;
	}

	public CustomerDetails(String cusName, int cusAge, String cusAddress,
			String cusGender, String cusCity) {
		super();
		this.cusName = cusName;
		this.cusAge = cusAge;
		this.cusAddress = cusAddress;
		this.cusGender = cusGender;
		this.cusCity = cusCity;
	}
	

}
