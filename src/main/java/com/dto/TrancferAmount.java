package com.dto;


import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/trancefer")
public class TrancferAmount extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String name=req.getParameter("name");
		String emailHolder=req.getParameter("Holderemail");
		boolean b= com.dao.VerifyAC.verifyEmail(emailHolder);
	
		double amount=Double.parseDouble(req.getParameter("amount"));
		if(b)
		  {
			HttpSession hs= req.getSession();
			String email= (String) hs.getAttribute("email");
		   // System.out.println(email);
			boolean res= com.dao.TrancferAmount.trancfer(email,amount,emailHolder);
//			System.out.println(res);
			if(res)
				{
					PrintWriter pw= resp.getWriter();
					pw.write("<h1>TRANCECTION SUCCESS FULL</h1>");
					RequestDispatcher rd= req.getRequestDispatcher("access.jsp");
					rd.include(req, resp);
				}
			else 
				{
					PrintWriter pw= resp.getWriter();
					pw.write("<h1>TRANCECTION FIELD</h1>");
					RequestDispatcher rd= req.getRequestDispatcher("access.jsp");
					rd.include(req, resp);
				}
	     }
		else 
		{
			PrintWriter pw= resp.getWriter();
			pw.write("<h1>HOLDER EMAIL IS MISS MACH OR NOT AVALABULE</h1>");
		 	RequestDispatcher rd= req.getRequestDispatcher("access.jsp");
		 	rd.include(req, resp);
		}
	}
}
