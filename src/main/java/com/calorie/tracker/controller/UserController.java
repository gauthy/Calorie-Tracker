package com.calorie.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calorie.tracker.dto.UserDetailsDTO;
import com.calorie.tracker.model.User;
import com.calorie.tracker.service.impl.UserCaloriesService;
import com.calorie.tracker.service.impl.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/")
	public void createUser(@RequestBody UserDetailsDTO userDetails) {
		userService.createUser(userDetails);
	}
	
	
	@PostMapping("/{userId}")
	public void updateUser(@RequestBody UserDetailsDTO userDetails,@PathVariable Long userId) {
		userService.updateUser(userId, userDetails);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);	
	}
}
