package com.cg.pwa.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerDetails {
	public CustomerDetails() {
		super();
	}

	@Id
	
	private int customerId;

	private String cusName;
	private int cusAge;
	private String cusAddress;
	private String cusGender;
	private String cusCity;
	
	@Override
	public String toString() {
		return "CustomerDetails [customerId=" + customerId + ", cusName="
				+ cusName + ", cusAge=" + cusAge + ", cusAddress=" + cusAddress
				+ ", cusGender=" + cusGender + ", cusCity=" + cusCity + "]";
	}
	
	public CustomerDetails(int customerId, String cusName, int cusAge,
			String cusAddress, String cusGender, String cusCity) {
		super();
		this.customerId = customerId;
		this.cusName = cusName;
		this.cusAge = cusAge;
		this.cusAddress = cusAddress;
		this.cusGender = cusGender;
		this.cusCity = cusCity;
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
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
	


