package com.calorie.tracker.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.calorie.tracker.model.User;
import com.calorie.tracker.repository.UserRepository;
import com.calorie.tracker.exceptions.NoSuchUserFoundException;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUsername(username);
		if(user==null) {
			try {
				throw new NoSuchUserFoundException("User Not found with username " + username);
			} catch (NoSuchUserFoundException e) {
				e.printStackTrace();
			}
	    }
		return new  com.calorie.tracker.auth.UserDetailsService(user);
	}

}
