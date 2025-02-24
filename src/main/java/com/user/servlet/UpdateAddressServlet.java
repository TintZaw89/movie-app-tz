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

@WebServlet("/update_address")
public class UpdateAddressServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pincode = req.getParameter("pincode");
			int id = Integer.parseInt(req.getParameter("id")) ;
			// System.out.println(name+" "+email+" "+phno+" "+password+" "+check);

			HttpSession session = req.getSession();

			User us = new User();
			us.setAddress(address);
			us.setLandmark(landmark);
			us.setCity(city);
			us.setState(state);
			us.setPincode(pincode);
			us.setId(id);
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
			boolean f = dao.updateAddress(us);
			if (f) {
				// System.out.println("User Register Success..");
				session.setAttribute("succMsg", "Address Update Successfully");
				resp.sendRedirect("user_address.jsp");
			} else {
				// System.out.println("Something wrong on server..");
				session.setAttribute("failedMsg", "Something wrong on server..");
				resp.sendRedirect("user_address.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
