package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = "";
		try {
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			HttpSession session = req.getSession();
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String check=req.getParameter("check");
			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
			User us = new User();
			us.setName("Admin");
			us.setEmail("admin@gmail.com");
			session.setAttribute("userobj", us);
			page = "admin/home.jsp";
			//resp.sendRedirect("admin/home.jsp");
			}
			else {
			User us = dao.login(email, password);
			if (us != null) {
			session.setAttribute("userobj", us); 
			page = "index.jsp";
			//resp.sendRedirect ("index.jsp");
			} else {
			session.setAttribute("failedMsg", "Email & Password Invalid");
			page = "login.jsp";
			//resp.sendRedirect ("login.jsp");
			}
			//resp.sendRedirect("home.jsp");
			}
			
			if (check != null) {
				page = "bss/index.jsp";
			}
			/* HttpSession session = req.getSession();
			
			if (check != null)
			{
				User us=new User(); 
				us.setName(name);
				us.setEmail(email);
				us.setPhno(phno);
				us.setPassword(password) ;
				UserDAOImpl dao=new UserDAOImpl(DBConnect.getConn());
				boolean f=dao.userRegister(us);
				if(f)
				{
				//System.out.println("User Register Success..");
					session.setAttribute("SuccMsg", "Registration Successfully");
					resp.sendRedirect("register.jsp");
				}
				else {
				//System.out.println("Something wrong on server..");
					session.setAttribute("FailMsg", "Something wrong on server..");
					resp.sendRedirect("register.jsp");
				}
			}
			else {
				//System.out.println("Please check Agree terms & Conditions");
				session.setAttribute("FailMsg", "Please check Agree terms & Conditions");
				resp.sendRedirect("register.jsp");
			}
			
			 */
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			resp.sendRedirect(page);
		}
		
	}
	
}
