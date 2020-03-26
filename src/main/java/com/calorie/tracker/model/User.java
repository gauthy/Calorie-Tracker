package com.calorie.tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User extends Auditable {

	@Email
	@NotBlank
	@Column(unique = true)
	private String email;

	private String name;

	@NotBlank
	private String saltedHashedPassword;

	private String role;

	private Long userCalorieLimit;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSaltedHashedPassword() {
		return saltedHashedPassword;
	}

	public void setSaltedHashedPassword(String saltedHashedPassword) {
		this.saltedHashedPassword = saltedHashedPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserCalorieLimit() {
		return userCalorieLimit;
	}

	public void setUserCalorieLimit(Long userCalorieLimit) {
		this.userCalorieLimit = userCalorieLimit;
	}

}
