package com.calorie.tracker.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCalorieDetails {

	private String itemName;
	private Long totalCalories;
	private Date createdDate;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getTotalCalories() {
		return totalCalories;
	}

	public void setTotalCalories(Long totalCalories) {
		this.totalCalories = totalCalories;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "UserCalorieDetails [itemName=" + itemName + ", totalCalories=" + totalCalories + "]";
	}
	
	

}
