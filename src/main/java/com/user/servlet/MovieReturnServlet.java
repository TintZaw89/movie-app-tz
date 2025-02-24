package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.MovieDAOImpl;
import com.DAO.MovieOrderDAOImpl;
import com.DB.DBConnect;
import com.entity.MovieDtls;

@WebServlet("/return")
public class MovieReturnServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userid=Integer.parseInt(req.getParameter("uid"));
		int movieid=Integer.parseInt(req.getParameter("mid"));
		
		MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
		
		MovieDtls m = dao.getMovieById(movieid);
		
		int price = Integer.parseInt(m.getPrice()) ;
		
		//System.out.println(userid + ", " + movieid + ", " + price);

		MovieOrderDAOImpl dao2=new MovieOrderDAOImpl(DBConnect.getConn());

		boolean b=dao2.retunMovie(userid, movieid, price);

		HttpSession session=req.getSession();

		if(b)

		{

		session.setAttribute("succMsg", "Movie Return Successfully");

		resp.sendRedirect("my_movie.jsp");

		}else {

		session.setAttribute("failedMsg", "Something wrong on server");

		resp.sendRedirect("my_movie.jsp");

		}

		}
	
}
