package UI;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.Table;
import Entities.Staff;
import Entities.Order;
import Manager.OrderMgr;
import Manager.TableMgr;

/**
 * Provides UI for users to perform actions on Order Entity Class using Order
 * Control Class
 * 
 * @author KaiSheng Lim
 * @version 1.0
 * @since 2021-11-12
 */
public class OrderUI {
	/**
	 * UI provided for user to perform request
	 */
	public static void displayOrder_UI() {
		Scanner sc = new Scanner(System.in);
		int choice;
		while (true) {
			// UI Display option
			System.out.println("\nORDER UI");
			System.out.println("1. View Current Orders");
			System.out.println("2. Create Order");
			System.out.println("3. Modify Order");
			System.out.println("4. Remove Order");
			System.out.println("5. Make Payment");
			System.out.println("6. Exit");

			// Error Catching (input)
			choice = Integer.parseInt(sc.nextLine());

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
			case 6:
				return;
			}
		}

	}

	/**
	 * Displays Current Order
	 */
	private static void viewCurrentOrderUI() {
		Scanner sc = new Scanner(System.in);
		int index, choice;
		ArrayList<Order> orderList = OrderMgr.getOrderList();

		// Sanity Check
		if (orderList.size() < 1) {
			System.out.println("There are no orders");
			return;
		}

		while (true) {
			index = 1;
			// Print out all orders
			System.out.println("\nWhich order do you want more details on?");
			System.out.println("======================= ORDERS =======================");
			for (Order order : orderList) {
				System.out.println((index++) + ". " + order.getName());
			}
			System.out.println(orderList.size() + 1 + ". Exit");
			System.out.println("======================================================");

			System.out.println("Input your choice of Order: ");
			// Error Checking: Ask user to input an option within the given range
			do {
				choice = sc.nextInt();
			} while (choice < 1 || choice > (index + 1));

			// To break the while Loop
			if (choice == index) {
				return;
			}

			// Print selected order details
			Order item = orderList.get(choice - 1);
			System.out.println("********************** PREVIEW ***********************\n");
			OrderMgr.printOrderDetails(item);
		}

	}

	/**
	 * UI to facilitate the addition of a new Order
	 */
	private static void addNewOrderUI() {
		Staff staff = selectStaffUI();
		Table table = selectTableUI();
		OrderMgr.addNewOrder(staff, table);
	}

	/**
	 * (Overload) UI to facilitate the addition of a new Order
	 *
	 * @param tableId
	 */
	private static void addNewOrderUI(int tableId) {
		Staff staff = selectStaffUI();
		Table table = OrderMgr.getRestaurantTables().get(tableId);

		OrderMgr.addNewOrder(staff, table);
	}

	/**
	 * UI to faciliate selection of Table for new Orders
	 *
	 * @return Table
	 */
	private static Table selectTableUI() {
		Scanner sc = new Scanner(System.in);
		int choice, index = 1;
		ArrayList<Table> tList = new ArrayList<Table>();

		// Get the available tables
		tList = TableMgr.findAvailTables(tList);

		// Print out the available tables
		System.out.println(
				"These are the list of available tables in the restaurant, please choose according to your pax ?");
		System.out.println("================= AVAILABLE TABLES ===================");
		for (Table table : tList) {
			int tableNO = table.getTableNo();
			int tableSeat = table.getMaxNumSeats();
			System.out.println((index++) + ". " + "TableNo: " + tableNO + "\t Available Seats: " + tableSeat);
		}
		System.out.println("======================================================");

		System.out.println("Input your choice of Table: ");
		// Error Checking: Ask user to input an option within the given range
		do {
			choice = sc.nextInt();
		} while (choice < 1 || choice > index);

		// sc.close();
		return tList.get(choice - 1);
	}

	/**
	 * UI to faciliate selection of Staff for new Orders
	 *
	 * @return Staff
	 */
	private static Staff selectStaffUI() {
		Scanner sc = new Scanner(System.in);
		int index = 1, choice;
		ArrayList<Staff> staffList = OrderMgr.getRestaurantStaff();

		// Print out the all staff
		System.out.println("======================= STAFF ========================");
		for (Staff staff : staffList) {
			System.out.println((index++) + ". " + staff.getStaffName());
		}
		System.out.println("======================================================\n");

		System.out.println("Input Staff keying this order: ");
		// Error Checking: Ask user to input an option within the given range
		do {
			choice = sc.nextInt();
		} while (choice < 1 || choice > index);

		return staffList.get(choice - 1);
	}

	/**
	 * UI Provided to user to modify (add/delete) Orders from an Order Object
	 */
	private static void modifyOrderUI() {
		Scanner sc = new Scanner(System.in);
		int index = 1, choice;
		ArrayList<Order> orderList = OrderMgr.getOrderList();

		// Sanity check
		if (orderList.size() < 1) {
			System.out.println("There are no orders currently");
			return;
		}

		// Print out all current orders
		System.out.println("\nThese are the current orders, please choose the order you wish to modify:");
		System.out.println("======================= ORDERS =======================");
		for (Order order : orderList) {
			System.out.println((index++) + ". " + order.getName());
		}
		System.out.println((index) + ". Exit");
		System.out.println("======================================================\n");

		System.out.println("Input your choice of order: ");
		// Error Checking: Ask user to input an option within the given range
		do {
			choice = sc.nextInt();
		} while (choice < 1 || choice > index);

		// If user choose to exit the UI
		if (choice == index) {
			return;
		}

		// Actual UI to modify the order
		System.out.println("\nDo you want to add or remove items from the order ?");
		System.out.println("1. Add Item");
		System.out.println("2. Remove Item");
		System.out.println("3. Exit");
		int opt;

		// Error Checking: Ask user to input an option within the given range
		do {
			opt = sc.nextInt();
		} while (opt < 1 || opt > 3);

		switch (opt) {
		case 1:
			// Add item to order
			OrderMgr.addFoodItemToOrder(orderList.get(choice - 1));
			break;
		case 2:
			// Remove item from order
			OrderMgr.removeFoodItemFromOrder(orderList.get(choice - 1));
			break;
		case 3:
			// Exit the UI
			return;
		}
	}

	/**
	 * UI to provide user to remove an Order from the current list of orders
	 */
	private static void removeOrderUI() {
		Scanner sc = new Scanner(System.in);
		int index = 1, choice;
		ArrayList<Order> orderList = OrderMgr.getOrderList();

		// Sanity Check
		if (orderList.size() < 1) {
			System.out.println("There are no orders currently");
			// sc.close();
			return;
		}
		// Print out all current orders
		System.out.println("Which order do you want to remove ?");
		System.out.println("======================= ORDERS =======================");
		for (Order order : orderList) {
			System.out.println((index++) + ". " + order.getName());
		}
		System.out.println(index + ". Exit");
		System.out.println("======================================================");

		// Error Checking: Ask user to input an option within the given range
		do {
			choice = sc.nextInt();
		} while (choice < 0 || choice > index);

		// If user choose to exit
		if (choice == index) {
			return;
		}

		OrderMgr.removeOrder(choice - 1);
	}

	/**
	 * Provides UI for choosing which specific order to be paid for
	 */
	private static void makePaymentUI() {
		Scanner sc = new Scanner(System.in);
		int index = 1, choice;
		ArrayList<Order> orderList = OrderMgr.getOrderList();

		if (orderList.size() < 1) {
			System.out.println("There are no orders currently");
			return;
		}

		System.out.println("Which of order for payment ?");
		System.out.println("======================= ORDERS =======================");
		for (Order order : orderList) {
			System.out.println((index++) + ". " + order.getName());
		}
		System.out.println(index + ". Exit");
		System.out.println("======================================================");

		// Error Checking: Ask user to input an option within the given range
		do {
			choice = sc.nextInt();
		} while (choice < 0 || choice > index);

		// If user choose to exit
		if (choice == index) {
			return;
		}

		OrderMgr.completeOrder(choice - 1);
	}
}
