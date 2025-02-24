package com.DAO;

import java.util.List;

import com.entity.MovieDtls;

public interface MovieDAO {
	public boolean addMovies(MovieDtls m);
	
	public List<MovieDtls> getAllMovies();

	public MovieDtls getMovieById(int id);
	
	public boolean editMovies(MovieDtls m);
	
	public boolean deleteMovies(int id);
	
	public List<MovieDtls> getNewMovies();
	
	public List<MovieDtls> getRecentMovies();
	
	public List<MovieDtls> getOldMovies();
	
	public List<MovieDtls> getMoviesByOld(String email,String catg);
	
	public List<MovieDtls> getMoviesBySearch(String ch);
	
}
 