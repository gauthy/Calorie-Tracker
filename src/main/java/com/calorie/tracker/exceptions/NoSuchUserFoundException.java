package com.calorie.tracker.exceptions;

public class NoSuchUserFoundException extends Exception {

	private String message="";
	
	public NoSuchUserFoundException(String message) {
		this.message=message;
	}
}
