package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.MovieOrderDAOImpl;
import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.Cart;
import com.entity.MovieOrder;
import com.entity.MovieOrderDtls;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = "index.jsp";
		boolean result = false;
		try {
			HttpSession session = req.getSession();

			int id = Integer.parseInt(req.getParameter("id"));
			
			//int cash = Integer.parseInt(req.getParameter("cash"));
			
			UserDAOImpl daoUser = new UserDAOImpl(DBConnect.getConn());
			
			int cash = daoUser.checkCash(id);
			
			double totalprice = Double.parseDouble(req.getParameter("totalprice"));
			
			//System.out.println(cash + "," + totalprice);

			String name = req.getParameter("username");

			String email = req.getParameter("email");

			String phno = req.getParameter("phno");

			String address = req.getParameter("address");

			String landmark = req.getParameter("landmark");

			String city = req.getParameter("city");

			String state = req.getParameter("state");

			String pincode = req.getParameter("pincode");

			String paymentType = req.getParameter("payment");

			String fullAdd = address + ", " + landmark + ", " + city + ", " + state + ", " + pincode;

			CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());

			List<Cart> clist = dao.getMovieById(id);

			if (clist.isEmpty()) {
				page = "cart.jsp";
				session.setAttribute("failedMsg", "No item in cart");
				resp.sendRedirect(page);
			}

			MovieOrderDAOImpl dao2 = new MovieOrderDAOImpl(DBConnect.getConn());

			MovieOrder m = null;

			MovieOrderDtls mod = null;

			ArrayList<MovieOrderDtls> orderList = new ArrayList<MovieOrderDtls>();

			//Random r = new Random();
			int lastOrderId = dao2.getLastOrderNo();
			// System.out.println(lastOrderId);

			m = new MovieOrder();

			String MovieorderId = "MOV-ORDR-" + id + "-" + Integer.toString(lastOrderId); // r.nextInt(1000);

			m.setOrderId(MovieorderId);

			m.setUserName(name);

			m.setEmail(email);

			m.setAddress(fullAdd);

			m.setPhone(phno);

			m.setPaymentType(paymentType);

			Double orderTotalPrice = 0.00;
			for (Cart c : clist) {

				mod = new MovieOrderDtls();
				mod.setOrderId(MovieorderId);
				mod.setCartId(c.getCartId());
				mod.setMovieName(c.getMovieName());
				mod.setDirector(c.getDirector());
				mod.setPrice(c.getPrice().toString());
				mod.setMovieid(c.getMovieId());
				mod.setUserid(c.getUserId());
				orderList.add(mod);
				orderTotalPrice = orderTotalPrice + c.getPrice();
			}
			if (totalprice > cash)
			{
				page = "cart.jsp";
				session.setAttribute("failedMsg", "Total price is more than cart balance!");
			}
			else {
				
				m.setTotalPrice(orderTotalPrice.toString());
				
				//int amount = Integer.parseInt(orderTotalPrice.toString());
				
				UserDAOImpl dao3 = new UserDAOImpl(DBConnect.getConn());

				if ("noselect".equals(paymentType)) {
					page = "cart.jsp";
					session.setAttribute("failedMsg", "Please select one payment method");
					//resp.sendRedirect(page);
				} 
				else {
					boolean b = dao2.addMovieOrder(m);
					boolean f = dao2.addMovieOrderDtls(orderList);
					int i = dao.updateCart(id);
					boolean c = dao3.updateCash(id, totalprice);
			
					if (b == true && f == true && i > 0 && c == true) {
						result = true;
						//resp.sendRedirect(page);
					}

				}
				
				if (result) {
					page = "order_complete.jsp";
					session.setAttribute("succMsg", "Order Completed");
				}
				
			}
				
			

		} catch (Exception e) {
			page = "error.jsp";
			e.printStackTrace();

		}
		finally {
			resp.sendRedirect(page);
		}

	}

}
