package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dto.AccountHolders;

public class VerifyAC {

	public static boolean verifyAc(String email,String password)
	{
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vikas");
		EntityManager em= emf.createEntityManager();
		
		AccountHolders b= em.find(AccountHolders.class, email);
		
		if(b!=null)
		{
			String pwd= b.getPassword();
			if(password.equals(pwd))
			{
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public static boolean verifyEmail(String email)
	{
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vikas");
		EntityManager em= emf.createEntityManager();
		
		AccountHolders b= em.find(AccountHolders.class, email);
		
		if(b!=null) return true;
//		{
//			String eml= b.getEmail();
//			if(email.equals(eml))
//			{
//				return true;
//			}
//			else return false;
//		}
		else return false;
	}
	
}
