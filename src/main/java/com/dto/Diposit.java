package com.dto;

import java.io.*;

import com.dao.DipositDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/diposit")
public class Diposit extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		double amount=Double.parseDouble(req.getParameter("amount"));
		HttpSession hs=req.getSession();
		String email= (String) hs.getAttribute("email");
		
		
		boolean res= DipositDao.diposit(amount,email);
		if(res)
		{
			PrintWriter pw= resp.getWriter();
			pw.write("<h1>DIPOSIT IS SUCCESS FULL</h1>");
		 	RequestDispatcher rd= req.getRequestDispatcher("access.jsp");
		 	rd.include(req, resp);
		}
		else 
		{
			PrintWriter pw= resp.getWriter();
			pw.write("<h1>style=color:red DIPOSIT IS NOT SUCCESS FULL</h1>");
		 	RequestDispatcher rd= req.getRequestDispatcher("access.jsp");
		 	rd.include(req, resp);
		}
	}
}
