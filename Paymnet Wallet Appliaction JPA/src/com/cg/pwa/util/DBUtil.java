package com.cg.pwa.util;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.pwa.bean.BankDetails;
import com.cg.pwa.bean.CustomerDetails;

public class DBUtil {
	
	public static void createAccount(CustomerDetails customer)
	{
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA-PU" );
	 EntityManager entitymanager = emfactory.createEntityManager( );
	 entitymanager.getTransaction().begin();
	 entitymanager.merge(customer);
	 entitymanager.getTransaction().commit();
	 entitymanager.close( );
     emfactory.close( );
	}
	public static int customerBankDetails(BankDetails bank)
	{
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "JPA-PU" );
	 EntityManager entitymanager = emfactory.createEntityManager( );
	 entitymanager.getTransaction().begin();
	 entitymanager.merge(bank);
	 entitymanager.getTransaction().commit();
	 emfactory.close( );
	 entitymanager.close( );
	 return bank.getAccNum();
	 
    
	}
}
