package com.user.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.MovieDAOImpl;
import com.DB.DBConnect;
import com.entity.MovieDtls;

@WebServlet("/sell_movie")
@MultipartConfig
public class AddOldMovie extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String movieName = req.getParameter("mname");

			String author = req.getParameter("author");

			String price = req.getParameter("price");

			String categories = "Old";

			String status = "Active";

			Part part = req.getPart("mimg");

			String fileName = part.getSubmittedFileName();
			
			String userEmail = req.getParameter("user");
			
			String genre = req.getParameter("genre");
			
			String year = req.getParameter("year");
			
			String video = req.getParameter("video");
			
			int quantity = 1;

			MovieDtls m = new MovieDtls(movieName, author, price, categories, status, fileName, userEmail, genre, year, video, quantity);

			MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
			
			
			boolean b = dao.addMovies(m);

			HttpSession session = req.getSession();

			if (b)

			{
				String path = getServletContext().getRealPath("") + "movie";
				
				System.out.println(path);

				File f = new File(path);

				part.write(path + File.separator + fileName);

				session.setAttribute("succMsg", "Movie Sell Sucessfully");

				resp.sendRedirect("sell_movie.jsp");

			} else {

				session.setAttribute("failedMsg", "Something wrong on Server");

				resp.sendRedirect("sell_movie.jsp");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
