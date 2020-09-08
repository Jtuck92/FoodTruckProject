package com.skilldistillery.foodproject;

public class FoodTruck {

	private int uniqueId;
	private String name;
	private String foodType;
	private int rating;

	public FoodTruck() {
	}

	public FoodTruck(int uniqueId, String name, String foodType, int rating) {
		this.uniqueId = uniqueId;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String toString() {
		String output = "Truck ID: " + uniqueId + "\n" + "Name: " + name + "\n" + "Cuisine: " + foodType + "\n"
				+ "Rating: " + rating;
		return output;
	}
}
