package com.calorie.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calorie.tracker.auth.SecurityService;
import com.calorie.tracker.dto.UserDetailsDTO;
import com.calorie.tracker.model.User;
import com.calorie.tracker.service.impl.UserCaloriesService;
import com.calorie.tracker.service.impl.UserService;
import com.calorie.tracker.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

/*	@GetMapping("/")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/")
	public void createUser(@RequestBody User userDetails) {
		userService.createUser(userDetails);
	}

	@PostMapping("/{userId}")
	public void updateUser(@RequestBody UserDetailsDTO userDetails, @PathVariable Long userId) {
		userService.updateUser(userId, userDetails);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
	*/

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}
      
		userService.createUser(userForm);
		
		System.out.println(userForm.toString());

		securityService.autoLogin(userForm.getUsername(), userForm.getPassword());

		return "redirect:/welcome";
	}

	@GetMapping({"/login"})
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@GetMapping({"/","/welcome"})
	public String welcome(Model model) {
		return "welcome";
	}

}
