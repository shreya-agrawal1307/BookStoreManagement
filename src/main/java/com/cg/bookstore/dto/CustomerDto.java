package com.cg.bookstore.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class CustomerDto {
private int customerId;
	
	@NotNull(message = "Email is required")
	@Column(name="email")
	private String email;
	
	@NotNull(message = "fullName is required")
	@Column(name="fullname")
	private String fullName;
	
	@NotNull(message = "Password is required")
	@Column(name="password")
	private String password;
	
	@NotNull(message = "mobilenumber is required")
	@Column(name="mobile")
	private String mobileNumber;
	
	//@Past(message="Date should be past date")
	@Column(name="register_on")
	private LocalDate registerOn;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDate getRegisterOn() {
		return registerOn;
	}

	public void setRegisterOn(LocalDate registerOn) {
		this.registerOn = registerOn;
	}
	

}
