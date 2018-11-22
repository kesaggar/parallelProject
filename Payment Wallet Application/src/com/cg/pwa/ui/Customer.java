package com.cg.pwa.ui;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.cg.pwa.bean.BankDetails;
import com.cg.pwa.bean.CustomerDetails;
import com.cg.pwa.exception.BankException;
import com.cg.pwa.service.BankService;
import com.cg.pwa.service.BankServiceImpl;
import com.cg.pwa.util.DBUtil;

public class Customer {
static Scanner sc=null;
static int choice=0;
static BankService ser=null;
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
	}
	private static void fundTransfer() throws BankException {
		int count=0;
		System.out.println("Enter the Account Number for transferring money");
		int transferAccNum=sc.nextInt();
		System.out.println("Enter your Account Number");
		int AccNum=sc.nextInt();
		System.out.println("Enter the Amount you want to transfer");
		int transferBal=sc.nextInt();
		List<BankDetails> fetchData=DBUtil.getAllBankAccount();
		for(int p=0;p<fetchData.size();p++)
		{
			BankDetails cusSetBal=fetchData.get(p);
			if(cusSetBal.getAccNum()==AccNum)
			{
				if(cusSetBal.getCusBal()<transferBal)
				{
					throw new BankException("Sorry!! you do not have sufficient funds to transfer");
				}
				else
				{
					BankDetails tranferDetails=ser.fundTransfer(AccNum, transferAccNum, transferBal);
					
					cusSetBal.setCusBal(cusSetBal.getCusBal()-transferBal);
					System.out.println("--------------------------------------------------------------------------------------");
					System.out.println("Thank you!! Funds has been transferred to "+tranferDetails.getCusDetails().getCusName());
					System.out.println("--------------------------------------------------------------------------------------");
				    break;
				}
				
			}
			count=count+1;
			
		}
		if(count==fetchData.size())
		{
			throw new BankException("Sorry your Account Number is Incorrect or not Associated");
		}

	}
	private static void withdraw() throws BankException {
		System.out.println("Enter The Amount you want to Withdraw");
		int depBal=sc.nextInt();
		System.out.println("Enter The Account Number");
		int cusAccNo=sc.nextInt();
		BankDetails withAmt=ser.withdraw(cusAccNo, depBal);
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Hello "+withAmt.getCusDetails().getCusName()+" Rs."+depBal+" for Account Number: "+withAmt.getAccNum()+" "+" Has been debited. Available Balance: "+ withAmt.getCusBal());
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	private static void deposit() throws BankException {
		System.out.println("Enter The Amount you want to deposit");
		int depBal=sc.nextInt();
		System.out.println("Enter The Account Number");
		int cusAccNo=sc.nextInt();
		BankDetails accountNumber=ser.deposit(cusAccNo, depBal);
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Hello "+accountNumber.getCusDetails().getCusName()+" Rs. "+depBal+" for Account Number: "+accountNumber.getAccNum()+" has been deposited. Your Current Balance is "+accountNumber.getCusBal());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	private static void showBalance() throws BankException {
		System.out.println("Enter your Account Number");
		int findBal=sc.nextInt();
		BankDetails bal=ser.showBalance(findBal);
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Hello "+" "+bal.getCusDetails().getCusName()+" Your Balance for "+bal.getAccNum()+" Account Number is Rs. "+bal.getCusBal());
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
	}
	private static void createAccount() throws BankException {
		System.out.println("---------welcome----------");
		
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
		CustomerDetails cd=new CustomerDetails(cusName,cusAge,cusAddress,cusGender,cusCity);
	    ser=new BankServiceImpl();
	  
	    
	    
		Random r=new Random();
		int accNum=r.nextInt(100000);
		System.out.println("Enter customer Balance");
		int cusBal=sc.nextInt();
		BankDetails bank=new BankDetails(accNum,cusBal,cd);
		  int accNumber=ser.createAccount(cd,bank);
		  System.out.println("---------------------------------------------------------------------------------------------------");
		  System.out.println("Hello "+cd.getCusName()+" Your account has been succesfully created with Account Number: "+accNumber);
		  System.out.println("---------------------------------------------------------------------------------------------------");
	
	}

}
