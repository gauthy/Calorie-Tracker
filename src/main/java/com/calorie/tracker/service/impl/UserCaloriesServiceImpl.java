package com.calorie.tracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calorie.tracker.model.User;
import com.calorie.tracker.repository.UserCaloriesRepository;
import com.calorie.tracker.repository.UserRepository;

@Service
public class UserCaloriesServiceImpl implements UserCaloriesService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserCaloriesRepository userCaloriesRepository;

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

}
