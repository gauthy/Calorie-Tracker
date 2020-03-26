package com.calorie.tracker.dto;

public class UserDetailsDTO {
	private String name;
	private String email;
	private String password;
	private Long calorieCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCalorieCount() {
		return calorieCount;
	}

	public void setCalorieCount(Long calorieCount) {
		this.calorieCount = calorieCount;
	}

}
