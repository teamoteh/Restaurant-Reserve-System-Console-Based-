package UI;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.text.DateFormatSymbols;
import java.util.Collections;

import Entities.FoodItem;
import Entities.Order;
import Entities.SetPromo;
import Manager.OrderMgr;

// Sale revenue report will detail the period, individual sale items (either ala carte or promotional items) and total revenue.

public class SalesReportUI {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Order> invoiceList = OrderMgr.getInvoiceList();
    // private static ArrayList<Menu> menuItemList = Restaurant.menu;
    // UI provided to display list of actions that can be performed on
    // Restaurant'sInvoices

    public static void displaysalesInvoiceUI() {
        int choice;
        do {
            System.out.println("\nWhich Sales Report to view?\n");

            System.out.println("[1] - View Individual Sales Revenue (Month)");
            System.out.println("[2] - Exit");

            // Error catching
            do {
                choice = sc.nextInt();
            } while (choice < 1 || choice > 2);

            switch (choice) {
            case 1:
                System.out.println("\nWhich month to view?\n");
                int month = sc.nextInt();
                printSalesRevenueReport(month);
                break;
            case 2:
                return;
            }
        } while (true);
    }

    /**
     * Print the sales revenue report for a specified month and year. Revenue and
     * quantity sold for each product for that time period is reported.
     * 
     * @param month Month for statistics to be reported
     */
    public static void printSalesRevenueReport(int month) {
        double totalRevenue = getPeriodTotalRevenue(month);
        String monthName = new DateFormatSymbols().getMonths()[month - 1]; // Convert int month to string month name
        System.out.println("=================== SALES REPORT =====================");
        System.out.println("\nSales Revenue Report for " + monthName);
        System.out.println("Total Sales Revenue: $" + totalRevenue);
        System.out.println("Total Number of Food Products: ");
        getPeriodProductStatistics(month);
        System.out.println();
    }

    /**
     * Find the total revenue made for a reporting month
     * 
     * @param month Month for statistics to be reported
     * @return Total revenue for reporting period
     */
    private static double getPeriodTotalRevenue(int month) {
        double totalSum = 0;

        for (Order order : invoiceList) {
            String input_date = order.getTimeStamp(); // YYYY-MM-DD
            String input_month = input_date.substring(5, 7); // MM
            String string_month = String.valueOf(month); // Convert input integer to string

            // Checking through the invoice to get the matching month
            if (string_month.equals(input_month)) {
                // Summing the A' la carte
                for (FoodItem item : order.getOrderItems()) {
                    totalSum += item.getFoodPrice();
                }
                // Summing the PromoItem
                for (SetPromo item : order.getOrderPromo()) {
                    totalSum += item.getPromoPrice();
                }
            }
        }
        double totalRoundOff = Math.round(totalSum * 1.17 * 100.0) / 100.0;
        return totalRoundOff;
    }

    /**
     * Display the quantity sold for each menu item in a reporting month
     * 
     * @param month Month requested
     */

    private static void getPeriodProductStatistics(int month) {
        ArrayList<FoodItem> totalFoodDetail = new ArrayList<FoodItem>();
        ArrayList<SetPromo> totalPromoDetail = new ArrayList<SetPromo>();

        for (Order order : invoiceList) {
            String input_date = order.getTimeStamp(); // YYYY-MM-DD
            String input_month = input_date.substring(5, 7); // MM
            String string_month = String.valueOf(input_month); // Convert input integer to string

            // Checking through the invoice to get the matching month
            if (string_month.equals(input_month)) {
                ArrayList<FoodItem> foodList = order.getOrderItems();
                ArrayList<SetPromo> promoList = order.getOrderPromo();

                // To add individual food item into the collection list
                for (FoodItem food : foodList) {
                    totalFoodDetail.add(food);
                }
                for (SetPromo set : promoList) {
                    totalPromoDetail.add(set);
                }
            }
        }

        // gets unique name
        Set<FoodItem> unique1 = new HashSet<FoodItem>(totalFoodDetail);
        Set<SetPromo> unique2 = new HashSet<SetPromo>(totalPromoDetail);

        System.out.println("=================== A' LA CARTE ======================");
        for (FoodItem key : unique1) {
            System.out.println(key.getFoodName() + ": " + Collections.frequency(totalFoodDetail, key));
        }
        System.out.println("=================== SET PROMO ========================");
        for (SetPromo key : unique2) {
            System.out.println(key.getPromoName() + ": " + Collections.frequency(totalPromoDetail, key));
        }
        System.out.println("======================================================");
    }
}