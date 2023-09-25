package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.dto.Transactions;


public class ViewTransactions {

	public static Transactions getAllTransactions(String email)
	{
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vikas");
		EntityManager em= emf.createEntityManager();
		
		Transactions t= em.find(Transactions.class, email);
		if(t==null)
		{
			return null;
		}
		return t;
		
//		String hql="SELECT * FROM transactions WHERE email='"+email+"'";
//		Query q= em.createQuery(hql);
//		
//		List l= q.getResultList();
//		return (ArrayList) l;
	}
}
