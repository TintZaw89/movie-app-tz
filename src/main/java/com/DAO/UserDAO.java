package com.DAO;

import com.entity.User;

public interface UserDAO {
	public boolean userRegister(User us);
	
	public User login(String email,String password);
	
	public boolean updateProfile(User us);
	
	public boolean checkUser(String email);
	
	public boolean updateAddress(User us);
	
	public boolean updateCash(int id, Double amount);
	
	public int checkCash(int userId);

}
