package com.calorie.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.calorie.tracker.model.UserCalorie;

@Repository
public interface UserCaloriesRepository extends JpaRepository<UserCalorie,Long>{

	List<UserCalorie> findByUserId(Long userId);
	
}
