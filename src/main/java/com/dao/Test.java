package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		
	
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vikas");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		String hql="SELECT MAX(ac) FROM bank_app.bankapp";
		
		javax.persistence.Query q= em.createQuery(hql);
		int l= q.getMaxResults();
		System.out.println(l);
	
		
	}
}
