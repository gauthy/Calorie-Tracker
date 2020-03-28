package com.calorie.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calorie.tracker.dto.UserCalorieDetails;
import com.calorie.tracker.exceptions.NoSuchUserFoundException;
import com.calorie.tracker.model.UserCalorie;
import com.calorie.tracker.service.impl.UserCaloriesService;

@RestController
@RequestMapping("/user-calories")
public class UserCalorieController {

	@Autowired
	private UserCaloriesService userCalorieService;
	
	
	@GetMapping("/limit/{userId}")
	public Long getUserLimit(@PathVariable Long userId) throws NoSuchUserFoundException {
		return userCalorieService.getUserLimit(userId);
	}
	
	@GetMapping("/{userId}")
	public List<UserCalorie> getUserCalories(@PathVariable Long userId) throws NoSuchUserFoundException {
		return userCalorieService.getUserCalories(userId);
	}
	

	@PutMapping("/{userCalorieId}")
	public void addUserCalorieDetails(@PathVariable Long userCalorieId,@RequestBody UserCalorieDetails userCalorieDetails) throws NoSuchUserFoundException {
		 userCalorieService.addUserCalorieDetails(userCalorieId, userCalorieDetails);
	}
	
	@PutMapping("/{userCalorieId}")
	public void updateUserCalorieDetails(@PathVariable Long userCalorieId,@RequestBody UserCalorieDetails userCalorieDetails) throws NoSuchUserFoundException {
		 userCalorieService.updateUserCalorieDetails(userCalorieId, userCalorieDetails);
	}
	
	
	@DeleteMapping("/{userCalorieId}")
	public void deleteUserCalorieDetails(@PathVariable Long userCalorieId) {
		 userCalorieService.deleteUserCalorieDetails(userCalorieId);
	}
		
}
