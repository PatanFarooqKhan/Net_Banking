package com.dto;

import java.io.IOException;

import javax.persistence.Query;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.hibernate.query.Query;
@WebServlet("/create")
public class CreateAC extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		long ac=Long.parseLong(req.getParameter("ac"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		int age=Integer.parseInt(req.getParameter("age"));
		long phone=Long.parseLong(req.getParameter("phone"));
		
		boolean res= com.dao.CreateAC.saveData(name,email,password,age,phone); //calling a dao "method()".
//		PrintWriter pw= resp.getWriter();
		if (res) {
//			pw.write("CREATING ACCOUNT IS DON");
			RequestDispatcher rd= req.getRequestDispatcher("done.jsp");
			rd.include(req, resp);
		}
		else {
//			pw.write("ACCOUNT IS NOT CREATED");
			RequestDispatcher rd= req.getRequestDispatcher("not.jsp");
			rd.include(req, resp);
		}
		
			
//		System.out.println(findLost());
	}
//	public long findLost()
//	{
//		EntityManagerFactory emf= Persistence.createEntityManagerFactory("vikas");
//		EntityManager em= emf.createEntityManager();
//		EntityTransaction et= em.getTransaction();
//		
//		String hql="SELECT ac FROM bankapp";
//		
//		Query q= em.createQuery(hql);
////		long ac=(long) q.getSingleResult();
//		List<Object> ac=q.getResultList();
//		System.out.println(ac);
//		return 9;
//		
//	}
}
