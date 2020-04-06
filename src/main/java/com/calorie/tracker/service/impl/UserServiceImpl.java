package com.calorie.tracker.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.calorie.tracker.enums.Roles;
import com.calorie.tracker.model.Role;
import com.calorie.tracker.model.User;
import com.calorie.tracker.repository.RoleRepository;
import com.calorie.tracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void createUser(User userDetails) {
		
		Role role=roleRepository.findByDescription(Roles.USER.name());
		Set<Role> roles=new HashSet<Role>();
		roles.add(role);
		userDetails.setRoles(roles);
		userRepository.save(userDetails);

	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

}
