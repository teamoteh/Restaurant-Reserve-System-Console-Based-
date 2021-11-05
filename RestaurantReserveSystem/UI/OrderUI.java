package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.Table;
import Entities.Staff;
import Entities.Order;
import Manager.OrderMgr;
import Manager.TableMgr;

// Boundary class that provides UI for users to perform actions on Order Objects

public class OrderUI {
	// UI provided to user showing actions that can be performed by user
	private static Scanner sc = new Scanner(System.in);

	public static void displayOrder_UI() {
		int choice;
		while (true) {
			// UI Display option
			System.out.println("\nORDER UI");
			System.out.println("[1] - View Current Orders");
			System.out.println("[2] - Create Order");
			System.out.println("[3] - Modify Order");
			System.out.println("[4] - Remove Order");
			System.out.println("[5] - Make Payment");
			System.out.println("[0] - Return");

			// Error Catching (input)
			do {
				choice = sc.nextInt();
			} while (choice < 0 || choice > 5);

			// Option
			switch (choice) {
			case 0:
				return;
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
		ArrayList<Order> orderList = OrderMgr.getOrderList();

		if (orderList.size() < 1) {
			System.out.println("There are no orders");
			return;
		}

		while (true) {
			index = 1;
			// Print out all orders
			System.out.println("\nWhich order do you want more details on?");
			System.out.println("0. " + "Return");
			for (Order order : orderList)
				System.out.println((index++) + ". " + order.getName());

			// Error Catching (input)
			do {
				choice = sc.nextInt();
			} while (choice < 0 || choice >= orderList.size());

			if (choice == 0)
				return;

			// Print selected order details
			OrderMgr.printOrderDetails(orderList.get(choice - 1));
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
		ArrayList<Table> tList = new ArrayList<Table>();
		ArrayList<Table> tableList = OrderMgr.getRestaurantTables();
		// int index = 0;
		int choice;

		System.out.println(
				"These are the list of available tables in the restaurant, please choose according to your pax ?");
		tList = TableMgr.findAvailTables(tList);
		for (int i = 0; i < tList.size(); i++) {
			int tableNO = tList.get(i).getTableNo();
			int tableSeat = tList.get(i).getMaxNumSeats();
			System.out.println(+i + ". " + "TableNo: " + tableNO + "\t Available Seats: " + tableSeat);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Input your choice of table: ");

		do {
			choice = sc.nextInt();
		} while (choice < 0 || choice > tList.size());

		int userTable = tableList.get(choice).getTableNo();
		sc.close();
		return tableList.get(userTable);
	}

	// Internal method use to select Staff for new Orders
	private static Staff selectStaffUI() {
		int index = 0, choice;

		ArrayList<Staff> staffList = OrderMgr.getRestaurantStaff();
		System.out.println("Which Staff is keying this order ?");
		for (Staff staff : staffList)
			System.out.println((index++ + 1) + ". " + staff.toString());

		do {
			choice = sc.nextInt();
		} while (choice < 1 || choice > index);

		return staffList.get(choice - 1);

	}

	// UI Provided to user to add / delete Orders from an Order Object
	private static void modifyOrderUI() {
		int index, choice;

		index = 0;
		ArrayList<Order> orderList = OrderMgr.getOrderList();

		if (orderList.size() < 1) {
			System.out.println("There are no orders currently, You must have at least 1 order to modify an order");
			return;
		}

		System.out.println("\nThese are the current orders, which do you want to modify ?");
		System.out.println("[" + (0) + "] - " + "Exit");
		for (Order order : orderList)
			System.out.println((index++ + 1) + ". " + order.getName());

		do {
			choice = sc.nextInt();
		} while (choice < 0 || choice > index);

		if (choice == 0)
			return;

		System.out.println("\nDo you want to add or remove items to the order");
		System.out.println("0. Exit");
		System.out.println("1. Add");
		System.out.println("2. Remove");
		int choice_1;

		do {
			choice_1 = sc.nextInt();
		} while (choice_1 < 0 || choice_1 > 2);

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
		int index = 0, choice;
		ArrayList<Order> orderList = OrderMgr.getOrderList();

		if (orderList.size() < 1) {
			System.out.println("There are no orders currently, You must have at least 1 order to remove an order");
			return;
		}
		System.out.println("Which order do you want to remove?");
		System.out.println((0) + ". Exit");
		for (Order order : orderList)
			System.out.println((index++ + 1) + ". " + order.getName());

		do {
			choice = sc.nextInt();
		} while (choice < 0 || choice > index);

		if (choice == 0)
			return;

		OrderMgr.removeOrder(choice - 1);

	}

	// Provides UI for choosing the specific order to be paid for
	private static void makePaymentUI() {
		int index = 1, choice;
		ArrayList<Order> orderList = OrderMgr.getOrderList();

		if (orderList.size() < 1) {
			System.out.println("There are no orders currently, You must have at least 1 order to complete an order");
			return;
		}

		System.out.println("Which of the following is the order being paid for?");
		System.out.println("0. Exit");
		for (Order order : orderList)
			System.out.println((index++) + ". " + order.getName());

		do {
			choice = sc.nextInt();
		} while (choice < 0 || choice > index);

		if (choice == 0)
			return;

		OrderMgr.completeOrder(choice - 1);
	}
}
