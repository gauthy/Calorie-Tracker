package com.calorie.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calorie.tracker.model.User;
import com.calorie.tracker.service.impl.UserCaloriesService;
import com.calorie.tracker.service.impl.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserCaloriesService userCalorieService;
	
	@GetMapping("/")
	public List<User> getAllPlayers() {
		return userService.getAllUsers();
	}
	
	
	
}
