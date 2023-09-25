package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.dto.DipositClass;

public class DipositDao {

	public static boolean diposit(double amount,String email)
	{
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vikas");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		DipositClass dc= em.find(DipositClass.class, email);
		DipositClass d=new DipositClass();
		if(dc==null)	
		{	
			d.setEmail(email);
			d.setAmount(amount);
			et.begin();
			em.persist(d);
			et.commit();
			return true;
		}
		else if(dc!=null) 
		{
			double amou= d.getAmount();
			double amount1=amount+amou;
			d.setAmount(amount1);
			d.setEmail(email);
			et.begin();
			em.merge(d);
			et.commit();
			return true;
		}
		return false;
	}
}
