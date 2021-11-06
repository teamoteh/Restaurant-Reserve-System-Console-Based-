package Manager;

import datatxt.FileReaderWriter;

import java.io.FileNotFoundException;
import Entities.FoodItem;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import Entities.FoodItem.FoodType;

// figure out how to read from txt and need to update and delete correctly
public class MenuMgr {

	protected static ArrayList<FoodItem> appet = new ArrayList<FoodItem>();
	protected static ArrayList<FoodItem> dessert = new ArrayList<FoodItem>();
	protected static ArrayList<FoodItem> drinks = new ArrayList<FoodItem>();
	protected static ArrayList<FoodItem> mainCourse = new ArrayList<FoodItem>();
	protected static ArrayList<FoodItem> menu = new ArrayList<FoodItem>();

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
		/*
		 * for(int i = 0; i < appet.size(); i++) { for(int j = 0; j < menu.size(); j++)
		 * { if(appet.get(i).getFoodName().equals(menu.get(j).getFoodName())) { break; }
		 * } }
		 */
		menu.addAll(appet);
		menu.addAll(drinks);
		menu.addAll(dessert);
		menu.addAll(mainCourse);

		return menu;
	}

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

		/*
		 * Rewrites whole file if implemented String file_Name =
		 * item.getFoodType().toString();
		 * 
		 * try { FileWriter myWriter = new FileWriter("datatxt/" + file_Name + ".txt");
		 * myWriter.write("," + item.getFoodName() + ", " + item.getFoodPrice() + "," +
		 * item.getFoodDesc()); myWriter.close(); } catch (IOException e) {
		 * System.out.println("An error occurred."); e.printStackTrace(); }
		 */

	}

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

	public static void printMenu() {
		/*
		 * System.out.println("Name       Price        Description       Food Type");
		 * for (int s = 0; s < menu.size(); s++) {
		 * System.out.println(menu.get(s).getFoodName() + " " +
		 * menu.get(s).getFoodPrice() + " " + menu.get(s).getFoodDesc() + " " +
		 * menu.get(s).getFoodType()); }
		 */
		System.out.println("Appetizers");
		for (int s = 0; s < appet.size(); s++) {
			System.out.println(
					appet.get(s).getFoodName() + " " + appet.get(s).getFoodPrice() + " " + appet.get(s).getFoodDesc());
			// + " "+ appet.get(s).getFoodType()); //Don't actually have to print food Type
			// anymore
		}

		System.out.println("MainCourse");
		for (int s = 0; s < mainCourse.size(); s++) {
			System.out.println(mainCourse.get(s).getFoodName() + " " + mainCourse.get(s).getFoodPrice() + " "
					+ mainCourse.get(s).getFoodDesc());
			// + " " + mainCourse.get(s).getFoodType());
		}

		System.out.println("Dessert");
		for (int s = 0; s < dessert.size(); s++) {
			System.out.println(dessert.get(s).getFoodName() + " " + dessert.get(s).getFoodPrice() + " "
					+ dessert.get(s).getFoodDesc());
			// + " " + dessert.get(s).getFoodType());
		}

		System.out.println("Drinks");
		for (int s = 0; s < drinks.size(); s++) {
			System.out.println(drinks.get(s).getFoodName() + " " + drinks.get(s).getFoodPrice() + " "
					+ drinks.get(s).getFoodDesc());
			// + " " + drinks.get(s).getFoodType());
		}

	}

	public static ArrayList<FoodItem> getMenuList() {
		return menu;
	}

}
