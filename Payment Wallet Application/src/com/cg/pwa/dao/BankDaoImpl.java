package com.cg.pwa.dao;

import java.util.List;

import com.cg.pwa.bean.BankDetails;
import com.cg.pwa.bean.CustomerDetails;
import com.cg.pwa.exception.BankException;
import com.cg.pwa.util.DBUtil;

public class BankDaoImpl implements BankDao {

	@Override
	public int createAccount(CustomerDetails cd,BankDetails bank) throws BankException {
		DBUtil.createAccount(cd);
		return DBUtil.getCustomerInfo(bank);
	}

	@Override
	public BankDetails showBalance(int cusAccNum) throws BankException {
		int count=0;
		List<BankDetails> getAccDetails=DBUtil.getAllBankAccount();
		for(int i=0;i<getAccDetails.size();i++)
		{
			BankDetails bankDetail=getAccDetails.get(i);
			if(bankDetail.getAccNum()==cusAccNum)
			{
				return bankDetail;
			}
			count=count+1;
		}
		if(count==getAccDetails.size())
		{
			throw new BankException("Sorry No Account Number Found!!");
		}
		return null;
		
	}

	@Override
	public BankDetails deposit(int cusAccNum, int bal) throws BankException {
		int count=0;
			List<BankDetails> depositAmount=DBUtil.getAllBankAccount();
			for(int i=0;i<depositAmount.size();i++)
			{
				BankDetails bankDetail=depositAmount.get(i);
				if(bankDetail.getAccNum()==cusAccNum)
				{
					
					bankDetail.setCusBal(bankDetail.getCusBal()+bal);
					return bankDetail;
				}
				count=count+1;
			}
			if(count==depositAmount.size())
			{
				throw new BankException("Sorry Account Number is incorrect or have not been associated with us!!");
			}
			return null;
			
		
	}

	@Override
	public BankDetails withdraw(int cusAccNum, int bal) throws BankException {
		int count=0;
		List<BankDetails> depositAmount=DBUtil.getAllBankAccount();
		for(int i=0;i<depositAmount.size();i++)
		{
			BankDetails bankDetail=depositAmount.get(i);
			if(bankDetail.getAccNum()==cusAccNum)
			{
			
				if(bal>bankDetail.getCusBal())
				{
					throw new BankException("Insufficient funds");
				}
				else
				{
				bankDetail.setCusBal(bankDetail.getCusBal()-bal);
				return bankDetail;
				}
				
				
			}
			count=count+1;
		}
		if(count==depositAmount.size())
		{
			throw new BankException("Sorry Account Number is incorrect or have not been associated with us!!");
		}
		return null;
	}

	@Override
	public BankDetails fundTransfer(int AccNum,int transferAccNum, int bal) throws BankException {
		int count=0;
		List<BankDetails> depositAmount=DBUtil.getAllBankAccount();
		for(int i=0;i<depositAmount.size();i++)
		{
			BankDetails bankDetail=depositAmount.get(i);
			if(bankDetail.getAccNum()==transferAccNum)
			{
				bankDetail.setCusBal(bankDetail.getCusBal()+bal);
				return bankDetail;
			}
			count=count+1;
		}
		if(count==depositAmount.size())
		{
			throw new BankException("Sorry Reciever Account Number is incorrect or have not been associated with us!!");
		}
		return null;
		
	}


	

}
