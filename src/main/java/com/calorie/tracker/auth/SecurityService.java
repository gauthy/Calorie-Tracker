package com.calorie.tracker.auth;

public interface SecurityService {
	String findCurrentLoggedInUser();

	void autoLogin(String username, String password);
}
