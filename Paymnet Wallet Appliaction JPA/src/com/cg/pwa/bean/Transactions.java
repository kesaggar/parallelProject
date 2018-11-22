package com.cg.pwa.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transactions {
	
	@Id@GeneratedValue(strategy=GenerationType.AUTO) int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	int transactionId;
	int accNum;
	int depositBalance;
	String transactionType;


	@Override
	public String toString() {
		return "Transactions [id=" + id + ", transactionId=" + transactionId
				+ ", accNum=" + accNum + ", depositBalance=" + depositBalance
				+ ", transactionType=" + transactionType + "]";
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public int getDepositBalance() {
		return depositBalance;
	}
	public void setDepositBalance(int depositBalance) {
		this.depositBalance = depositBalance;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
}
