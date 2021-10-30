package RestaurantReserveSystem.Manager;

import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.BooleanControl;

import RestaurantReserveSystem.Entities.FoodItem;
import RestaurantReserveSystem.Entities.Staff;
import RestaurantReserveSystem.Entities.Menu;
import RestaurantReserveSystem.Entities.Table;
import RestaurantReserveSystem.Entities.Order;
import RestaurantReserveSystem.Entities.Restaurant;

// import Entities.MenuItem;
// import Entities.Restaurant;

public class OrderMgr {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Order> orderList = Restaurant.orders;
    private static ArrayList<Menu> menuItemList = Restaurant.menu;
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
        System.out.println("Staff \t\t: " + order.getStaffAssigned());
        System.out.println("Table ID\t: " + order.getTable().tableId);
        System.out.println("DateTime \t: " + order.getTimestamp().toString());

        System.out.println("\n\t================= ORDERS MADE =================\t\n");
        double sum = 0;
        int index = 1;
        for (Menu item : order.getListOfItems()) {
            System.out.println((index++) + ". " + item.getName() + " - " + item.getPrice());
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

    // Adds MenuItems to the order
    // input: order - Order to be modified
    public static Order addFoodItemToOrder(Order order) {
        String choice = "", compare = "Y";
        do {
            order.addFood(menuItemList);
            // Repeater
            System.out.println("Input \"Y\" to add more food to the order, or other characters to stop adding");
            choice = sc.nextLine();
        } while (choice.toUpperCase().equals(compare));
        return order;
    }

    // Removes Menu Items from the order
    // input: order - Order to be modified
    public static void removeFoodItemFromOrder(Order order) {
        // Sanity check
        if (order.getListOfItems().size() < 1) {
            System.out.println("There are no items in this order");
            return;
        }
        // Removal of items
        else {
            while (order.getListOfItems().size() > 0) {
                String choice = "", compare = "Y";
                do {
                    // Prompt user
                    System.out.println("Which food would you like to remove from the " + order.getName() + " Invoice?");
                    // Display removable item
                    int index = 0;
                    for (MenuItem menuItem : order.getListOfItems())
                        System.out.println("[" + (index++) + "] : " + menuItem.getName());
                    System.out.println();

                    // Error catching (input)
                    do {
                        int option = sc.nextInt();
                    } while (option >= order.getListOfItems().size() || option < 0);

                    order.removeFood(option);

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
        //////////////////////////////////// CHECK TABLE CLASS W JOVIAN/////////////////////////////////////
        completedOrder.getTable().isOccupied = false;
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        invoiceList.add(completedOrder);

        orderList.remove(index);

        System.out.println("\n~~~~~~~This is the printed invoice~~~~~~~\n");
        printOrderDetails(completedOrder);
        System.out.println("\nSuccessfully completed [" + removedOrderName + "] Order");
}
