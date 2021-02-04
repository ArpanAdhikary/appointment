package com.cg.ams.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.cg.validation.message.ValidationMessage;

@Entity
@Table(name = "usersadmin")
public class UserRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = ValidationMessage.BLANKUSERNAME)
	@Column(name = "user_name")
	private String username;
	
	@NotBlank(message = ValidationMessage.BLANKNAME)
	@Column(name = "name")
	private String name;
	
	@NotBlank(message = ValidationMessage.BLANKMOBILENO)
	@Pattern(regexp="(0/91)?[7-9][0-9]{9}",message=ValidationMessage.VALIDMOBILENO) 
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@NotBlank(message = ValidationMessage.BLANKEMAILID)
	@Email(message=ValidationMessage.VALIDEMAILID)
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "role")
	private String role;
	
	
	@NotBlank(message = ValidationMessage.BLANKPASSWORD)
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",
	message=ValidationMessage.VALIDPASSWORD)
	@Column(name="password")
	private String password;
	
	
	
	public UserRegistration(int id,
			 String username,
			 String name,
			 String mobileNo,
			 String emailId,
			String role,
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

	public UserRegistration() {
		super();
	}

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

	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", username=" + username + ", name=" + name + ", mobileNo=" + mobileNo
				+ ", emailId=" + emailId + ", role=" + role + ", password=" + password + "]";
	}

	
	
}	

