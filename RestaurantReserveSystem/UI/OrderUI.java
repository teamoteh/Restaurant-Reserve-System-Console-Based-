package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.Table;
import Entities.Staff;
import Entities.Order;
import Manager.OrderMgr;

// Boundary class that provides UI for users to perform actions on Order Objects

public class OrderUI {
	// UI provided to user showing actions that can be performed by user
	private static Scanner sc = new Scanner(System.in);

	public static void orderMainOptions() {
		int choice;
		while (true) {
			// UI Display option
			System.out.println("\nORDER UI");
			System.out.println("[1] - View Current Orders");
			System.out.println("[2] - Create Orders");
			System.out.println("[3] - Modify Orders");
			System.out.println("[4] - Remove Orders");
			System.out.println("[5] - Make Payment");
			System.out.println("[0] - Go Back");

			// Error Catching (input)
			do {
				choice = sc.nextInt();
			} while (choice < 0 || choice > 5);

			// Option
			switch (choice) {
			case 1:
				viewCurrentOrderUI();
				break;
			case 2:
				addNewOrderUI();
				break;
			case 3:
				modifyOrderUI();
				break;
			case 4:
				removeOrderUI();
				break;
			case 5:
				makePaymentUI();
				break;
			}
		}
	}

	// Display current order
	private static void viewCurrentOrderUI() {
		int index, choice;
		ArrayList<Order> orderList = OrderMgr.getRestaurantOrders();

		if (orderList.size() < 1) {
			System.out.println("There are no orders");
			return;
		}

		while (true) {
			index = 1;
			// Print out all orders
			System.out.println("\nWhich order do you want more details on?");
			System.out.println("[" + (0) + "] - " + "Return");
			for (Order order : orderList)
				System.out.println("[" + (index++) + "] - " + order.getName());

			// Error Catching (input)
			do {
				choice = sc.nextInt();
			} while (choice < 0 || choice >= orderList.size());

			if (choice == 0)
				break;

			// Print selected order details
			OrderMgr.printOrderDetails(orderList.get(choice));
		}
	}

	// UI to faciliate addition of new Order
	public static void addNewOrderUI() {
		Staff staff = selectStaffUI();
		Table table = selectTableUI();

		OrderMgr.addNewOrder(staff, table);
	}

	public static void addNewOrderUI(int tableId) {
		Staff staff = selectStaffUI();
		Table table = OrderMgr.getRestaurantTables().get(tableId);

		OrderMgr.addNewOrder(staff, table);
	}

	// Select table for new Orders
	private static Table selectTableUI() {
		int index = 0;

		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Table> tableList = OrderMgr.getRestaurantTables();
		System.out.println(
				"These are the list of available tables in the restaurant, please choose according to your pax ?");
		System.out.println("Choice\tTableID\tNumber of Seats");
		/////////////////////////////// Check if 30===================
		for (int i = 0; i < 30; i++) {
			try {
				/////////////////////////////////////////// wait for jovian
				if (entities.Restaurant.tables.get(i).isOccupied == false
						&& entities.Restaurant.sessionReservations.get(i).tableReservation == null) {
					System.out.println("[" + (index++ + 1) + "] - " + "\t" + entities.Restaurant.tables.get(i).tableId
							+ "\t" + entities.Restaurant.tables.get(i).numOfSeats);
					temp.add(entities.Restaurant.tables.get(i).tableId);
				}
			} catch (IndexOutOfBoundsException e) {
				if (entities.Restaurant.tables.get(i).isOccupied == false) {
					System.out.println("[" + (index++ + 1) + "] - " + "\t" + entities.Restaurant.tables.get(i).tableId
							+ "\t" + entities.Restaurant.tables.get(i).numOfSeats);
					temp.add(entities.Restaurant.tables.get(i).tableId);
				}
			}
		}
		int choice = CusScanner.nextInt(1, index);
		choice = temp.get(choice - 1);
		for (Table table : tableList)
			if (table.tableId == choice)
				return table;
		return tableList.get(0);

	}

	// Internal method use to select Staff for new Orders
	private static Staff selectStaffUI() {
		int index = 0;

		ArrayList<Staff> staffList = OrderMgr.getRestaurantStaff();
		System.out.println("Which Staff is keying this order ?");
		for (Staff staff : staffList)
			System.out.println("[" + (index++ + 1) + "] - " + staff.toString());

		int choice = CusScanner.nextInt(1, index);

		return staffList.get(choice - 1);

	}

	// UI Provided to user to add / delete Orders from an Order Object
	private static void modifyOrderUI() {
		int index, choice;

		index = 0;
		ArrayList<Order> orderList = OrderMgr.getRestaurantOrders();

		if (orderList.size() < 1) {
			System.out.println("There are no orders currently, You must have at least 1 order to modify an order");
			return;
		}

		System.out.println("\nThese are the current orders, which do you want to modify ?");
		for (Order order : orderList)
			System.out.println("[" + (index++ + 1) + "] - " + order.getName());
		System.out.println("[" + (0) + "] - " + "Back");

		choice = CusScanner.nextInt(0, index);

		if (choice == 0)
			return;

		System.out.println("\nDo you want to add or remove items to the order");
		System.out.println("[1] - Add");
		System.out.println("[2] - Remove");
		System.out.println("[0] - Back");
		int choice_1;

		choice_1 = CusScanner.nextInt(0, 2);
		switch (choice_1) {
		case 1:
			OrderMgr.addFoodItemToOrder(orderList.get(choice - 1));
			break;
		case 2:
			OrderMgr.removeFoodItemFromOrder(orderList.get(choice - 1));
			break;
		case 0:
			break;
		}

	}

	// UI Provided to user to remove an Order from the Restaurant's current list of
	// orders
	private static void removeOrderUI() {
		int index = 0;
		ArrayList<Order> orderList = OrderMgr.getRestaurantOrders();

		if (orderList.size() < 1) {
			System.out.println("There are no orders currently, You must have at least 1 order to remove an order");
			return;
		}
		System.out.println("Which Order you wanna remove?");
		for (Order order : orderList)
			System.out.println("[" + (index++ + 1) + "] - " + order.getName());
		System.out.println("[" + (0) + "] - Back");

		int choice = CusScanner.nextInt(0, index);
		if (choice == 0)
			return;

		OrderMgr.removeOrder(choice - 1);

	}

	// Provides UI for choosing the specific order to be paid for
	private static void makePaymentUI() {
		int index = 0;
		ArrayList<Order> orderList = OrderMgr.getRestaurantOrders();

		if (orderList.size() < 1) {
			System.out.println("There are no orders currently, You must have at least 1 order to complete an order");
			return;
		}

		System.out.println("Which of the following is the order being paid for?");
		for (Order order : orderList)
			System.out.println("[" + (index++ + 1) + "] - " + order.getName());
		System.out.println("[" + (0) + "] - Back");

		int choice = CusScanner.nextInt(0, index);
		if (choice == 0)
			return;

		OrderMgr.completeOrder(choice - 1);
	}
}
