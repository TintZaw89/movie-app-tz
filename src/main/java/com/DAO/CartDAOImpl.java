package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart;
import com.entity.MovieDtls;

public class CartDAOImpl implements CartDAO{
private Connection conn;
	

	public CartDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}


	@Override
	public boolean addCart(Cart c) {
		boolean b = false;
		
		try {

			String sql = "insert into cart(movieid, userid, moviename, director, price, total_price,status) values(?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, c.getMovieId());

			ps.setInt(2, c.getUserId());

			ps.setString(3, c.getMovieName());

			ps.setString(4, c.getDirector());

			ps.setDouble(5, c.getPrice());

			ps.setDouble(6, c.getTotalPrice());
			
			ps.setInt(7, 0);

			int i = ps.executeUpdate();

			if (i == 1) {

				b = true;

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return b;
	}


	@Override
	public List<Cart> getMovieById(int userId) {
		List<Cart> list = new ArrayList<Cart>();
		Cart c = null;
		Double totalPrice = 0.0;
		try {

			String sql = "select cartid, movieid, userid, moviename, director, price, total_price from cart where status=0 and userid=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{

			c = new Cart();

			c.setCartId(rs.getInt(1));

			c.setMovieId(rs.getInt(2));

			c.setUserId(rs.getInt(3));

			c.setMovieName(rs.getString(4));

			c.setDirector(rs.getString(5));

			c.setPrice(rs.getDouble(6));
			
			totalPrice = totalPrice + rs.getDouble(7);
			
			c.setTotalPrice(totalPrice);

			list.add(c);
			}
			
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;
	}


	@Override
	public boolean removeCard(int cid) {
		boolean b = false;
		
		try {

			String sql = "delete from cart where cartid=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, cid);

			int i = ps.executeUpdate();

			if (i == 1) {

				b = true;

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return b;
	}


	@Override
	public int updateCart(int userId) {
		int i = 0;
		
		try {

			String sql = "update cart set status=1 where status<>1 and userid=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, userId);

			i = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return i;
	}


	@Override
	public boolean checkCartByMovie(int movieId) {
		boolean f = true;
		try {
			String sql = "SELECT c.movieid,count(1) count_mov,m.quantity FROM cart c,movie_dtls m where m.movieid=c.movieid and c.status=0 and c.movieid=? group by c.movieid";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, movieId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				if (rs.getInt(2) >= rs.getInt(3)) {
					f = false;
				}
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	
		
	

}
