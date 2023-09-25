package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.dto.DipositClass;
import com.dto.Transactions ;

public class TrancferAmount {

	public static boolean trancfer(String email,double amount,String emailHolder)
	{
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vikas");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		try {
		DipositClass dc= em.find(DipositClass.class, email);
		if(dc!=null)
		{
			double amount1= dc.getAmount();
			if(amount<=amount1) 
			  {
				Transactions  tc=new Transactions ();
			    tc.setAmont(amount);
			    tc.setEmail(email);
			    tc.setTrancefarec_email(emailHolder);
			
	//		DipositClass dc2=new DipositClass();
	//		double a=amount1-amount;
	//		dc2.setAmount(a);
			
				et.begin();
				em.persist(tc);
	//			em.persist(dc2);
				et.commit();
				em.close();
				return true;
			  }
		}
		}
		catch (Exception e) {		
			return false;
		}
		return false;
	}
}
