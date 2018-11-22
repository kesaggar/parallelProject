package com.cg.pwa.dao;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import com.cg.pwa.bean.BankDetails;
import com.cg.pwa.bean.CustomerDetails;
import com.cg.pwa.bean.Transactions;
import com.cg.pwa.exception.BankException;
import com.cg.pwa.util.DBUtil;

public class BankDaoImpl implements BankDao {

	@Override
	public int createAccount(CustomerDetails cd,BankDetails bank) throws BankException {
		DBUtil.createAccount(cd);
		return DBUtil.customerBankDetails(bank);
	}

	@Override
	public BankDetails showBalance(int cusAccNum) throws BankException {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA-PU");
		
	      EntityManager entitymanager = emfactory.createEntityManager();
	      
	      BankDetails bank=entitymanager.find(BankDetails.class, cusAccNum);
	     
	      return bank;
	     
	}

	@Override
	public void deposit(int cusAccNum, int bal) throws BankException {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA-PU");
	      EntityManager entitymanager = emfactory.createEntityManager();
	      entitymanager.getTransaction().begin();
	      BankDetails bank=entitymanager.find(BankDetails.class, cusAccNum);
	      
	      bank.setCusBal(bank.getCusBal()+bal);
	      CustomerDetails customer= entitymanager.find(CustomerDetails.class, bank.getCusDetails());
	      Transactions trans=new Transactions();
	      trans.setAccNum(cusAccNum);
	      trans.setDepositBalance(bal);
	      trans.setTransactionType("Deposit");
	      entitymanager.merge(trans);
	      entitymanager.getTransaction().commit();
	      System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
	      System.out.println("Hello "+customer.getCusName()+" balance of amount "+bal+" Has been sucessfully credited to your account "+"Current Balance "+bank.getCusBal());
	      System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
	      
	      emfactory.close();
	      entitymanager.close();
	}

	@Override
	public void withdraw(int cusAccNum, int bal) throws BankException {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA-PU");
	      EntityManager entitymanager = emfactory.createEntityManager();
	      entitymanager.getTransaction().begin();
	      BankDetails bank=entitymanager.find(BankDetails.class, cusAccNum);
	      
	      bank.setCusBal(bank.getCusBal()-bal);
	      CustomerDetails customer= entitymanager.find(CustomerDetails.class, bank.getCusDetails());
	      Transactions trans=new Transactions();
	      trans.setAccNum(cusAccNum);
	      trans.setDepositBalance(bal);
	      trans.setTransactionType("Withdraw");
	      entitymanager.merge(trans);
	      entitymanager.getTransaction().commit();
	      System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
	      System.out.println("Hello "+customer.getCusName()+" balance of amount "+bal+" Has been sucessfully debited from your account "+"Current Balance "+bank.getCusBal());
	      System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
	}

	@Override
	public void fundTransfer(int AccNum,int transferAccNum, int bal) throws BankException {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA-PU");
		  EntityManager entitymanager = emfactory.createEntityManager();
	      entitymanager.getTransaction().begin();
	      BankDetails cusBank=entitymanager.find(BankDetails.class, transferAccNum);
	      BankDetails mybank=entitymanager.find(BankDetails.class, AccNum);
	      mybank.setCusBal(mybank.getCusBal()-bal);
	      cusBank.setCusBal(cusBank.getCusBal()+bal);
	      CustomerDetails debitCutsomer=entitymanager.find(CustomerDetails.class, mybank.getCusDetails());
	      CustomerDetails creditCutsomer=entitymanager.find(CustomerDetails.class, cusBank.getCusDetails());
	      Transactions trans=new Transactions();
	      trans.setAccNum(AccNum);
	      trans.setDepositBalance(bal);
	      trans.setTransactionType("Withdraw");
	      entitymanager.merge(trans);
	      Transactions trans1=new Transactions();
	      trans1.setAccNum(transferAccNum);
	      trans1.setDepositBalance(bal);
	      trans1.setTransactionType("Deposit");
	      entitymanager.merge(trans1);
	      entitymanager.getTransaction().commit();
	      System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
	      System.out.println("Hello "+debitCutsomer.getCusName()+" Amount of Rs."+bal+" Has been succesfully transfered to "+creditCutsomer.getCusName()+" Available Balance:"+mybank.getCusBal());
	      System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------"); 
		
	}

	@Override
	public void printTransaction(int accNum) throws BankException {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA-PU");
		EntityManager entitymanager = emfactory.createEntityManager();
	    entitymanager.getTransaction().begin();
	    Query query = entitymanager.createQuery( "from Transactions where accNum = ?" );
	    query.setParameter(1, accNum);
	    List<Transactions> list = (List<Transactions>)query.getResultList();
	    
	    Iterator<Transactions> it = list.iterator(); 
	    System.out.println("----------------------------------------------------");
	    System.out.println("TransactionId\t"
                + "TransactionType\t\tBalance");
	    System.out.println("----------------------------------------------------");
		while (it.hasNext()) {
			Transactions trans=it.next();
			 System.out.println(trans.getId() + "\t\t"
                     +trans.getTransactionType() + " \t\t" + trans.getDepositBalance());
		
	}
		System.out.println("----------------------------------------------------");

	

}
}
