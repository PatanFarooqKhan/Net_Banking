package com.dto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ViewBalance;

@WebServlet("/view")
public class View extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs= req.getSession();
		String email= (String) hs.getAttribute("email");
		
		double balance= ViewBalance.Balance(email);
		
		PrintWriter pw= resp.getWriter();
		pw.write("<h1> YOUR BALANCE IS:- " + balance + " </h1");
		RequestDispatcher rd= req.getRequestDispatcher("access.jsp");
		rd.include(req, resp);
		
		
	}
}
