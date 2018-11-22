package com.cg.pwa.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankDetails {
	@Id
	
int accNum;
public BankDetails() {
		super();
	}
int cusBal;
int cusId;
public BankDetails(int accNum, int cusBal, int cusId) {
	super();
	
	this.accNum = accNum;
	this.cusBal = cusBal;
	this.cusId = cusId;
}

public int getCusDetails() {
	return cusId;
}

public void setCusDetails(int cusId) {
	this.cusId = cusId;
}

@Override
public String toString() {
	return "BankDetails [accNum=" + accNum + ", cusBal=" + cusBal
			+ ", cusId=" + cusId + "]";
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
