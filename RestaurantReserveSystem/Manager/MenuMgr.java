package Manager;

import datatxt.FileReaderWriter;

import java.io.FileNotFoundException;
import Entities.FoodItem;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import Entities.FoodItem.FoodType;

/**
 * A food item to be used in storing menu items
 * 
 * @author Pranwanth
 * @version 1.0
 * @since 2021-11-12
 */

public class MenuMgr {

	/**
	 * An ArrayList of FoodItems which will be classified as Appetizers
	 */
	protected static ArrayList<FoodItem> appet = new ArrayList<FoodItem>();
	/**
	 * An ArrayList of FoodItems which will be classified as Dessert
	 */
	protected static ArrayList<FoodItem> dessert = new ArrayList<FoodItem>();
	/**
	 * An ArrayList of FoodItems which will be classified as Drinks
	 */
	protected static ArrayList<FoodItem> drinks = new ArrayList<FoodItem>();
	/**
	 * An ArrayList of FoodItems which will be classified as Main Course
	 */
	protected static ArrayList<FoodItem> mainCourse = new ArrayList<FoodItem>();
	/**
	 * An ArrayList of FoodItems which will add the Appetizer, Drinks, Dessert and
	 * Main Course ArrayList
	 */
	protected static ArrayList<FoodItem> menu = new ArrayList<FoodItem>();

	/**
	 * Reads the Menu Items from their txt files
	 * 
	 * @return ArrayList<FoodItem>
	 */
	public static ArrayList<FoodItem> readMenu() {
		FileReaderWriter fi = new FileReaderWriter();
		try {
			fi.getDrinks(drinks);
			fi.getAppetizer(appet);
			fi.getDessert(dessert);
			fi.getMainCourse(mainCourse);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		menu.addAll(appet);
		menu.addAll(drinks);
		menu.addAll(dessert);
		menu.addAll(mainCourse);

		return menu;
	}

	/**
	 * Adds a Food Item into the Menu
	 * 
	 * @param name        Food Item's name
	 * @param price       Food Item's price
	 * @param description Food Item's Description
	 * @param type        Food Item's Food Type
	 */
	public static void addToMenu(String name, double price, String desc, String type) {
		FoodType ftype = null; // Default value will change if it is something else
		for (int i = 0; i < FoodType.values().length; i++) {
			if (FoodType.values()[i].toString().equals(type)) {
				ftype = FoodType.values()[i];
			}
		}
		if (ftype == null) {
			System.out.println("Invalid Food Type, please try again!");
			return;
		}
		FoodItem item = new FoodItem(name, price, desc, ftype);
		if (ftype == FoodType.Appetizer) {
			appet.add(item);
		} else if (ftype == FoodType.Drinks) {
			drinks.add(item);
		} else if (ftype == FoodType.Dessert) {
			dessert.add(item);
		} else {
			mainCourse.add(item);
		}
		menu.add(item);

		System.out.println("Item successfully added to Menu");

		String file_name = item.getFoodType().toString();

		try {
			// RestaurantReserveSystem/datatxt/MainCourse.txt
			FileWriter menuWriter = new FileWriter("RestaurantReserveSystem/" + "datatxt/" + file_name + ".txt", true);
			PrintWriter menuPrinter = new PrintWriter(menuWriter);
			menuPrinter.println("," + item.getFoodName() + ", " + item.getFoodPrice() + "," + item.getFoodDesc());
			menuPrinter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Updates an existing Food Item into the Menu
	 * 
	 * @param name     Current Food Item's name
	 * @param newName  Updated name for selcted Food Item
	 * @param newPrice Updated price for selcted Food Item
	 * @param newDesc  Updated Description for selcted Food Item
	 * @param newType  Updated Food Type for selcted Food Item
	 */

	public static void updateToMenu(String name, String newName, double newPrice, String newDesc, String newType) {
		FoodType ftype = null;
		for (int i = 0; i < FoodType.values().length; i++) {
			if (FoodType.values()[i].toString().equals(newType)) {
				ftype = FoodType.values()[i];
			}
		}
		if (ftype == null) {
			System.out.println("Invalid Food Type, please try again!");
			return;
		}

		for (int j = 0; j < menu.size(); j++) {
			if (menu.get(j).getFoodName().equals(name)) {
				menu.get(j).setFoodName(newName);
				menu.get(j).setFoodPrice(newPrice);
				menu.get(j).setFoodDesc(newDesc);
				menu.get(j).setFoodType(ftype);
			}
		}

		if (ftype == FoodType.Appetizer) {
			for (int j = 0; j < appet.size(); j++) {
				if (appet.get(j).getFoodName().equals(name)) {
					appet.get(j).setFoodName(newName);
					appet.get(j).setFoodPrice(newPrice);
					appet.get(j).setFoodDesc(newDesc);
					appet.get(j).setFoodType(ftype);
				}
			}
		} else if (ftype == FoodType.Drinks) {
			for (int j = 0; j < drinks.size(); j++) {
				if (drinks.get(j).getFoodName().equals(name)) {
					drinks.get(j).setFoodName(newName);
					drinks.get(j).setFoodPrice(newPrice);
					drinks.get(j).setFoodDesc(newDesc);
					drinks.get(j).setFoodType(ftype);
				}
			}
		} else if (ftype == FoodType.Dessert) {
			for (int j = 0; j < dessert.size(); j++) {
				if (dessert.get(j).getFoodName().equals(name)) {
					dessert.get(j).setFoodName(newName);
					dessert.get(j).setFoodPrice(newPrice);
					dessert.get(j).setFoodDesc(newDesc);
					dessert.get(j).setFoodType(ftype);
				}
			}
		} else {
			for (int j = 0; j < mainCourse.size(); j++) {
				if (mainCourse.get(j).getFoodName().equals(name)) {
					mainCourse.get(j).setFoodName(newName);
					mainCourse.get(j).setFoodPrice(newPrice);
					mainCourse.get(j).setFoodDesc(newDesc);
					mainCourse.get(j).setFoodType(ftype);
				}
			}
		}

		System.out.println("Food Item updated in Menu");

		// Need to implement writing to text file;
	}

	/**
	 * Removes an existing Food Item from the Menu using it's name
	 * 
	 * @param name Current Food Item's name
	 */

	public static void removeFromMenu(String name) {
		FoodType fType = null;
		for (int j = 0; j < menu.size(); j++) {
			if (menu.get(j).getFoodName().equals(name)) {
				fType = menu.get(j).getFoodType();
				menu.remove(j);
			}
		}

		if (fType == FoodType.Appetizer) {
			for (int j = 0; j < appet.size(); j++) {
				if (appet.get(j).getFoodName().equals(name)) {
					appet.remove(j);
				}
			}
		} else if (fType == FoodType.Drinks) {
			for (int j = 0; j < drinks.size(); j++) {
				if (drinks.get(j).getFoodName().equals(name)) {
					drinks.remove(j);
				}
			}
		} else if (fType == FoodType.Dessert) {
			for (int j = 0; j < dessert.size(); j++) {
				if (dessert.get(j).getFoodName().equals(name)) {
					dessert.remove(j);
				}
			}
		} else {
			for (int j = 0; j < mainCourse.size(); j++) {
				if (mainCourse.get(j).getFoodName().equals(name)) {
					mainCourse.remove(j);
				}
			}
		}

		System.out.println("Food Item removed from Menu");

	}

	/**
	 * Prints current Menu according the categories Appetizer, MainCourse, Dessert,
	 * Drinks
	 */

	public static void printMenu() {
		System.out.println("Appetizers");
		System.out.println("=============================================");
		for (int s = 0; s < appet.size(); s++) {
			System.out.printf("%s %s %s", String.format("%-20s", appet.get(s).getFoodName()),
					String.format("%-20s", Double.toString(appet.get(s).getFoodPrice())),
					String.format("%-20s", appet.get(s).getFoodDesc()));
		}

		System.out.println("MainCourse");
		System.out.println("=============================================");
		for (int s = 0; s < mainCourse.size(); s++) {
			System.out.printf("%s %s %s", String.format("%-20s", mainCourse.get(s).getFoodName()),
					String.format("%-20s", Double.toString(mainCourse.get(s).getFoodPrice())),
					String.format("%-20s", mainCourse.get(s).getFoodDesc()));
		}

		System.out.println("Dessert");
		System.out.println("=============================================");
		for (int s = 0; s < dessert.size(); s++) {
			System.out.printf("%s %s %s", String.format("%-20s", dessert.get(s).getFoodName()),
					String.format("%-20s", Double.toString(dessert.get(s).getFoodPrice())),
					String.format("%-20s", dessert.get(s).getFoodDesc()));
		}

		System.out.println("Drinks");
		System.out.println("=============================================");
		for (int s = 0; s < drinks.size(); s++) {
			System.out.printf("%s %s %s", String.format("%-20s", drinks.get(s).getFoodName()),
					String.format("%-20s", Double.toString(drinks.get(s).getFoodPrice())),
					String.format("%-20s", drinks.get(s).getFoodDesc()));
		}

	}

	/**
	 * Returns the menu ArrayList
	 * 
	 * @return MenuMgr's menu
	 */
	public static ArrayList<FoodItem> getMenuList() {
		return menu;
	}

}
