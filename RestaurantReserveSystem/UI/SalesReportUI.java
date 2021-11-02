package ui;

import java.util.Scanner;
import java.util.ArrayList;

import java.util.Calendar;
import java.text.DateFormatSymbols;
import java.util.Collections;

import Entities.FoodItem;
import Entities.MenuItem;
import Entities.Order;
import db.Restaurant;
import Manager.OrderMgr;

// Sale revenue report will detail the period, individual sale items (either ala carte or
// promotional items) and total revenue.

public class SalesInvoiceUI {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Order> orderList = Restaurant.orders;
    private static ArrayList<Menu> menuItemList = Restaurant.menu;
	// UI provided to display list of actions that can be performed on Restaurant's Invoices

	public static void salesInvoiceMainOption() {
		int choice;
		do {
			System.out.println("\nWhich Sales Report to view?\n");

			System.out.println("[1] - View Sales Revenue (Day)");
			System.out.println("[2] - View Sales Revenue (Month)");
			System.out.println("[3] - View List of invoices by month");
			System.out.println("[0] - Go Back");

			// Error catching
			do {
				choice = sc.nextInt();
			} while (choice < 0 || choice > 3);

			switch (choice) {
			case 1:
				viewSaleDayUi();
				break;
			case 2:
				viewSaleMthUi();
				break;
			case 3:
				viewSale();
				break;
			case 0:
				return;
			}
		} while (true);
	}

	/**
	 * Print the sales revenue report for a specified month
	 * and year. Revenue and quantity sold for each product
	 * for that time period is reported.
	 * @param month Month for statistics to be reported
	 */
	public static void printSalesRevenueReport(int month){
		double totalRevenue = getPeriodTotalRevenue(month);
		
		String monthName = new DateFormatSymbols().getMonths()[month-1];
		System.out.println(String.format("%30s", "================================================="));
		System.out.println("\nSales Revenue Report for " + monthName);
		System.out.println("Total Sales Revenue: " + totalRevenue);
		System.out.println("Total Number of Food Products: ");
		getPeriodProductStatistics(month);
		System.out.println();
	}
	
	/**
	 * Find the total revenue made for a reporting
	 * period
	 * @param month Month for statistics to be reported
	 * @return Total revenue for reporting period
	 */
	private static double getPeriodTotalRevenue(int month){
		double totalSum = 0;
		
		for (Order order: orderList) {
			if ((order.getDateGenerated().get(Calendar.MONTH) + 1 == month)){
				for (FoodItem item : order.get(i).getOrderItems()) {
					totalSum += item.getFoodPrice();
				}
			}
		}
		double totalRoundOff = Math.round(totalSum * 100.0)/100.0;
		return totalRoundOff;

	}
	
	/**
	 * Find the quantity sold for each menu item in
	 * a reporting period
	 * @param month Month for statistics to be reported
	 * @param year Year for statistics to be reported
	 * @return Array containing quantity sold for each menu item
	 */
	
	private static int[] getPeriodProductStatistics(int month){
		
		ArrayList<FoodItem> totalFoodDetail = new ArrayList<FoodItem>();

		for (Order order: orderList) {
			if (order.getTimestamp().get(Calendar.MONTH) + 1 == month) {
				for (FoodItem item : order.get(i).getOrderItems()) {
					totalFoodDetail.add(item);
				}
			}
		}

		// gets unique name
		Set<String> unique = new HashSet<String>(totalFoodDetail);

		System.out.println(String.format("%30s", "================================================="));
		// get fooditem name : occurence
		for (String key : unique) {
			System.out.println(key + ": " + Collections.frequency(totalFoodDetail, key));
		}
	}
}