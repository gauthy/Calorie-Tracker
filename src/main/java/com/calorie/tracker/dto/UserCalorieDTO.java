package com.calorie.tracker.dto;

import java.util.List;

public class UserCalorieDTO {

	List<UserCalorieDetails> userCalories;
	private Long calorieLimit;
	public List<UserCalorieDetails> getUserCalories() {
		return userCalories;
	}
	public void setUserCalories(List<UserCalorieDetails> userCalories) {
		this.userCalories = userCalories;
	}
	public Long getCalorieLimit() {
		return calorieLimit;
	}
	public void setCalorieLimit(Long calorieLimit) {
		this.calorieLimit = calorieLimit;
	}
	

}
