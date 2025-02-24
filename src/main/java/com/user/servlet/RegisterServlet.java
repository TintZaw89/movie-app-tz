package com.user.servlet;

import javax.mail.internet.InternetAddress;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.DBConnect;
import com.entity.User;
import com.DAO.UserDAOImpl;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = "register.jsp";
	try {
		HttpSession session = req.getSession();
		String name=req.getParameter("fname");
		String email=req.getParameter("email");
	    try {
	        InternetAddress internetAddress = new InternetAddress(email);
	        internetAddress.validate();
	        session.setAttribute("succMsg", "Email is Valid");
	    } catch (Exception e) {
	    	session.setAttribute("failedMsg", "Email is invalid!");
	    }
		String phno=req.getParameter("phno") ;
		String password=req.getParameter("password");
		int age=Integer.parseInt(req.getParameter("age")) ;
		String check=req.getParameter("check");
		//System.out.println(name+" "+email+" "+phno+" "+password+" "+check);
		
		if (check != null)
		{
			UserDAOImpl dao2=new UserDAOImpl(DBConnect.getConn());
			boolean b = dao2.checkUser(email);
			if (b == false)
			{
				session.setAttribute("failedMsg", "User with email id already exist!");
				//resp.sendRedirect("register.jsp");
			}
			else
			{
				User us=new User(); 
				us.setName(name);
				us.setEmail(email);
				us.setPhno(phno);
				us.setPassword(password) ;
				us.setAge(age);
				UserDAOImpl dao=new UserDAOImpl(DBConnect.getConn());
				boolean f=dao.userRegister(us);
				if(f)
				{
				//System.out.println("User Register Success..");
					session.setAttribute("succMsg", "Registration Successfully");
					//resp.sendRedirect("register.jsp");
				}
				else {
				//System.out.println("Something wrong on server..");
					session.setAttribute("failedMsg", "Something wrong on server..");
					//resp.sendRedirect("register.jsp");
				}
			}
		
		}
		else {
			//System.out.println("Please check Agree terms & Conditions");
			session.setAttribute("failedMsg", "Please check Agree terms & Conditions");
			//resp.sendRedirect("register.jsp");
		}
		
		
		
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		resp.sendRedirect(page);
	}
	
	}
}
