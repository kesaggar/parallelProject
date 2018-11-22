package com.cg.pwa.service;

import com.cg.pwa.bean.BankDetails;
import com.cg.pwa.bean.CustomerDetails;
import com.cg.pwa.dao.BankDao;
import com.cg.pwa.dao.BankDaoImpl;
import com.cg.pwa.exception.BankException;

public class BankServiceImpl implements BankService{
BankDao bankdao=null;
	@Override
	public int createAccount(CustomerDetails cd,BankDetails bank) throws BankException {
		bankdao=new BankDaoImpl();
		return bankdao.createAccount(cd,bank);
	}
	@Override
	public BankDetails showBalance(int cusAccNum) throws BankException {
		bankdao=new BankDaoImpl();
		return bankdao.showBalance(cusAccNum);
	}
	@Override
	public BankDetails deposit(int cusAccNum, int bal) throws BankException 
	{
		return bankdao.deposit(cusAccNum, bal);
		
	}
	@Override
	public BankDetails withdraw(int cusAccNum, int bal) throws BankException {
		return bankdao.withdraw(cusAccNum, bal);
	}
	@Override
	public BankDetails fundTransfer(int AccNum,int transferAccNum, int bal) throws BankException {
		return bankdao.fundTransfer(AccNum, transferAccNum, bal);
	}
	


}
