package com.calorie.tracker.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calorie.tracker.dto.DeleteUser;
import com.calorie.tracker.dto.UserCalorieDTO;
import com.calorie.tracker.dto.UserCalorieDetails;
import com.calorie.tracker.exceptions.NoSuchUserFoundException;
import com.calorie.tracker.model.User;
import com.calorie.tracker.model.UserCalorie;
import com.calorie.tracker.service.impl.UserCaloriesService;
import com.calorie.tracker.service.impl.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/user-calories")
public class UserCalorieController {

	@Autowired
	private UserCaloriesService userCalorieService;
	
	@Autowired
	private UserService userService;


	@PostMapping
	public void addUserCalorieDetails(Authentication authentication,@RequestBody UserCalorieDetails userCalorieDetails) throws NoSuchUserFoundException {

    	 userCalorieService.addUserCalorieDetails (UserController.getCurrentLoggedInUser().getId(),userCalorieDetails);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(Authentication authentication){
		return userService.getAllUsers();
	}
	
	@GetMapping("/all")
	public List<UserCalorie> getAllCalories(Authentication authentication){
		return userCalorieService.getAllCalories();
	}
			
	@GetMapping
	public UserCalorieDTO getAllUserCalories(Authentication authentication){
		User user=UserController.getCurrentLoggedInUser();
		return userCalorieService.getAllUserCalories(user.getId());
	}
	
	@DeleteMapping
	public String deleteUserRecords(Authentication authentication,@RequestBody DeleteUser user) throws NoSuchUserFoundException {
	
		String username=user.getUserName();
		userCalorieService.deleteUserCalorieDetails(username);
        return "Success";
	}
	
}
