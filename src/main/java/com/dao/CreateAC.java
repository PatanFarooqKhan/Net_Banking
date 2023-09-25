package com.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

import com.dto.AccountHolders;


public class CreateAC {

	public static boolean saveData(String name,String email,String password,int age,long phone){
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vikas");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		com.dto.AccountHolders cac=new AccountHolders();

		cac.setName(name);
		cac.setEmail(email);
		cac.setPassword(password);
		cac.setAge(age);
		cac.setPhone(phone);
		try {
			et.begin();
			em.persist(cac);
			et.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
