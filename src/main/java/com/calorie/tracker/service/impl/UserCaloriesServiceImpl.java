package com.calorie.tracker.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.calorie.tracker.dto.UserCalorieDTO;
import com.calorie.tracker.dto.UserCalorieDetails;
import com.calorie.tracker.exceptions.NoSuchUserFoundException;
import com.calorie.tracker.model.User;
import com.calorie.tracker.model.UserCalorie;
import com.calorie.tracker.repository.UserCaloriesRepository;
import com.calorie.tracker.repository.UserRepository;

@Service
public class UserCaloriesServiceImpl implements UserCaloriesService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserCaloriesRepository userCaloriesRepository;

	
	@Override
	public void addUserCalorieDetails(Long userId, UserCalorieDetails userCalorieDetails) {
		UserCalorie item = new UserCalorie();
		item.setItemName(userCalorieDetails.getItemName());
		item.setTotalCalories(userCalorieDetails.getTotalCalories());
		item.setUserId(userId);
		userCaloriesRepository.save(item);

	}

	@Override
	public void deleteUserCalorieDetails(String  userName) throws NoSuchUserFoundException {
		User user=userRepository.findByUsername(userName);
		
		if(user==null) {
			throw new NoSuchUserFoundException("No user with username"+userName);
		}
		userCaloriesRepository.deleteByUserId(user.getId());
		userRepository.deleteById(user.getId());
		
	}

	@Override
	public UserCalorieDTO getAllUserCalories(Long userId) {	
		List<UserCalorieDetails> userCalorieDetails=new ArrayList<UserCalorieDetails>();
		List<UserCalorie> userCalories= userCaloriesRepository.findByUserId(userId);
		UserCalorieDTO userCalorieDTO=new UserCalorieDTO();
		for(UserCalorie calorie:userCalories) {
			UserCalorieDetails userCalorie=new UserCalorieDetails();
			userCalorie.setItemName(calorie.getItemName());
			userCalorie.setTotalCalories(calorie.getTotalCalories());
			userCalorie.setCreatedDate(new java.sql.Date(calorie.getCreatedAt().getTime()));
			userCalorieDetails.add(userCalorie);
		}
		User user=userRepository.findById(userId).get();
		userCalorieDTO.setUserCalories(userCalorieDetails);
		userCalorieDTO.setCalorieLimit(user.getUserCalorieLimit());
		return userCalorieDTO;
	}

	@Override
	public List<UserCalorie> getAllCalories() {
	   return userCaloriesRepository.findAll();
	}

}
