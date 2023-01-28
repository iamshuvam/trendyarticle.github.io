package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeDao {
	Connection conn;
	
	
	public LikeDao(Connection conn) {
		super();
		this.conn = conn;
	}


	public boolean insertLike(int pid, int uid) {
        boolean f = false;
        try {
            String q = "insert into likes(pid,uid)values(?,?)";
            PreparedStatement p = this.conn.prepareStatement(q);
            //values set...
            p.setInt(1, pid);
            p.setInt(2, uid);
            p.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

	
	
	 public int countLikeOnPost(int pid) {
	        int count = 0;

	        String q = "select count(*) from likes where pid=?";
	        try {
	            PreparedStatement p = this.conn.prepareStatement(q);
	            p.setInt(1, pid);
	            ResultSet set = p.executeQuery();
	            if (set.next()) {
	                count = set.getInt("count(*)");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return count;
	    }

	 
	 public boolean isLikedByUser(int pid, int uid) {
	        boolean f = false;
	        try {
	            PreparedStatement p = this.conn.prepareStatement("select * from likes where pid=? and uid=?");
	            p.setInt(1, pid);
	            p.setInt(2, uid);
	            ResultSet set = p.executeQuery();
	            if (set.next()) {
	                f = true;
	            }

	        } catch (Exception e) {
	        }
	        return f;
	    }


	 public boolean deleteLike(int pid, int uid) {
	        boolean f = false;
	        try {
	            PreparedStatement p = this.conn.prepareStatement("delete from likes where pid=? and uid=? ");
	            p.setInt(1, pid);
	            p.setInt(2, uid);
	            p.executeUpdate();
	            f = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return f;
	    }
}
