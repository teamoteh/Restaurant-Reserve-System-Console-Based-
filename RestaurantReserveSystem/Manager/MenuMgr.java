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

	/*
	 * public static MenuMgr() { appet = new ArrayList<FoodItem>(); dessert = new
	 * ArrayList<FoodItem>(); mainCourse = new ArrayList<FoodItem>(); drinks = new
	 * ArrayList<FoodItem>(); menu = new ArrayList<FoodItem>(); }
	 * 
	 * public static void addAppetizer() { FileReaderWriter fi1 = new
	 * FileReaderWriter(); try { fi1.getAppetizer(MenuMgr.appet); } catch
	 * (FileNotFoundException e) { e.printStackTrace(); } }
	 * 
	 * public static void addDessert() { FileReaderWriter fi2 = new
	 * FileReaderWriter(); try { fi2.getDessert(dessert); } catch
	 * (FileNotFoundException e) { e.printStackTrace(); } }
	 * 
	 * public static void addDrink() { FileReaderWriter fi = new FileReaderWriter();
	 * try { fi.getDrinks(drinks); } catch (FileNotFoundException e) {
	 * e.printStackTrace(); } }
	 * 
	 * 
	 * public static void addMainCourse() { FileReaderWriter fi3 = new
	 * FileReaderWriter(); try { fi3.getMainCourse(mainCourse); } catch
	 * (FileNotFoundException e) { e.printStackTrace(); } }
	 */

	public static ArrayList<FoodItem> getMenu() {
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

	public static void addToMenu(String name, double price, String desc, String type) {
		FoodType ftype = FoodType.Drinks; // Default value will change if it
		// soemthing else
		// FoodType ftype;
		for (int i = 0; i < FoodType.values().length; i++) {
			if (FoodType.values()[i].toString() == type) {
				ftype = FoodType.values()[i];
			}
		}
		FoodItem item = new FoodItem(name, price, desc, ftype);
		menu.add(item);

		// String file_Name = item.getFoodType().toString();

		/*
		 * try { FileWriter myWriter = new FileWriter(file_Name + ".txt");
		 * myWriter.write(item.getFoodName() + ", " + item.getFoodPrice() + "," +
		 * item.getFoodDesc() + ","); myWriter.close(); } catch (IOException e) {
		 * System.out.println("An error occurred."); e.printStackTrace(); }
		 */
	}

	public static void updateToMenu(String name, String newName, double newPrice, String newDesc, String newType) {
		FoodType ftype = FoodType.Drinks; // Default value will change if it soemthing else
		for (int i = 0; i < FoodType.values().length; i++) {
			if (FoodType.values()[i].toString() == newType) {
				ftype = FoodType.values()[i];
			}
		}

		for (int j = 0; j < menu.size(); j++) {
			if (menu.get(j).getFoodName() == name) {
				menu.get(j).setFoodName(newName);
				menu.get(j).setFoodPrice(newPrice);
				menu.get(j).setFoodDesc(newDesc);
				menu.get(j).setFoodType(ftype);
			}
		}

		// Need to implement writing to text file;
	}

	public static void removeFromMenu(String name) {
		for (int j = 0; j < menu.size(); j++) {
			if (menu.get(j).getFoodName() == name) {
				menu.remove(j);
			}
		}
	}

	public static void printMenu() {
		System.out.println("Name       Price        Description       Food Type");
		for (int s = 0; s < menu.size(); s++) {
			System.out.println(menu.get(s).getFoodName() + "     " + menu.get(s).getFoodPrice() + "     "
					+ menu.get(s).getFoodDesc() + "     " + menu.get(s).getFoodType());
		}
	}

	public static void printDrinks() {
		int size = drinks.size();
		for (int i = 0; i < size; i++) {
			System.out.println(drinks.get(i).getFoodName());
			System.out.println(drinks.get(i).getFoodPrice());
			System.out.println(drinks.get(i).getFoodDesc());
			System.out.println();
		}
	}

	public static void printAppetizer() {
		int size = appet.size();
		for (int i = 0; i < size; i++) {
			System.out.println(appet.get(i).getFoodName());
			System.out.println(appet.get(i).getFoodPrice());
			System.out.println(appet.get(i).getFoodDesc());
			System.out.println();
		}
	}

	public static void printDessert() {
		int size = dessert.size();
		for (int i = 0; i < size; i++) {
			System.out.println(dessert.get(i).getFoodName());
			System.out.println(dessert.get(i).getFoodPrice());
			System.out.println(dessert.get(i).getFoodDesc());
			System.out.println();
		}
	}

	public static void printMainCourse() {
		int size = mainCourse.size();
		for (int i = 0; i < size; i++) {
			System.out.println(mainCourse.get(i).getFoodName());
			System.out.println(mainCourse.get(i).getFoodPrice());
			System.out.println(mainCourse.get(i).getFoodDesc());
			System.out.println();
		}
	}

	public static void deleteAppet(String name) {
		for (int i = 0; i < appet.size(); i++) {
			if (appet.get(i).getFoodName() == name) {
				appet.remove(i);
			}
		}
	}

	/*
	 * public void deleteDrink(String name) { for (int i = 0; i < drink.size(); i++)
	 * { if (drink.get(i).getFoodName() == name) { drink.remove(i); } } }
	 */

	public static void deleteDessert(String name) {
		for (int i = 0; i < dessert.size(); i++) {
			if (dessert.get(i).getFoodName() == name) {
				dessert.remove(i);
			}
		}
	}

	public void deleteMainCourse(String name) {
		for (int i = 0; i < mainCourse.size(); i++) {
			if (mainCourse.get(i).getFoodName() == name) {
				mainCourse.remove(i);
			}
		}
	}

}
