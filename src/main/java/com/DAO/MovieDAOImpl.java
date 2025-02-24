package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.MovieDtls;

public class MovieDAOImpl implements MovieDAO {
	
	private Connection conn;
	

	public MovieDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}


	@Override
	public boolean addMovies(MovieDtls m) {
		boolean f = false;

		try {

			String sql = "insert into movie_dtls(moviename, director, price, movieCategory, status, photo, email, genre, year, video, quantity) values(?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, m.getMovieName());

			ps.setString(2, m.getDirector());

			ps.setString(3, m.getPrice());

			ps.setString(4, m.getMovieCategory());

			ps.setString(5, m.getStatus());

			ps.setString(6, m.getPhotoName());

			ps.setString(7, m.getEmail());
			
			ps.setString(8, m.getGenre());

			ps.setString(9, m.getYear());
			
			ps.setString(10,m.getVideo());
			
			ps.setInt(11,m.getQuantity());

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
	public List<MovieDtls> getAllMovies() {

		List<MovieDtls> list = new ArrayList<MovieDtls>();

		MovieDtls m = null;

		try {

			String sql = "select * from movie_dtls";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				m = new MovieDtls();

				m.setMovieId(rs.getInt(1));

				m.setMovieName(rs.getString(2));

				m.setDirector(rs.getString(3));

				m.setPrice(rs.getString(4));

				m.setMovieCategory(rs.getString(5));

				m.setStatus(rs.getString(6));

				m.setPhotoName(rs.getString(7));

				m.setEmail(rs.getString(8));
				
				m.setGenre(rs.getString(9));
				
				m.setYear(rs.getString(10));
				
				m.setVideo(rs.getString(11));
				
				m.setQuantity(rs.getInt(12));

				list.add(m);

			}
			
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;

	}


	@Override
	public MovieDtls getMovieById(int id) {
		MovieDtls m = null;
		try {

			String sql = "select * from movie_dtls where movieid=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{

			m = new MovieDtls();

			m.setMovieId(rs.getInt(1));

			m.setMovieName(rs.getString(2));

			m.setDirector(rs.getString(3));

			m.setPrice(rs.getString(4));

			m.setMovieCategory(rs.getString(5));

			m.setStatus(rs.getString(6));

			m.setPhotoName(rs.getString(7));

			m.setEmail(rs.getString(8));
			
			m.setGenre(rs.getString(9));
			
			m.setYear(rs.getString(10));
			
			m.setVideo(rs.getString(11));
			
			m.setQuantity(rs.getInt(12));
			
			}
			
			rs.close();
		}

		catch (Exception e)
		{

			e.printStackTrace();
		}
		return m;
	}


	@Override
	public boolean editMovies(MovieDtls m) {
		
		boolean f = false;

		try {

			String sql = "update movie_dtls set moviename=?, director=?, price=?, status=?, quantity=? where movieid=?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, m.getMovieName());

			ps.setString(2, m.getDirector());

			ps.setString(3, m.getPrice());

			ps.setString(4, m.getStatus());
			
			ps.setInt(5, m.getQuantity());

			ps.setInt(6, m.getMovieId());

			int i = ps.executeUpdate();

			if (i == 1)

			{

				f = true;

			}

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		return f;

	}


	@Override
	public boolean deleteMovies(int id) {
		boolean f = false;
		try {
			String sql = "delete from movie_dtls where movieid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		}
		catch (Exception e)
		{

			e.printStackTrace();
		}
		
		return f;
	}


	@Override
	public List<MovieDtls> getNewMovies() {
		List<MovieDtls> list = new ArrayList<MovieDtls>();

		MovieDtls m = null;

		try {

			String sql = "select * from movie_dtls where movieCategory=? order by movieid desc";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "New");

			ResultSet rs = ps.executeQuery();
			

			while (rs.next()) {

				m = new MovieDtls();

				m.setMovieId(rs.getInt(1));

				m.setMovieName(rs.getString(2));

				m.setDirector(rs.getString(3));

				m.setPrice(rs.getString(4));

				m.setMovieCategory(rs.getString(5));

				m.setStatus(rs.getString(6));

				m.setPhotoName(rs.getString(7));

				m.setEmail(rs.getString(8));
				
				m.setGenre(rs.getString(9));
				
				m.setYear(rs.getString(10));
				
				m.setVideo(rs.getString(11));
				
				m.setQuantity(rs.getInt(12));

				list.add(m);

			}
			
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;
	}


	@Override
	public List<MovieDtls> getRecentMovies() {
		List<MovieDtls> list = new ArrayList<MovieDtls>();

		MovieDtls m = null;

		try {

			String sql = "select * from movie_dtls order by movieid desc";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			//int i =1; && i < 5

			while (rs.next()) {

				m = new MovieDtls();

				m.setMovieId(rs.getInt(1));

				m.setMovieName(rs.getString(2));

				m.setDirector(rs.getString(3));

				m.setPrice(rs.getString(4));

				m.setMovieCategory(rs.getString(5));

				m.setStatus(rs.getString(6));

				m.setPhotoName(rs.getString(7));

				m.setEmail(rs.getString(8));
				
				m.setGenre(rs.getString(9));
				
				m.setYear(rs.getString(10));
				
				m.setVideo(rs.getString(11));
				
				m.setQuantity(rs.getInt(12));

				list.add(m);

			}
			
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;
	}


	@Override
	public List<MovieDtls> getOldMovies() {
		List<MovieDtls> list = new ArrayList<MovieDtls>();

		MovieDtls m = null;

		try {

			String sql = "select * from movie_dtls where movieCategory=? order by movieid desc";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "Old");

			ResultSet rs = ps.executeQuery();
			

			while (rs.next()) {

				m = new MovieDtls();

				m.setMovieId(rs.getInt(1));

				m.setMovieName(rs.getString(2));

				m.setDirector(rs.getString(3));

				m.setPrice(rs.getString(4));

				m.setMovieCategory(rs.getString(5));

				m.setStatus(rs.getString(6));

				m.setPhotoName(rs.getString(7));

				m.setEmail(rs.getString(8));
				
				m.setGenre(rs.getString(9));
				
				m.setYear(rs.getString(10));
				
				m.setVideo(rs.getString(11));
				
				m.setQuantity(rs.getInt(12));

				list.add(m);
				

			}
			
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;
	}


	@Override
	public List<MovieDtls> getMoviesByOld(String email, String catg) {
		List<MovieDtls> list = new ArrayList<MovieDtls>();

		MovieDtls m = null;

		try {

			String sql = "select * from movie_dtls where movieCategory=? and email=? order by movieid desc";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, catg);
			
			ps.setString(2, email);

			ResultSet rs = ps.executeQuery();
			

			while (rs.next()) {

				m = new MovieDtls();

				m.setMovieId(rs.getInt(1));

				m.setMovieName(rs.getString(2));

				m.setDirector(rs.getString(3));

				m.setPrice(rs.getString(4));

				m.setMovieCategory(rs.getString(5));

				m.setStatus(rs.getString(6));

				m.setPhotoName(rs.getString(7));

				m.setEmail(rs.getString(8));
				
				m.setGenre(rs.getString(9));
				
				m.setYear(rs.getString(10));
				
				m.setVideo(rs.getString(11));
				
				m.setQuantity(rs.getInt(12));
				
				list.add(m);
				

			}
			
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;
	}


	@Override
	public List<MovieDtls> getMoviesBySearch(String ch) {
		List<MovieDtls> list = new ArrayList<MovieDtls>();

		MovieDtls m = null;

		try {

			String sql = "select * from movie_dtls where moviename like ? or director like ? or genre=? or year=? order by movieid desc";

			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "%" + ch + "%"); 
			
			ps.setString(2,  "%" + ch + "%");
			
			ps.setString(3, ch);
			
			ps.setString(4, ch);

			ResultSet rs = ps.executeQuery();
			

			while (rs.next()) {

				m = new MovieDtls();

				m.setMovieId(rs.getInt(1));

				m.setMovieName(rs.getString(2));

				m.setDirector(rs.getString(3));

				m.setPrice(rs.getString(4));

				m.setMovieCategory(rs.getString(5));

				m.setStatus(rs.getString(6));

				m.setPhotoName(rs.getString(7));

				m.setEmail(rs.getString(8));
				
				m.setGenre(rs.getString(9));
				
				m.setYear(rs.getString(10));
				
				m.setVideo(rs.getString(11));
				
				m.setQuantity(rs.getInt(12));

				list.add(m);
				

			}
			
			rs.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;
	}
}
