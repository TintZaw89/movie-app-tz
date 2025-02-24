package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			//System.out.println(session.getAttribute("userobj"));
			session.removeAttribute("userobj");
			//System.out.println(session.getAttribute("userobj"));
			session.setAttribute("succMsg","Logout Successfully");
			resp.sendRedirect("login.jsp");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
		}
	}
	

}
