package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MovieDAOImpl;
import com.DB.DBConnect;

@WebServlet("/delete_old")
public class DeleteOldMovie extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		int id = Integer.parseInt(req.getParameter("id"));
		
		MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());

		boolean f = dao.deleteMovies(id);

		HttpSession session = req.getSession();

		if (f)

		{

			session.setAttribute("succMsg", "Movie Delete Successfully..");

			resp.sendRedirect("old_movie.jsp");

		} else {

			session.setAttribute("failedMsg", "Something wrong on server..");

			resp.sendRedirect("old_movie.jsp");

		}
		
	} catch (Exception e) {

		e.printStackTrace();

	}
		
	}
}
