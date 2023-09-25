package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dto.Diposit;
import com.dto.DipositClass;

public class ViewBalance {

	public static double Balance(String email)
	{
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vikas");
		EntityManager em= emf.createEntityManager();
		
		DipositClass d= em.find(DipositClass.class, email);
		if(d!=null) return d.getAmount();
		else return 0;
		
	}
}
