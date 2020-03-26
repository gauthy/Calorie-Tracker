package com.calorie.tracker.service.impl;

import java.util.List;

import com.calorie.tracker.dto.UserCalorieDetails;
import com.calorie.tracker.exceptions.NoSuchUserFoundException;
import com.calorie.tracker.model.UserCalorie;

public interface UserCaloriesService {

	
	Long getUserLimit(Long userId) throws NoSuchUserFoundException;
	
	List<UserCalorie> getUserCalories(Long userId);
	
	void updateUserCalorieDetails(Long userCalorieId,UserCalorieDetails userCalorieDetails);
	
	void addUserCalorieDetails(Long userId,UserCalorieDetails userCalorieDetails);
	
	void deleteUserCalorieDetails(Long userCalorieId);
	

}
