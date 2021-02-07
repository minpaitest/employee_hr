package com.emphr_hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	@Id
	@Column(name = "user_id", unique = true, length = 11)
	private String user_id;

	@Column(name = "password", length = 11)
	private String password;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String user_id, String password) {
		super();
		this.user_id = user_id;
		this.password = password;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [user_id=" + user_id + ", password=" + password + "]";
	}

}
