package com.cg.pwa.bean;

public class BankDetails {
int accNum;
int cusBal;
CustomerDetails cusDetails;
public BankDetails(int accNum, int cusBal, CustomerDetails cusDetails) {
	super();
	this.accNum = accNum;
	this.cusBal = cusBal;
	this.cusDetails = cusDetails;
}

public CustomerDetails getCusDetails() {
	return cusDetails;
}

public void setCusDetails(CustomerDetails cusDetails) {
	this.cusDetails = cusDetails;
}

@Override
public String toString() {
	return "BankDetails [accNum=" + accNum + ", cusBal=" + cusBal
			+ ", cusDetails=" + cusDetails + "]";
}
public int getAccNum() {
	return accNum;
}
public void setAccNum(int accNum) {
	this.accNum = accNum;
}
public int getCusBal() {
	return cusBal;
}
public void setCusBal(int cusBal) {
	this.cusBal = cusBal;
}
}
