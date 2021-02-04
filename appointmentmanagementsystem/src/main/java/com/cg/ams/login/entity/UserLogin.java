package com.cg.ams.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** class to map with usersadmin table */

@Entity
@Table(name = "usersadmin")
public class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	

	@Column(name = "user_name")
	private String username;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "role")
	private String role;

	@Column(name="password")
	private String password;

	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public UserLogin(int id, String username, String name, String mobileNo, String emailId, String role,
			String password) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.role = role;
		this.password = password;
	}

	public UserLogin() {
		super();
	}

	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", username=" + username + ", name=" + name + ", mobileNo=" + mobileNo
				+ ", emailId=" + emailId + ", role=" + role + ", password=" + password + "]";
	}

	
	
}	

