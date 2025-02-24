package com.DAO;

import java.util.List;

import com.entity.Cart;

public interface CartDAO {
	
	public boolean addCart(Cart c);
	
	public List<Cart> getMovieById(int userId);
	
	public boolean removeCard(int cid);
	
	public int updateCart(int userId);
	
	public boolean checkCartByMovie(int movieId);

}
