package com.calorie.tracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calorie.tracker.dto.UserDetailsDTO;
import com.calorie.tracker.model.User;
import com.calorie.tracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void createUser(User userDetails) {

	/*	User user = new User();
		user.setEmail(userDetails.getEmail());
		user.setRole("ROLE_USER");
		user.setSaltedHashedPassword(userDetails.getPassword());
		user.setUserCalorieLimit(userDetails.getCalorieCount());
		user.setName(userDetails.getName()); */
		userRepository.save(userDetails);

	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public void updateUser(Long userId, UserDetailsDTO userDetails) {

		User user = userRepository.findById(userId).get();
		if (userDetails.getCalorieCount() != null) {
			user.setUserCalorieLimit(userDetails.getCalorieCount());
		}

		
		userRepository.save(user);

	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
