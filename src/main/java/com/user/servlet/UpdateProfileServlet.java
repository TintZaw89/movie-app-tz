package com.user.servlet;

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

@WebServlet("/update_profile")
public class UpdateProfileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("fname");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String password = req.getParameter("password");
			int id = Integer.parseInt(req.getParameter("id")) ;
			// System.out.println(name+" "+email+" "+phno+" "+password+" "+check);

			HttpSession session = req.getSession();

			User us = new User();
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phno);
			us.setPassword(password);
			us.setId(id);
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			boolean f = dao.updateProfile(us);
			if (f) {
				// System.out.println("User Register Success..");
				session.setAttribute("succMsg", "Profile Update Successfully");
				resp.sendRedirect("edit_profile.jsp");
			} else {
				// System.out.println("Something wrong on server..");
				session.setAttribute("failedMsg", "Something wrong on server..");
				resp.sendRedirect("edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
