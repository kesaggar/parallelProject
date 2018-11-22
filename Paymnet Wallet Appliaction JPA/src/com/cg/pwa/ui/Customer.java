package com.cg.pwa.ui;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.pwa.bean.BankDetails;
import com.cg.pwa.bean.CustomerDetails;
import com.cg.pwa.exception.BankException;
import com.cg.pwa.service.BankService;
import com.cg.pwa.service.BankServiceImpl;
import com.cg.pwa.util.DBUtil;

public class Customer {
static Scanner sc=null;
static int choice=0;
	public static void main(String[] args) throws BankException {

		
		sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("PAYMENT WALLET APPLICATION");
			System.out.println("Choose an operation");
			System.out.println("1. Create Account");
			System.out.println("2. Show Balance");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Print Transactions");
			System.out.println("0. Exit from Banking Application");
			choice=sc.nextInt();
			performOperation(choice);
			
		}
	}
	private static void performOperation(int choice) throws BankException {
		switch(choice)
		{
		case 1:createAccount();break;
		case 2:showBalance();break;
		case 3:deposit();break;
		case 4:withdraw();break;
		case 5:fundTransfer();break;
		case 6:printTransaction();break;
		default :exitSystem();break;
		}
	}
	private static void exitSystem() {
		System.out.println("-------------------------------");
		System.out.println("Thank you!! For Banking With us");
		System.out.println("-------------------------------");
		System.exit(0);
		
	}
	private static void printTransaction() throws BankException 
	{
		System.out.println("Enter the Account Number to print Transaction Details");
		int accNum=sc.nextInt();
		BankService ser=new BankServiceImpl();
		ser.printTransaction(accNum);
	}
	
	
	private static void fundTransfer() throws BankException {
		int count=0;
		System.out.println("Enter the Account Number for transferring money");
		int transferAccNum=sc.nextInt();
		System.out.println("Enter your Account Number");
		int AccNum=sc.nextInt();
		System.out.println("Enter the Amount you want to transfer");
		int transferBal=sc.nextInt();
		BankService ser=new BankServiceImpl();
		ser.fundTransfer(AccNum, transferAccNum, transferBal);

	}
	
private static void withdraw() throws BankException {
		System.out.println("Enter The Amount you want to Withdraw");
		int depBal=sc.nextInt();
		System.out.println("Enter The Account Number");
		int cusAccNo=sc.nextInt();
		BankService ser=new BankServiceImpl();
		ser.withdraw(cusAccNo, depBal);
		
	}
	
	
	private static void deposit() throws BankException {
		System.out.println("Enter The Amount you want to deposit");
		int depBal=sc.nextInt();
		System.out.println("Enter The Account Number");
		int cusAccNo=sc.nextInt();
		BankServiceImpl ser=new BankServiceImpl();
		ser.deposit(cusAccNo, depBal);
		
	}
	private static void showBalance() throws BankException {
		System.out.println("Enter your Account Number");
		int findBalAccountnum=sc.nextInt();
		BankServiceImpl impl=new BankServiceImpl();
		BankDetails bal=impl.showBalance(findBalAccountnum);
		
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA-PU");
	      EntityManager entitymanager = emfactory.createEntityManager();
	     int custID= bal.getCusDetails();
	      CustomerDetails customer=entitymanager.find(CustomerDetails.class,custID );
	  
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Hello "+" "+customer.getCusName()+" Your Balance for Account Number: "+bal.getAccNum()+" is Rs. "+bal.getCusBal());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	}
	private static void createAccount() throws BankException {
		System.out.println("---------welcome----------");
		Random rs=new Random();
		int customerId=rs.nextInt(100000);
		System.out.println("Enter customer name");
		String cusName=sc.next();
		System.out.println("Enter customer age");
		int cusAge=sc.nextInt();
		System.out.println("Enter customer Address");
		String cusAddress=sc.next();
		System.out.println("Enter customer Gender");
		String cusGender=sc.next();
		System.out.println("Enter customer City");
		String cusCity=sc.next();
		CustomerDetails cd=new CustomerDetails(customerId,cusName,cusAge,cusAddress,cusGender,cusCity);
	   
	    
	    
		Random r=new Random();
		int accNum=r.nextInt(100000);
		System.out.println("Enter customer Balance");
		int cusBal=sc.nextInt();
		BankDetails bank=new BankDetails(accNum,cusBal,customerId);
		BankServiceImpl ser=new BankServiceImpl();
		  int accNumber=ser.createAccount(cd,bank);
		  System.out.println("---------------------------------------------------------------------------------------------------");
		  System.out.println("Hello "+cd.getCusName()+" Your account has been succesfully created with Account Number: "+accNumber);
		  System.out.println("---------------------------------------------------------------------------------------------------");
	
	}

}
