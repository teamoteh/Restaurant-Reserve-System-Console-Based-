package datatxt;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import Entities.FoodItem;
import Entities.Reservation;
import Entities.Table;
import Manager.TableMgr;

import java.util.ArrayList;

public class FileReaderWriter {

	public FileReaderWriter() {

	}

	/**
	 * @param address
	 * @param text
	 * @throws IOException
	 */
	public void write(String address, String text) throws IOException {
		try {
			FileWriter fw = new FileWriter(address, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			out.println(text);
			out.close();
			// more code
		} catch (IOException e) {
			// exception handling left as an exercise for the reader
		}
	}

	/**
	 * @param drinks
	 * @throws FileNotFoundException
	 */
	public void getDrinks(ArrayList<FoodItem> drinks) throws FileNotFoundException {
		File file = new File("RestaurantReserveSystem/datatxt/Drinks.txt");
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\s*,\\s*");

		do {
			String foodName = sc.next();
			double foodPrice = Integer.parseInt(sc.next());
			String foodDesc = sc.next();
			FoodItem.FoodType fType = FoodItem.FoodType.Drinks;

			FoodItem drink = new FoodItem(foodName, foodPrice, foodDesc, fType);
			drinks.add(drink);
		} while (sc.hasNextLine());
		sc.close();
	}

	/**
	 * @param appet
	 * @throws FileNotFoundException
	 */
	public void getAppetizer(ArrayList<FoodItem> appet) throws FileNotFoundException {
		File file = new File("RestaurantReserveSystem/datatxt/Appetizer.txt");
		//
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\s*,\\s*");

		do {
			String foodName = sc.next();
			double foodPrice = sc.nextDouble();
			String foodDesc = sc.next();
			FoodItem.FoodType fType = FoodItem.FoodType.Appetizer;

			FoodItem appetizer = new FoodItem(foodName, foodPrice, foodDesc, fType);
			appet.add(appetizer);
		} while (sc.hasNextLine());
		sc.close();
	}

	/**
	 * @param desserts
	 * @throws FileNotFoundException
	 */
	public void getDessert(ArrayList<FoodItem> desserts) throws FileNotFoundException {
		File file = new File("RestaurantReserveSystem/datatxt/Dessert.txt");
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\s*,\\s*");

		do {
			String foodName = sc.next();
			double foodPrice = sc.nextDouble();
			String foodDesc = sc.next();
			FoodItem.FoodType fType = FoodItem.FoodType.Dessert;

			FoodItem dessert = new FoodItem(foodName, foodPrice, foodDesc, fType);
			desserts.add(dessert);
		} while (sc.hasNextLine());
		sc.close();
	}

	/**
	 * @param mainCourses
	 * @throws FileNotFoundException
	 */
	public void getMainCourse(ArrayList<FoodItem> mainCourses) throws FileNotFoundException {
		File file = new File("RestaurantReserveSystem/datatxt/MainCourse.txt");
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\s*,\\s*");

		do {
			String foodName = sc.next();
			double foodPrice = sc.nextDouble();
			String foodDesc = sc.next();
			FoodItem.FoodType fType = FoodItem.FoodType.MainCourse;

			FoodItem mainCourse = new FoodItem(foodName, foodPrice, foodDesc, fType);
			mainCourses.add(mainCourse);
		} while (sc.hasNextLine());
		sc.close();
	}

	/**
	 * @param Reservations
	 * @throws FileNotFoundException
	 */
	public static void getReservation(ArrayList<Reservation> Reservations) throws FileNotFoundException {
		File file = new File("RestaurantReserveSystem/datatxt/Reservation.txt");
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\s*,\\s*");
		System.out.println(file.length());
		if (file.length() < 2) {
			sc.close();
			return;
		}
		while (sc.hasNextLine()) {
			LocalTime reserveTime = LocalTime.parse(sc.next());
			LocalDate reserveDate = LocalDate.parse(sc.next());
			int numOfPax = Integer.parseInt(sc.next());
			String custName = sc.next();
			int custContact = Integer.parseInt(sc.next());
			// System.out.println(custContact);
			int tableNum = Integer.parseInt(sc.next());
			Table table = null;
			for (int i = 0; i < TableMgr.getTableList().size(); i++) {
				if (TableMgr.getTableList().get(i).getTableNo() == tableNum) {
					table = TableMgr.getTableList().get(i);
				}
			}

			Reservation r = new Reservation(reserveTime, reserveDate, numOfPax, custName, custContact, table);

			Reservations.add(r);
		}
		sc.close();
	}

	/*
	 * Things to implement getReservation getTable getOrder getAppetizer
	 * getMainCourse getDessert getStaff getSetPromo
	 */

}
