package com.tech.blog.dao;
import java.sql.*;

import com.tech.blog.entities.User;

public class UserDao {
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	//method insert into database
	
	
	public boolean saveUser(User user) {
		boolean f = false;
		try {
			
			String query = "insert into user(username,email,passwrd,gender) values(?,?,?,?)";
			 PreparedStatement pstmt =this.conn.prepareStatement(query);
			 pstmt.setString(1, user.getUsername());
			 pstmt.setString(2, user.getEmail());
			 pstmt.setString(3, user.getPasswrd());
			 pstmt.setString(4, user.getGender());
			 
			 pstmt.executeUpdate();
			 f= true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
	
	//get user by email and id
	
	public User getUserByEmailAndPassword(String email,String password) {
		User user;
	    user = null;
	    try {
	    	String query = "select * from user where email=? and passwrd=?";
	    	PreparedStatement pstmt = conn.prepareStatement(query);
	    	pstmt.setString(1, email);
	    	pstmt.setString(2, password);
	    	ResultSet set= pstmt.executeQuery();
	    	if(set.next()) {
	    		user = new User();
	    		String name = set.getString("username");
	    		user.setUsername(name);
	    		user.setId(set.getInt("id"));
	    		user.setEmail(set.getString("email"));
	    		user.setPasswrd(set.getString("passwrd"));
	    		user.setGender(set.getString("gender"));
	    		user.setProfile(set.getString("profile"));
	    	}else {
	    	
	    	}
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    return user;
	}
	
	// Update User
	public boolean updateUser(User user) {

        boolean f = false;
        try {

            String query = "update user set username=? , email=? , passwrd=? , gender=? ,profile=? where  id =?";
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, user.getUsername());
            p.setString(2, user.getEmail());
            p.setString(3, user.getPasswrd());
            p.setString(4, user.getGender());
            p.setString(5, user.getProfile());
            p.setInt(6, user.getId());

            p.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
	public User getUserByUserId(int userId) {
        User user = null;
        try {
            String q = "select * from user where id=?";
            PreparedStatement ps = this.conn.prepareStatement(q);
            ps.setInt(1, userId);
            ResultSet set = ps.executeQuery();
            if (set.next()) {
                user = new User();

//             data from db
                String name = set.getString("username");
//             set to user object
                user.setUsername(name);

                user.setId(set.getInt("id"));
                user.setEmail(set.getString("email"));
                user.setPasswrd(set.getString("passwrd"));
                user.setGender(set.getString("gender"));
                
                user.setProfile(set.getString("profile"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

}
