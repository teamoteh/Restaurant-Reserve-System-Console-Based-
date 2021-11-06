// package UI;

// import java.util.Scanner;
// import java.util.Set;
// import java.util.HashSet;
// import java.util.ArrayList;
// import java.text.DateFormatSymbols;
// import java.util.Collections;

// import Entities.FoodItem;
// import Entities.Order;
// import Manager.OrderMgr;

// // Sale revenue report will detail the period, individual sale items (either
// ala carte or
// // promotional items) and total revenue.

// public class SalesReportUI {

// private static Scanner sc = new Scanner(System.in);
// private static ArrayList<Order> invoiceList = OrderMgr.getInvoiceList();
// // private static ArrayList<Menu> menuItemList = Restaurant.menu;
// // UI provided to display list of actions that can be performed on
// Restaurant's Invoices

// public static void displaysalesInvoiceUI() {
// int choice;
// do {
// System.out.println("\nWhich Sales Report to view?\n");

// System.out.println("[1] - View Individual Sales Revenue (Month)");
// System.out.println("[2] - Exit");
// // System.out.println("[2] - View List of Sales Revenue (Month)");

// // Error catching
// do {
// choice = sc.nextInt();
// } while (choice < 1 || choice > 2);

// switch (choice) {
// case 1:
// System.out.println("\nWhich month to view?\n");
// int month = sc.nextInt();
// printSalesRevenueReport(month);
// break;
// case 2:
// return;
// }
// } while (true);
// }

// /**
// * Print the sales revenue report for a specified month
// * and year. Revenue and quantity sold for each product
// * for that time period is reported.
// * @param month Month for statistics to be reported
// */
// public static void printSalesRevenueReport(int month){
// double totalRevenue = getPeriodTotalRevenue(month);
// String monthName = new DateFormatSymbols().getMonths()[month-1]; // Convert
// int month to string month name
// System.out.println(String.format("%30s",
// "================================================="));
// System.out.println("\nSales Revenue Report for " + monthName);
// System.out.println("Total Sales Revenue: " + totalRevenue);
// System.out.println("Total Number of Food Products: ");
// getPeriodProductStatistics(month);
// System.out.println();
// }

// /**
// * Find the total revenue made for a reporting
// * period
// * @param month Month for statistics to be reported
// * @return Total revenue for reporting period
// */
// private static double getPeriodTotalRevenue(int month){
// double totalSum = 0;

// for (Order order: invoiceList) {
// if ((order.getTimeStamp().getMonth()) + 1 == month) {
// for (FoodItem item : order.getOrderItems()) {
// totalSum += item.getFoodPrice();
// }
// }
// }
// double totalRoundOff = Math.round(totalSum *1.17 * 100.0)/100.0;
// return totalRoundOff;

// }

// /**
// * Find the quantity sold for each menu item in
// * a reporting period
// * @param month Month for statistics to be reported
// * @param year Year for statistics to be reported
// * @return Array containing quantity sold for each menu item
// */

// private static void getPeriodProductStatistics(int month){

// ArrayList<FoodItem> totalFoodDetail = new ArrayList<FoodItem>();

// for (Order order: invoiceList) {
// if ((order.getTimeStamp().getMonth()) + 1 == month) {
// // for (FoodItem item : order.getOrderItems()) {
// // totalFoodDetail.add(item);
// // }
// totalFoodDetail = order.getOrderItems();
// }
// }

// // gets unique name
// Set<FoodItem> unique = new HashSet<FoodItem>(totalFoodDetail);

// System.out.println(String.format("%30s",
// "================================================="));
// for (FoodItem key : unique) {
// System.out.println(key + ": " + Collections.frequency(totalFoodDetail, key));
// }
// }
// }