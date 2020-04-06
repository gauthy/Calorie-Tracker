package com.calorie.tracker.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.calorie.tracker.enums.Roles;
import com.calorie.tracker.model.Role;
import com.calorie.tracker.model.User;
import com.calorie.tracker.service.impl.UserCaloriesService;
import com.calorie.tracker.service.impl.UserService;
import com.calorie.tracker.validator.UserValidator;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;


	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private UserCaloriesService userCaloriesService;

	
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
		
		return "redirect:/login";
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
		
		User user=getCurrentLoggedInUser();
		
		Set<Role> roles=user.getRoles();
		System.out.println(user.toString());
		if(!roles.isEmpty()&&roles.iterator().next().getDescription().equals(Roles.USER.name())){
		return "welcome";
		}
		else {
		return "admin";	
		}
	}
	
	
	public static User getCurrentLoggedInUser() {
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user;
	}

}
