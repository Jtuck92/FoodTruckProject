package com.skilldistillery.foodproject;

import java.util.Arrays;
import java.util.Scanner;

public class FoodTruckRun {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		FoodTruckRun foodTruckRun = new FoodTruckRun();

		foodTruckRun.launch(kb, foodTruckRun);

		kb.close();
	}

	public void launch(Scanner kb, FoodTruckRun foodTruckRun) {
		System.out.println(
				"Welcome to the Food Truck Emporium!\nWhere your favorite meals on wheels are catalogued and rated.");
		FoodTruck[] trucks = foodTruckRun.addTruck(kb);

		boolean startMenu = true;
		while (startMenu) {
			foodTruckRun.displayMenu();
			startMenu = foodTruckRun.selectFromMenu(kb, trucks);
		}
	}

	public FoodTruck[] addTruck(Scanner kb) {
		System.out.println("How many trucks will you add?");
		int arrSize = kb.nextInt();

		FoodTruck[] foodTruckList = new FoodTruck[arrSize];
		double rating;
		String foodType;

		for (int i = 0; i < foodTruckList.length; i++) {
			System.out.println("Please enter the name of a truck.\nOr type \"quit\" to stop adding trucks.");
			String truckName = kb.next();

			if (truckName.equals("quit")) {
				FoodTruck[] earlyOut = Arrays.copyOf(foodTruckList, i);
				return earlyOut;
			} else {
				System.out.println("Please enter the cuisine of your truck: ");
				foodType = kb.next();
			}

			do {
				System.out.println(
						"Please enter a star rating for your truck on a scale of 0 being the worst\nand 5 being the best: ");
				rating = kb.nextDouble();

				if (rating < 0 || rating > 5) {
					System.out.println("Invalid rating. Please re-enter: ");
				}
			} while (rating < 0 || rating > 5);
			kb.nextLine();
			foodTruckList[i] = new FoodTruck();
			foodTruckList[i].setName(truckName);
			foodTruckList[i].setFoodType(foodType);
			foodTruckList[i].setRating((int) rating);
			foodTruckList[i].setUniqueId(i);
		}
		return foodTruckList;
	}

	public void displayMenu() {
		System.out.println("___________MENU___________");
		System.out.println("|  -Choose a command-    |");
		System.out.println("|                        |");
		System.out.println("|1. Display all trucks   |");
		System.out.println("|2. Check average rating |");
		System.out.println("|3. Show top rated truck |");
		System.out.println("|4. Exit                 |");
		System.out.println("|________________________|");
	}

	public boolean selectFromMenu(Scanner kb, FoodTruck[] trucks) {
		int selection = 0;

		do {
			System.out.println("Enter: ");
			selection = kb.nextInt();
			if (selection > 4 || selection < 1) {
				System.out.println("Invalid selection. Please re-enter.");
			}
		} while (selection < 0 || selection > 4);

		switch (selection) {
		case 1:
			displayTrucks(trucks);
			break;
		case 2:
			displayAverageRating(trucks);
			break;
		case 3:
			displayTopRated(trucks);
			break;
		case 4:
			System.out.println("Exiting program. Enjoy your meal!");
			return false;

		}

		return true;
	}

	public void displayTrucks(FoodTruck[] trucks) {
		System.out.println("Here's what you've got so far: ");
		for (int i = 0; i < trucks.length; i++) {
			System.out.println(trucks[i].toString());
		}
	}

	public void displayAverageRating(FoodTruck[] trucks) {
		double sumRate = 0;
		for (int i = 0; i < trucks.length; i++) {
			sumRate += trucks[i].getRating();
		}
		double average = sumRate / trucks.length * 1;
		double round = (Math.round(average) * 100) / 100;
		System.out.println("The average rating of your trucks is: " + round);
	}

	public void displayTopRated(FoodTruck[] trucks) {
		double topRate = trucks[0].getRating();

		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i].getRating() > topRate) {
				topRate = trucks[i].getRating();
			}
		}
		int tie = 0;
		for (int i = 0; i < trucks.length; i++) {
			if (topRate == trucks[i].getRating()) {
				tie++;
			}
		}
		if (tie > 1) {
			System.out.println(tie + " trucks tie for the top spot!");
		} else {
			System.out.println("Your best food truck is: ");
		}
		for (int i = 0; i < trucks.length; i++) {
			if (topRate == trucks[i].getRating()) {
				System.out.println(trucks[i].toString());
			}
		}
	}
}
