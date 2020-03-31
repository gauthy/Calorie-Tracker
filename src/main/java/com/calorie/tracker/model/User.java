package com.calorie.tracker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "users")
public class User extends Auditable {

	@NotBlank
	@Column(unique = true)
	private String username;

	@NotBlank
	private String password;
	
	@NotBlank
	private String passwordConfirm;


	private Long userCalorieLimit;
	
	@ManyToMany(fetch=FetchType.EAGER)
	Set<Role> roles = new HashSet<>();

	public User(User user) {
		username=user.getUsername();
		password=user.getPassword();
		roles=user.getRoles();
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = new BCryptPasswordEncoder(5).encode(password);
	}

	public Long getUserCalorieLimit() {
		return userCalorieLimit;
	}

	public void setUserCalorieLimit(Long userCalorieLimit) {
		this.userCalorieLimit = userCalorieLimit;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", passwordConfirm=" + passwordConfirm
				+ ", userCalorieLimit=" + userCalorieLimit + ", roles=" + roles + "]";
	}
	
	
	
	

}
