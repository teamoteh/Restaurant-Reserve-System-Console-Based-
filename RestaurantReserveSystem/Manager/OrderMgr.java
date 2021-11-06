package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.*;
import Manager.*; // It is in used, ignore error. See line 17~19

// import Entities.Restaurant;

public class OrderMgr {
    //===================== NEED TO CHECK WITH TEAM MATES ============================
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Order> orderList = new ArrayList<Order>();     // List of current order that is unpaid
    private static ArrayList<Order> invoiceList = new ArrayList<Order>();   // List of exisiting order that has checkout as invoice
    private static ArrayList<SetPromo> PromoItemList = PromoMgr.getPromoList(); // Need tim inputs - changing to fooditem :)
    private static ArrayList<FoodItem> allFoodItemList = MenuMgr.getMenu(); // All food options
    private static ArrayList<Table> tableList = TableMgr.getTableList();    // Available tables for walk in order
    private static ArrayList<Staff> staffList = StaffMgr.getStaffList();    // For receipt

    // Need to check if
    // ArrayList<FoodItem> lsit = PromoItemList.getFoodList();

    // SetPromo
    // ArrayList<SetPromo> allFoodItemList = new ArrayList<FoodItem>()
    // for (SetPromo item : PromoItemList){
    // item.getPromo();
    // }

    // Retrieves List of Restaurant's Orders
    public static ArrayList<Order> getOrderList() {
        return orderList;
    }

    // Retrieves List of Restaurant's completed Orders
    public static ArrayList<Order> getInvoiceList() {
        return invoiceList;
    }

    // Retrieves List of Restaurant's Tables
    public static ArrayList<Table> getRestaurantTables() {
        return tableList;
    }

    // Retrieves List of Restaurant's Staff
    public static ArrayList<Staff> getRestaurantStaff() {
        return staffList;
    }

    // Prints the input Order's details
    // Input: order - Prints detail of input Order object
    public static void printOrderDetails(Order order) {
        System.out.println();
        System.out.println("======================= RECEIPT =======================");
        System.out.println("Order ID \t: " + order.getName());
        System.out.println("Staff \t\t: " + order.getStaff().getStaffName());
        System.out.println("Table ID\t: " + order.getTable().getTableNo());
        System.out.println("DateTime \t: " + order.getTimeStamp().toString());
        System.out.println("Membership Discount: \t " + (order.getMemberDiscount() ? "20% OFF APPLIED" : "N.A."));

        System.out.println("\n\t================= ORDERS MADE =================\t\n");
        double sum = 0;
        int index = 1;
        for (FoodItem item : order.getOrderItems()) {
            System.out.println((index++) + ". " + item.getFoodName() + " - " + item.getFoodPrice());
            sum += item.getFoodPrice();
        }
        // MEMBER DISCOUNT (20%)
        if (order.getMemberDiscount()) {
            sum = sum * 0.8;
        }
        System.out.printf("\nSUBTOTAL\t\t\t:%.2f \n", sum);
        System.out.printf("SERVICE TAX (10%%)\t:%.2f \n", sum * 0.10);
        System.out.printf("GST (7%%)\t\t\t:%.2f \n", sum * 0.07);
        System.out.printf("TOTAL DUE\t\t\t:$%.2f \n", sum * 1.17);
        System.out.println("============= THANK YOU FOR DINING WITH US ============");
        System.out.println();

    }

    // Adds a new order to the restaurant's Order List
    // input: staff - Staff who keys in the order
    // input: table - Table assigned to this order
    public static void addNewOrder(Staff staff, Table table) {
        Order newOrder = new Order(staff, table);
        table.setUnavailStatus();

        newOrder = addFoodItemToOrder(newOrder);
        orderList.add(newOrder);

    }

    // Adds FoodItems to the order
    // input: order - Order to be modified
    public static Order addFoodItemToOrder(Order order) {
        int opt;
        String choice = "", compare = "Y";
        do {
            int index = 1;

            // Sanity check for menu
            if (allFoodItemList.size() < 1) {
                System.out.println("There are no items in the menu");
                break;
            }

            // UI Display addable item
            System.out.println();
            System.out.println("======================= ALL ADDABLE FOOD ======================");
            System.out.println("Which food would you like to [add] to the [" + order.getName() + "] Order?");
            for (FoodItem item : order.getOrderItems()){
                System.out.println((index++) + ". " + item.getFoodName());
            }
            System.out.println("================================================================");

            System.out.println();

            System.out.println("Input your choice of addable food: ");
            // Error Checking: Ask user to input an options within the given range
            do {
                opt = sc.nextInt();
            } while (opt < 1 || opt > index);
            
            // Actual adding of food into Order
            FoodItem food = (FoodItem) allFoodItemList.get(opt - 1);
            order.addItem(food);
            System.out.println(food.getFoodName() + " was successfully add to [" + order.getName() + "] Order");

            // Repeater
            System.out.println("Do you want to [add] more food to the order? (Y/N)");
            choice = sc.nextLine();
        } while (choice.toUpperCase().equals(compare));

        return order;
    }

    // Removes FoodItem Items from the order
    // input: order - Order to be modified
    public static void removeFoodItemFromOrder(Order order) {
        int opt;

        // Sanity check for menu
        if (order.getOrderItems().size() < 1) {
            System.out.println("There are no items in this order");
            return;
        }
        // Removal of items
        else {
            while (order.getOrderItems().size() > 0) {
                String choice = "", compare = "Y";
                do {
                    // Prompt user
                    System.out.println("Which food would you like to [remove] from the [" + order.getName() + "] Invoice?");
                    
                    // UI Display removable item
                    System.out.println("====================== ALL REMOVABLE FOOD =====================");
                    int index = 0;
                    for (FoodItem item : order.getOrderItems()){
                        System.out.println("[" + (index++) + "] : " + item.getFoodName());
                    }
                    System.out.println("================================================================");
                    System.out.println();
                    
                    
                    System.out.println("Input your choice of removable food: ");
                    // Error Checking: Ask user to input an options within the given range
                    do {
                        opt = sc.nextInt();
                    } while (opt < 0 || opt > index);

                    order.removeItem(opt);

                    // Repeater
                    System.out.println("Do you want to [remove] more food from the order? (Y/N)");
                    choice = sc.nextLine();
                } while (choice.toUpperCase().equals(compare));
                
                // To break the while Loop
                return;
            }
        }
    }

    // Removes an entire order from Restaurant's orders
    // Input: index - index of "order" to remove from
    public static void removeOrder(int index) {
        String removedOrderName = orderList.get(index).getName();
        orderList.remove(index);
        System.out.println("Successfully removed [" + removedOrderName + "] from the list of current orders");
    }

    // To change the order status from unpaid to paid (Order becomes Invoice)
    // input: index - index of "order"
    public static void completeOrder(int index) {
        Order completedOrder = orderList.get(index);

        // During checkout, prompt user if he/she is a member to update attribute of Order for member discount
        System.out.println("Is the customer a member?");
        Boolean membership = sc.nextBoolean();
        completedOrder.setMemberDiscount(membership);

        // Update the table status to "available"
        completedOrder.getTable().setAvailStatus();
        
        // Printing of invoice 
        String removedOrderName = completedOrder.getName();
        System.out.println("Successfully completed [" + removedOrderName + "] Order");
        System.out.println("\n============ Printing invoice ============\n");
        printOrderDetails(completedOrder);

        // Shift order to invoice arraylist
        invoiceList.add(completedOrder);
        orderList.remove(index);
    }
}