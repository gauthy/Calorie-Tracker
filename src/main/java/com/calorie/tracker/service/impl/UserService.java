package com.calorie.tracker.service.impl;

import java.util.List;
import com.calorie.tracker.model.User;

public interface UserService {

	List<User> getAllUsers();

	void createUser(User userDetails);

	void deleteUser(Long userId);
	
	User findByUserName(String email);

}
