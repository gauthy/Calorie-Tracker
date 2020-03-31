package com.calorie.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calorie.tracker.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
