package com.dto;

import com.dao.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/verify")
public class VerifyEmail extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			
			boolean res= VerifyAC.verifyAc(email,password);
			if(res)
			{
//				PrintWriter pw= resp.getWriter();
//				pw.write("");
				HttpSession hs= req.getSession();
				hs.setAttribute("email", email);
				RequestDispatcher rd= req.getRequestDispatcher("access.jsp");
				rd.include(req, resp);
			}
			else {
//				PrintWriter pw= resp.getWriter();
//				pw.write("");
				RequestDispatcher rd= req.getRequestDispatcher("not1.jsp");
				rd.include(req, resp);
			}
	}
}
