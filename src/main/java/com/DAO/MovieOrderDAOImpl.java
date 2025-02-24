package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.MovieDtls;
import com.entity.MovieOrder;
import com.entity.MovieOrderDtls;
import com.entity.MovieOrderView;

public class MovieOrderDAOImpl implements MovieOrderDAO {
	private Connection conn;

	public MovieOrderDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean addMovieOrder(MovieOrder m) {
		boolean f = false;

		try {

			String sql = "insert into movie_order(order_id,username,email,address,phone,payment_type,total_price) values(?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, m.getOrderId());

			ps.setString(2, m.getUserName());

			ps.setString(3, m.getEmail());

			ps.setString(4, m.getAddress());

			ps.setString(5, m.getPhone());

			ps.setString(6, m.getPaymentType());

			ps.setString(7, m.getTotalPrice());

			int i = ps.executeUpdate();

			if (i == 1) {

				f = true;

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return f;

	}

	@Override
	public boolean addMovieOrderDtls(List<MovieOrderDtls> mlist) {
		boolean f = false;
		boolean b = false;

		try {

			String sql = "insert into movie_order_dtls(order_id, cartid, moviename, director,price, movieid, userid) values(?,?,?,?,?,?,?)";
			
			conn.setAutoCommit(false);
			
			String update_sql = "update movie_dtls set quantity=quantity-1 where movieid=?";
			
			String insert_sql = "insert into user_movie (userid,movieid,status) values(?,?,1) ";
			
			PreparedStatement ps2 = conn.prepareStatement(insert_sql);
			
			PreparedStatement ps1 = conn.prepareStatement(update_sql);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			for (MovieOrderDtls m : mlist) {

			ps.setString(1, m.getOrderId());

			ps.setInt(2, m.getCartId());

			ps.setString(3, m.getMovieName());

			ps.setString(4, m.getDirector());

			ps.setString(5, m.getPrice());
			
			ps.setInt(6, m.getMovieid());
			
			ps.setInt(7, m.getUserid());
			
			ps.addBatch();
			
			ps1.setInt(1, m.getMovieid());

			int j = ps1.executeUpdate();
			
			ps2.setInt(1, m.getUserid());
			
			ps2.setInt(2, m.getMovieid());
			
			int k = ps2.executeUpdate();
			
			if (j == 1 && k == 1)
			{
				b = true;
			}
			
			}
			
			

			int [] count = ps.executeBatch();
			
			conn.commit();
			
			f = true;

			conn.setAutoCommit(true);



		} catch (Exception e) {

			e.printStackTrace();

		}

		return f;

	}

	@Override
	public int getLastOrderNo() {
		int lastOrderNo = 0; 
		try {

			String sql = "select IFNULL(max(id),999999)+1 from movie_order"; //"select IFNULL(max(no),0)+1 from (select @rownum:=@rownum+1 No from movie_order, (SELECT @rownum:=0) r) a";//"SELECT COALESCE(max(substr(order_id,10)), 0)+1 AS order_id from movie_order";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				lastOrderNo = rs.getInt(1);
			}
			
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return lastOrderNo;
	}

	@Override
	public List<MovieOrderView> viewMovieOrder(String email) {
		List<MovieOrderView> list = new ArrayList<MovieOrderView>();
		MovieOrderView m = null;
		try {
			//System.out.println(email);
			String sql = "";
			if (email == "admin@gmail.com")
			{
			sql = "select o.order_id,o.username,o.address,o.phone,d.moviename,d.director,d.price,o.payment_type,o.email from movie_app.movie_order o,movie_app.movie_order_dtls d where o.order_id = d.order_id order by o.order_id";
			}
			else 
			{
			sql = "select o.order_id,o.username,o.address,o.phone,d.moviename,d.director,d.price,o.payment_type,o.email from movie_app.movie_order o,movie_app.movie_order_dtls d where o.order_id = d.order_id and o.email=? order by o.order_id";	
			}
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if (email != "admin@gmail.com")
				ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{

			m = new MovieOrderView();

			m.setOrderId(rs.getString(1));

			m.setUserName(rs.getString(2));

			m.setAddress(rs.getString(3));

			m.setPhoneNumber(rs.getString(4));

			m.setMovieName(rs.getString(5));

			m.setDirector(rs.getString(6));
			
			m.setPrice(rs.getString(7));
			
			m.setPaymentType(rs.getString(8));
			
			m.setEmail(rs.getString(9));

			list.add(m);
			}
			
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;
	}

	@Override
	public List<MovieDtls> viewMovieById(int id) {
		List<MovieDtls> list = new ArrayList<MovieDtls>();
		MovieDtls m = null;
		try {

			String sql = "select m.movieid,m.moviename,m.director,m.photo,m.genre,m.year,count(1)  from movie_dtls m,user_movie u where m.movieid=u.movieid and u.status=1 and u.userid=? group by m.movieid,m.moviename,m.director,m.photo,m.genre,m.year";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{

			m = new MovieDtls();

			m.setMovieId(rs.getInt(1));

			m.setMovieName(rs.getString(2));

			m.setDirector(rs.getString(3));

			m.setPhotoName(rs.getString(4));
			
			m.setGenre(rs.getString(5));
			
			m.setYear(rs.getString(6));
			
			m.setQuantity(rs.getInt(7));
			
			list.add(m);
			
			}
			
			rs.close();
		}

		catch (Exception e)
		{

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean retunMovie(int userid, int movieid, int price) {
		boolean f = false;

		try {

			String sql = "update user_movie set status = 2 where id = (select id from (select max(id) id from user_movie where userid=? and movieid=? and status=1 ) a)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, userid);

			ps.setInt(2, movieid);


			int i = ps.executeUpdate();
			
			
			String sql_1 = "update movie_dtls set quantity = quantity + 1 where movieid=?";

			PreparedStatement ps1 = conn.prepareStatement(sql_1);

			ps1.setInt(1, movieid);
			
			int k = ps1.executeUpdate();
			
			String sql_2="update user set cash=cash+? where id=?";
			PreparedStatement ps2=conn.prepareStatement(sql_2) ;		
			ps2.setInt(1, price);
			ps2.setInt(2, userid);
			int j=ps2.executeUpdate();
			
			String sql_3= "select id,order_id,price from movie_order_dtls where movieid=? and userid=? order by order_id desc,id desc limit 1";
			int returnId = 0;
			String  returnOrder = "";
			Double returnPrice = 0.00;
			
			PreparedStatement ps3 = conn.prepareStatement(sql_3);
			
			ps3.setInt(1, movieid);
			
			ps3.setInt(2, userid);
			
			ResultSet rs = ps3.executeQuery();
			
			while (rs.next())
			{
				returnId = rs.getInt(1);
				returnOrder = rs.getString(2);
				returnPrice = rs.getDouble(3);
			}
			
			//System.out.println(returnId + "," + returnOrder + "," + returnPrice);
			
			String sql_4 = "update movie_order set total_price=total_price-? where order_id=?";
			
			String sql_5 = "delete from movie_order_dtls where order_id=? and movieid=? and userid=? and id=?";
			
			PreparedStatement ps4=conn.prepareStatement(sql_4) ;		
			ps4.setDouble(1, returnPrice);
			ps4.setString(2, returnOrder);
			int l=ps4.executeUpdate();
			
			PreparedStatement ps5=conn.prepareStatement(sql_5) ;		
			ps5.setString(1, returnOrder);
			ps5.setInt(2, movieid);
			ps5.setInt(3, userid);
			ps5.setInt(4, returnId);
			int p=ps5.executeUpdate();
			

			if (i == 1 && j == 1 && k == 1 && l == 1 & p == 1)

			{

				f = true;

			}
			
			rs.close();

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		return f;
	}
	
	
	

}
