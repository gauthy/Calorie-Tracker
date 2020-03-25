package com.calorie.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.calorie.tracker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}
