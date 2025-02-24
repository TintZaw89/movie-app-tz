package com.user.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.MovieDAOImpl;
import com.DB.DBConnect;
import com.entity.Cart;
import com.entity.MovieDtls;

@WebServlet("/cart")
public class CardServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
				int movieId = Integer.parseInt(req.getParameter("mid"));
				int userId = Integer.parseInt(req.getParameter("uid"));
				String page = req.getParameter("pid").toString() + ".jsp";
				
				//System.out.println(movieId +", " + userId + ", " + page);

				MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
				
				MovieDtls m =dao.getMovieById(movieId);
				
				Cart c=new Cart();

				c.setMovieId(movieId);

				c.setUserId(userId);

				c.setMovieName(m.getMovieName());

				c.setDirector(m.getDirector());

				c.setPrice(Double.parseDouble(m.getPrice()));

				c.setTotalPrice(Double.parseDouble(m.getPrice()));
				
				HttpSession session = req.getSession();

				CartDAOImpl dao2=new CartDAOImpl(DBConnect.getConn());
				
				boolean b = dao2.checkCartByMovie(movieId);
				//System.out.println(b);
				
				if (!b) {
					session.setAttribute("failedMsg","Out of Stock [" + m.getMovieName() + "]");
					resp.sendRedirect(page);
				} 
				
				else {
					boolean f=dao2.addCart(c);
					
					if(f)

					{
						session.setAttribute("addCart","Movie added to Cart");
						resp.sendRedirect(page);

					}else {

						session.setAttribute("failedMsg","Something wrong on server");
						resp.sendRedirect(page);
					}
					//resp.sendRedirect("home.jsp");
					
				}

				

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	

}
