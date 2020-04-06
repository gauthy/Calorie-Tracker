package com.calorie.tracker.service.impl;

import java.util.List;

import com.calorie.tracker.dto.UserCalorieDTO;
import com.calorie.tracker.dto.UserCalorieDetails;
import com.calorie.tracker.exceptions.NoSuchUserFoundException;
import com.calorie.tracker.model.UserCalorie;

public interface UserCaloriesService {
	
	void addUserCalorieDetails(Long userId,UserCalorieDetails userCalorieDetails);
	
	void deleteUserCalorieDetails(String userName) throws NoSuchUserFoundException;

	UserCalorieDTO getAllUserCalories(Long userId);

	List<UserCalorie> getAllCalories();
	

}
