package com.DAO;

import java.util.List;

import com.entity.MovieDtls;
import com.entity.MovieOrder;
import com.entity.MovieOrderDtls;
import com.entity.MovieOrderView;

public interface MovieOrderDAO {
	public int getLastOrderNo();
	
	public boolean addMovieOrder(MovieOrder m);
	
	public boolean addMovieOrderDtls(List<MovieOrderDtls> mlist);
	
	public List<MovieOrderView> viewMovieOrder(String email);
	
	public List<MovieDtls> viewMovieById(int id);
	
	public boolean retunMovie(int userid,int movieid, int price);
	
}
