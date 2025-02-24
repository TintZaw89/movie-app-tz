package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAOImpl implements UserDAO {
	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean userRegister(User us) {
		boolean f = false;
		try {
			String sql="insert into user (name, email, phno, password,age) values(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql) ;
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhno());
			ps.setString(4, us.getPassword());
			ps.setInt(5, us.getAge());
			int i=ps.executeUpdate();
			if(i==1)
			{
			f=true;

			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	@Override
	public User login(String email, String password) {
		User us = null;
		try {
			String sql = "select id,name,email,phno,IFNULL(address,''),IFNULL(landmark,''),IFNULL(city,''),IFNULL(state,''),IFNULL(pincode,''),age,cash from user where email=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email); 
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			us=new User();
			us.setId(rs.getInt(1));
			us.setName(rs.getString(2));
			us.setEmail(rs.getString(3));
			us.setPhno(rs.getString(4));
			us.setAddress(rs.getString(5));
			us.setLandmark(rs.getString(6));
			us.setCity(rs.getString(7));
			us.setState(rs.getString(8));
			us.setPincode(rs.getString(9));
			us.setAge(rs.getInt(10));
			us.setCash(rs.getShort(11));;
			}
			
			rs.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return us;
	}

	@Override
	public boolean updateProfile(User us) {
		boolean f = false;
		try {
			String sql="update user set name=?, email=?, phno=?, password=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql) ;
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhno());
			ps.setString(4, us.getPassword() );
			ps.setInt(5, us.getId());
			int i=ps.executeUpdate();
			if(i==1)
			{
			f=true;

			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}

	@Override
	public boolean checkUser(String email) {
		Boolean b = true;
		try {
			String sql = "select id,name,email,phno from user where email=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				b = false;
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}

	@Override
	public boolean updateAddress(User us) {
		boolean f = false;
		try {
			String sql="update user set address=?, landmark=?, city=?, state=?, pincode=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql) ;
			ps.setString(1, us.getAddress());
			ps.setString(2, us.getLandmark());
			ps.setString(3, us.getCity());
			ps.setString(4, us.getState());
			ps.setString(5, us.getPincode());
			ps.setInt(6, us.getId());
			int i=ps.executeUpdate();
			if(i==1)
			{
			f=true;

			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}

	@Override
	public boolean updateCash(int id, Double amount) {
		boolean f = false;
		try {
			String sql="update user set cash=cash-? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql) ;		
			ps.setInt(1, amount.intValue());
			ps.setInt(2, id);
			int i=ps.executeUpdate();
			if(i==1)
			{
			f=true;

			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	@Override
	public int checkCash(int userId) {
		int cash = 0;
		try {
			String sql = "select cash from user where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				cash = rs.getInt(1);
			}
			rs.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return cash;
	}
	
	
	
}
