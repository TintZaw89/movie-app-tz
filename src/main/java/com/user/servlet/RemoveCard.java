package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DB.DBConnect;

@WebServlet("/remove_card")
public class RemoveCard extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cardid=Integer.parseInt(req.getParameter("cid"));

		CartDAOImpl dao=new CartDAOImpl(DBConnect.getConn());

		boolean b=dao.removeCard(cardid);

		HttpSession session=req.getSession();

		if(b)

		{

		session.setAttribute("succMsg", "Movie Removed from Cart");

		resp.sendRedirect("cart.jsp");

		}else {

		session.setAttribute("failedMsg", "Something wrong on server");

		resp.sendRedirect("cart.jsp");

		}

		}
	
}
