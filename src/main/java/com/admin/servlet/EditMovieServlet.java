package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MovieDAOImpl;
import com.DB.DBConnect;
import com.entity.MovieDtls;

@WebServlet("/edit_movies")
public class EditMovieServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			int id = Integer.parseInt(req.getParameter("id"));

			String movieName = req.getParameter("mname");

			String director = req.getParameter("author");

			String price = req.getParameter("price");

			String status = req.getParameter("status");
			
			int quantity = Integer.parseInt(req.getParameter("quantity"));

			MovieDtls m = new MovieDtls();

			m.setMovieId(id);

			m.setMovieName(movieName);

			m.setDirector(director);

			m.setPrice(price);

			m.setStatus(status);
			
			m.setQuantity(quantity);

			MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());

			boolean f = dao.editMovies(m);

			HttpSession session = req.getSession();

			if (f)

			{

				session.setAttribute("succMsg", "Movie Update Successfully");

				resp.sendRedirect("admin/all_movies.jsp");

			} else {

				session.setAttribute("failedMsg", "Something wrong on server");

				resp.sendRedirect("admin/edit_movies.jsp");

			}
		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
