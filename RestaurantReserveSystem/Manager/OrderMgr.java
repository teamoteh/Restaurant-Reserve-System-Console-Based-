package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.*;
import Manager.*; // It is in used, ignore error. See line 17~19


// import Entities.Restaurant;

public class OrderMgr {
    ////////////////// NEED TO CHECK WITH TEAM MATES /////////////
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Order> orderList = new ArrayList<Order>();
    private static ArrayList<Order> invoiceList = new ArrayList<Order>();
    private static ArrayList<FoodItem> FoodItemList = MenuMgr.getMenu();
    private static ArrayList<Table> tableList = TableMgr.getTableList();
    private static ArrayList<Staff> staffList = StaffMgr.getStaffList();

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
        System.out.println("*********************** RECEIPT ***************************");
        System.out.println("Order ID \t: " + order.getName());
        System.out.println("Staff \t\t: " + order.getStaff().getStaffName());
        System.out.println("Table ID\t: " + order.getTable().getTableNo());
        System.out.println("DateTime \t: " + order.getTimeStamp().toString());
        System.out.println("Membership Discount: \t " + order.getMemberDiscount());

        System.out.println("\n\t================= ORDERS MADE =================\t\n");
        double sum = 0;
        int index = 1;
        for (FoodItem item : order.getOrderItems()) {
            System.out.println((index++) + ". " + item.getFoodName() + " - " + item.getFoodPrice());
            sum += item.getFoodPrice();
        }
        // MEMBER DISCOUNT
        if (order.getMemberDiscount()){
            sum = sum * 0.8;
        }
        System.out.printf("\nSUBTOTAL\t\t:%.2f \n", sum);
        System.out.printf("GST ( 7%% )\t\t:%.2f \n", sum * 0.07);
        System.out.printf("SERVICE TAX ( 10 %% )\t:%.2f \n", sum * 0.10);
        System.out.printf("GRAND TOTAL\t\t:%.2f \n", sum * 1.17);
        System.out.println("*********************** RECEIPT END ***********************");
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
            // ArrayList<Integer> temp = new ArrayList<Integer>();

            if (FoodItemList.size() < 1) {
                System.out.println("There are no items in the menu");
                break;
            }

            System.out.println();
            System.out.println("Which food would you like to add to the [" + order.getName() + "] Order?");

            for (int i = 0; i < FoodItemList.size(); i++) {
                if (FoodItemList.get(i) instanceof FoodItem) {
                    System.out.println("[" + (index++) + "] - " + FoodItemList.get(i).getFoodName());
                    // temp.add(i);
                }
            }

            System.out.println();
            do {
                opt = sc.nextInt();
            } while (opt < 1 || opt > index);

            // FoodItem food = (FoodItem) FoodItemList.get(temp.get(opt - 1));
            FoodItem food = (FoodItem) FoodItemList.get(opt-1);
            order.addItem(food);
            System.out.println(food.getFoodName() + " was successfully add to [" + order.getName() + "] Order");

            // order.add(FoodItemList);

            // Repeater
            System.out.println("Input \"Y\" to add more food to the order, or other characters to stop adding");
            choice = sc.nextLine();
        } while (choice.toUpperCase().equals(compare));

        return order;
    }

    // Removes FoodItem Items from the order
    // input: order - Order to be modified
    public static void removeFoodItemFromOrder(Order order) {
        int opt;
        // Sanity check
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
                    System.out.println("Which food would you like to remove from the " + order.getName() + " Invoice?");
                    // UI Display removable item
                    int index = 0;
                    for (FoodItem item : order.getOrderItems())
                        System.out.println("[" + (index++) + "] : " + item.getFoodName());
                    System.out.println();

                    // Error catching (input)
                    do {
                        opt = sc.nextInt();
                    } while (opt < 0 || opt >= order.getOrderItems().size());

                    order.removeItem(opt);

                    // Repeater
                    System.out.println(
                            "Input \"Y\" to remove more food from the order, or other characters to stop adding");
                    choice = sc.nextLine();
                } while (choice.toUpperCase().equals(compare));
            }
        }
    }

    // Removes an entire order from Restaurant's orders
    // Input: index - index of "order" to remove from
    public static void removeOrder(int index) {
        String removedOrderName = orderList.get(index).getName();
        orderList.remove(index);
        System.out.println("Successfully removed " + removedOrderName + " from the list of current orders");
    }

    // Simulates the customer paying for his/her orde (Input: true or falsers
    // input: index - index of "order" in Restaurant Order which is to be completed
    public static void completeOrder(int index) {
        Order completedOrder = orderList.get(index);
        String removedOrderName = completedOrder.getName();
        System.out.println("Is the customer a member?");
        Boolean membership = sc.nextBoolean();
        completedOrder.setMemberDiscount(membership);
        completedOrder.getTable().setAvailStatus();
        
        // Shift this order to invoiceOrder
        invoiceList.add(completedOrder);
        // Remove this order from orderList
        orderList.remove(index);

        System.out.println("\n~~~~~~~This is the printed invoice~~~~~~~\n");
        printOrderDetails(completedOrder);
        System.out.println("\nSuccessfully completed [" + removedOrderName + "] Order");
    }
}