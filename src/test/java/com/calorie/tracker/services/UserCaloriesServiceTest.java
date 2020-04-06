package com.calorie.tracker.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.calorie.tracker.dto.UserCalorieDTO;
import com.calorie.tracker.model.User;
import com.calorie.tracker.model.UserCalorie;
import com.calorie.tracker.repository.RoleRepository;
import com.calorie.tracker.repository.UserCaloriesRepository;
import com.calorie.tracker.repository.UserRepository;
import com.calorie.tracker.service.impl.UserCaloriesServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserCaloriesServiceTest {
	
	@Mock
	UserCaloriesRepository mockUserCaloriesRepository;
	
	@Mock
	UserRepository mockUserRepository;
	
	@Mock
	RoleRepository mockRoleRepository;
	
	
	@InjectMocks 
	UserCaloriesServiceImpl mockCaloriesServiceImpl;
	
	@Test
	public void getAllUserCalories() {
		Long userId=111L;
		List<UserCalorie> userCalories= new ArrayList<UserCalorie>();
		UserCalorie userCalorie=new UserCalorie();
		userCalorie.setUserId(111L);
		userCalorie.setItemName("item1");
		userCalorie.setTotalCalories(1000L);
		UserCalorie userCalorie2=new UserCalorie();
		userCalorie2.setUserId(111L);
		userCalorie2.setItemName("item2");
		userCalorie2.setTotalCalories(2000L);
		userCalories.add(userCalorie);
		userCalories.add(userCalorie2);
		
		when(mockUserCaloriesRepository.findByUserId(userId)).thenReturn(userCalories);
		
		User user=new User();
		user.setId(111L);
		user.setUsername("gtm666");
		user.setUserCalorieLimit(2000L);
		
		when(mockUserRepository.findById(userId)).thenReturn(Optional.of(user));
		
		UserCalorieDTO userCalorieDTO = mockCaloriesServiceImpl.getAllUserCalories(111L);
		
		assertEquals(userCalorieDTO.getCalorieLimit(), 2000L);
		assertEquals(userCalorieDTO.getUserCalories().get(0).getItemName(), "item1");
		assertEquals(userCalorieDTO.getUserCalories().get(1).getItemName(), "item2");
	
	}
	
	@Test
	public void getAllCalories() {
		
		List<UserCalorie> userCalories=new ArrayList<UserCalorie>();
		UserCalorie userCalorie=new UserCalorie();
		userCalorie.setUserId(111L);
		userCalorie.setItemName("item1");
		userCalories.add(userCalorie);
		when(mockUserCaloriesRepository.findAll()).thenReturn(userCalories);
		
		List<UserCalorie> userCaloriesResult=mockCaloriesServiceImpl.getAllCalories();
		
		assertEquals(userCaloriesResult.get(0).getItemName(), "item1");
	}	


}
