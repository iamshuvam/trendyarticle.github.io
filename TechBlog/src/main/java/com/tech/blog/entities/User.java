package com.tech.blog.entities;
import java.sql.*;
public class User {
	private int id;
	private String username;
	private String email;
	private String passwrd;
	private String gender;
	private String profile;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswrd() {
		return passwrd;
	}
	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
	public User(int id, String username, String email, String passwrd, String gender) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.passwrd = passwrd;
		this.gender = gender;
	}
	public User(String username, String email, String passwrd, String gender) {
		super();
		this.username = username;
		this.email = email;
		this.passwrd = passwrd;
		this.gender = gender;
	}
	
	
	public User() {
		
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", passwrd=" + passwrd + ", gender="
				+ gender + "]";
	}
	
}
