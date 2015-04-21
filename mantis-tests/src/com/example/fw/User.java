package com.example.fw;

public class User {

	private String login;
	private String password;
	private String email;
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}
	
	public User setLogin(String login) {
		this.login = login;
		return this;
	}
	
	public String getPassword() {
		return password;
	}
	
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", email="
				+ email + "]";
	}
	
}
