package com.cg.pwa.service;

import com.cg.pwa.bean.BankDetails;
import com.cg.pwa.bean.CustomerDetails;
import com.cg.pwa.dao.BankDao;
import com.cg.pwa.dao.BankDaoImpl;
import com.cg.pwa.exception.BankException;

public class BankServiceImpl implements BankService{

	@Override
	public int createAccount(CustomerDetails cd,BankDetails bank) throws BankException {
		BankDaoImpl bankdao=new BankDaoImpl();
		return bankdao.createAccount(cd,bank);
	}
	@Override
	public BankDetails showBalance(int cusAccNum) throws BankException {
		
		BankDaoImpl bankdao=new BankDaoImpl();
		return bankdao.showBalance(cusAccNum);
	}
	@Override
	public void deposit(int cusAccNum, int bal) throws BankException 
	{
		BankDaoImpl bankdao=new BankDaoImpl();
		 bankdao.deposit(cusAccNum, bal);
		
	}
	
	
	@Override
	public void withdraw(int cusAccNum, int bal) throws BankException {
		BankDao bankdao=new BankDaoImpl();
		bankdao.withdraw(cusAccNum, bal);
	}
	
	@Override
	public void fundTransfer(int AccNum,int transferAccNum, int bal) throws BankException {
		BankDao bankdao=new BankDaoImpl();
		 bankdao.fundTransfer(AccNum, transferAccNum, bal);
	}
	@Override
	public void printTransaction(int accNum) throws BankException {
		BankDao bankdao=new BankDaoImpl();
		bankdao.printTransaction(accNum);
		
	}
	


}
