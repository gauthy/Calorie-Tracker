package com.calorie.tracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Long getUserLimit(Long userId) throws NoSuchUserFoundException {
		User user = userRepository.findById(userId).get();

		if (user == null) {
			throw new NoSuchUserFoundException("No User Found With ID" + userId);
		}

		return user.getUserCalorieLimit();
	}

	@Override
	public List<UserCalorie> getUserCalories(Long userId) {
		return userCaloriesRepository.findByUserId(userId);
	}

	@Override
	public void updateUserCalorieDetails(Long userCalorieId, UserCalorieDetails userCalorieDetails) {
		UserCalorie itemDetails = userCaloriesRepository.findById(userCalorieId).get();

		if (userCalorieDetails.getItemName() != null) {
			itemDetails.setItemName(userCalorieDetails.getItemName());
		}

		if (userCalorieDetails.getTotalCalories() != null) {
			itemDetails.setTotalCalories(userCalorieDetails.getTotalCalories());
		}
		userCaloriesRepository.save(itemDetails);
	}

	@Override
	public void addUserCalorieDetails(Long userId, UserCalorieDetails userCalorieDetails) {
		UserCalorie item = new UserCalorie();
		item.setItemName(userCalorieDetails.getItemName());
		item.setTotalCalories(userCalorieDetails.getTotalCalories());
		item.setUserId(userId);
		userCaloriesRepository.save(item);

	}

	@Override
	public void deleteUserCalorieDetails(Long userCalorieId) {
		userCaloriesRepository.deleteById(userCalorieId);
	}

}
