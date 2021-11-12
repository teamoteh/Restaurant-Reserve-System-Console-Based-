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

/**
 * Details the Period, Individual sale items (either ala carte or promotional
 * items) and total revenue.
 * 
 * @author KaiSheng Lim
 * @version 1.0
 * @since 2021-11-12
 */

public class SalesReportUI {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Contains an Array List of Order Invoices
     */
    private static ArrayList<Order> invoiceList = OrderMgr.getInvoiceList();

    /**
     * Displays list of Order Invoices from Restaurant
     */
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
        double total = 0;
        for (Order invoice : invoiceList) {
            double totalSum = 0;
            String input_date = invoice.getTimeStamp(); // YYYY-MM-DD
            String input_month = input_date.substring(5, 7); // MM
            String string_month = String.valueOf(month); // Convert input integer to string

            // Checking through the invoice to get the matching month
            if (string_month.equals(input_month)) {
                // Summing the A' la carte
                for (FoodItem item : invoice.getOrderItems()) {
                    totalSum += item.getFoodPrice();
                }
                // Summing the PromoItem
                for (SetPromo item : invoice.getOrderPromo()) {
                    totalSum += item.getPromoPrice();
                }
            }
            // Check if Promotion was applied
            totalSum = invoice.getMemberDiscount() ? totalSum * 0.8 : totalSum;
            // Add in the charges
            totalSum *= 1.17;
            total += totalSum;
        }
        double totalRoundOff = Math.round(total * 100.0) / 100.0;
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
            String string_month = Integer.toString(month); // Convert input integer to string

            // System.out.println("input_month: " + input_month);
            // System.out.println("month: " + string_month);
            // Checking through the invoice to get the matching month
            if (string_month.equals(input_month)) {
                // To add individual food item into the collection list
                totalFoodDetail.addAll(order.getOrderItems());
                totalPromoDetail.addAll(order.getOrderPromo());
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