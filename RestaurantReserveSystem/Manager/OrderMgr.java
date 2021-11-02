package Manager;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter; // Import the FileWriter class
import java.io.IOException; // Import the IOException class to handle errors

// import javax.sound.sampled.BooleanControl;

import Entities.Order;
import Entities.FoodItem;
import Entities.Table;
import Entities.Staff;
import db.Restaurant;

// import Entities.Restaurant;

public class OrderMgr {
    ////////////////// NEED TO CHECK WITH TEAM MATES /////////////
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Order> orderList = Restaurant.orders;
    private static ArrayList<FoodItem> FoodItemList = Restaurant.FoodItem;
    private static ArrayList<Table> tableList = Restaurant.tables;
    private static ArrayList<Order> invoiceList = Restaurant.invoices;
    private static ArrayList<Staff> staffList = Restaurant.staff;

    // Retrieves List of Restaurant's Orders
    public static ArrayList<Order> getRestaurantOrders() {
        return orderList;
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
        System.out.println("DateTime \t: " + order.getTimestamp().toString());

        System.out.println("\n\t================= ORDERS MADE =================\t\n");
        double sum = 0;
        int index = 1;
        for (FoodItem item : order.getOrderItems()) {
            // ===============================Check with Prawn====================
            // ==================Change all to foodItem instead of Menu?==========
            System.out.println((index++) + ". " + item.getFoodName() + " - " + item.getFoodPrice());
            sum += item.getPrice();
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
        table.isOccupied = true;

        newOrder = addFoodItemToOrder(newOrder);
        orderList.add(newOrder);

    }

    // Adds FoodItems to the order
    // input: order - Order to be modified
    // ==================Should this be menu instead of food? This is quite
    // confusing============================
    public static Order addFoodItemToOrder(Order order) {
        String choice = "", compare = "Y";
        do {
            int index = 1;
            ArrayList<Integer> temp = new ArrayList<Integer>();

            if (FoodItemList.size() < 1) {
                System.out.println("There are no items in the menu");
                break;
            }

            System.out.println();
            System.out.println("Which food would you like to add to the [" + order.getName() + "] Order?");

            for (int i = 0; i < FoodItemList.size(); i++) {
                if (FoodItemList.get(i) instanceof FoodItem) {
                    System.out.println("[" + (index++) + "] - " + FoodItemList.get(i).getFoodName());
                    temp.add(i);
                }
            }

            System.out.println();
            do {
                int option = sc.nextInt();
            } while (option < 1 || option > index);

            FoodItem food = (FoodItem) FoodItemList.get(temp.get(option - 1));
            orderList.add(food);
            System.out.println(food.getFoodName() + " was successfully add to [" + order.getName() + "] Order");

            order.addItem(FoodItemList);

            // Repeater
            System.out.println("Input \"Y\" to add more food to the order, or other characters to stop adding");
            choice = sc.nextLine();
        } while (choice.toUpperCase().equals(compare));

        return order;
    }

    // Removes FoodItem Items from the order
    // input: order - Order to be modified
    public static void removeFoodItemFromOrder(Order order) {
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
                        int option = sc.nextInt();
                    } while (option < 0 || option >= order.getOrderItems().size());

                    order.removeItem(option);

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

    // Simulates the customer paying for his/her orders
    // input: index - index of "order" in Restaurant Order which is to be completed
    public static void completeOrder(int index) {
        Order completedOrder = orderList.get(index);
        String removedOrderName = completedOrder.getName();
        completedOrder.setCheckOut(true);
        // ============== NEED TO CHECK WITH TEAMMATES==================
        completedOrder.getTable().isOccupied = false;
        // =============================================================
        invoiceList.add(completedOrder);

        orderList.remove(index);

        System.out.println("\n~~~~~~~This is the printed invoice~~~~~~~\n");
        printOrderDetails(completedOrder);
        System.out.println("\nSuccessfully completed [" + removedOrderName + "] Order");
    }

    // Add receipt to database
    // Sale revenue report will detail the period, individual sale items (either ala
    // carte or
    // promotional items) and total revenue.
    public static void addReceipt(ArrayList<Order> orderList) {
        try {
            FileWriter myWriter = new FileWriter("//datatxt/Order.txt");
            myWriter.write(order.getTimestamp().toString() + "," + order.getTotal()); // toString() is a library
                                                                                      // function. Nosuch getTotal function
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        do {
            int tableID = Integer.parseInt(sc.next());
            int tableMaxSeats = Integer.parseInt(sc.next());

            Table table = new Table(tableID, tableMaxSeats);
            tables.add(table);
        } while (sc.hasNextLine());
    }
}