package com.calorie.tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table(name = "user_calories")
public class UserCalorie extends Auditable {

	@Column(name = "item_name")
	private String itemName;

	@NotNull
	@Column(name = "calories")
	private Long totalCalories;

	@NotNull
	private Long userId;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
