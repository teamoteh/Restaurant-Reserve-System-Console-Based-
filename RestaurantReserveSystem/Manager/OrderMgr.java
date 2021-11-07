package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.*;
import Manager.*; // It is in used, ignore error. See line 17~19

// import Entities.Restaurant;

public class OrderMgr {
    private static ArrayList<Order> orderList = new ArrayList<Order>(); // List of current order that is unpaid
    private static ArrayList<Order> invoiceList = new ArrayList<Order>(); // List of exisiting order that has checkout
                                                                          // as invoice
    private static ArrayList<SetPromo> PromoItemList = PromoMgr.getPromoList(); // Need tim inputs
    private static ArrayList<FoodItem> FoodItemList = MenuMgr.getMenuList(); // All food options
    private static ArrayList<Table> tableList = TableMgr.getTableList(); // Available tables for walk in order
    private static ArrayList<Staff> staffList = StaffMgr.getStaffList(); // For receipt

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
        System.out.println("Order ID \t\t: " + order.getName());
        System.out.println("Staff \t\t\t: " + order.getStaff().getStaffName());
        System.out.println("Table ID\t\t: " + order.getTable().getTableNo());
        System.out.println("DateTime \t\t: " + order.getTimeStamp().toString());
        System.out.println("Membership Discount\t: " + (order.getMemberDiscount() ? "20% OFF APPLIED" : "N.A."));

        System.out.println("\n===================== ORDERS MADE =====================\n");
        double sum = 0;
        int index = 1;
        for (FoodItem item : order.getOrderItems()) {
            System.out.printf("%d. %s  \t\t- $%.2f\n", (index++), item.getFoodName(), item.getFoodPrice());
            sum += item.getFoodPrice();
        }
        for (SetPromo item : order.getOrderPromo()) {
            System.out.printf("%d. %s  \t- $%.2f\n", (index++), item.getPromoName(), item.getPromoPrice());
            sum += item.getPromoPrice();
        }

        // MEMBER DISCOUNT (20%)
        if (order.getMemberDiscount()) {
            sum = sum * 0.8;
        }
        System.out.println("\n=======================================================");
        System.out.printf("SUBTOTAL\t\t:$%.2f \n", sum);
        System.out.printf("SERVICE TAX (10%%)\t:$%.2f \n", sum * 0.10);
        System.out.printf("GST (7%%)\t\t:$%.2f \n", sum * 0.07);
        System.out.printf("TOTAL DUE\t\t:$%.2f \n", sum * 1.17);
        System.out.println("============= THANK YOU FOR DINING WITH US ============");
        System.out.println();

    }

    // Adds a new order to the restaurant's Order List
    // input: staff - Staff who keys in the order
    // input: table - Table assigned to this order
    public static void addNewOrder(Staff staff, Table table) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter today's date in the format of YYYY-MM-DD: ");
        String date = sc.nextLine();
        Order newOrder = new Order(staff, table, date);
        table.setUnavailStatus();
        Order item = addFoodItemToOrder(newOrder);
        orderList.add(item);
    }

    // Adds FoodItems to the order
    // input: order - Order to be modified
    public static Order addFoodItemToOrder(Order order) {
        Scanner scanner = new Scanner(System.in);
        int opt = 0;
        String choice = "";
        String compare = "Y";
        do {
            int index = 1;
            int setIndex;

            // Sanity check for menu
            if (FoodItemList.size() < 1) {
                System.out.println("There are no items in the menu");
                break;
            }

            // UI Display addable item
            System.out.println();
            System.out.println("======================= ALL ADDABLE FOOD ======================");
            System.out.println("Which food would you like to [add] to the [" + order.getName() + "] Order?");

            // Ala carte items
            System.out.println("\t========== A' LA CARTE ==========\t");
            for (FoodItem item : FoodItemList) {
                System.out.println((index++) + ". " + item.getFoodName());
            }
            // Placeholder to identify from which index onwards are setPromo
            setIndex = index;

            // SetMeal items
            System.out.println("\t=========== SET MEAL ============\t");
            for (SetPromo set : PromoItemList) {
                System.out.println((index++) + ". " + set.getPromoName());
            }
            System.out.println("================================================================");
            System.out.println();
            System.out.println("Input your choice of addable food: ");

            // Error checking for user input
            do {
                opt = scanner.nextInt();
            } while (opt < 0 || opt > index);

            // Adding the foodItem / setPromo to the arrayList
            if (opt >= setIndex) {
                // int size = PromoItemList.size() - 1;
                SetPromo food = PromoItemList.get(opt - setIndex);
                order.addPromo(food);
                System.out.println(food.getPromoName() + " was successfully add to [" + order.getName() + "] Order");
            } else {
                FoodItem food = FoodItemList.get(opt - 1);
                order.addItem(food);
                System.out.println(food.getFoodName() + " was successfully add to [" + order.getName() + "] Order");
            }

            // Repeater
            System.out.println("Do you want to [add] more food to the order? (Y/N)");
            choice = scanner.next();
        } while (choice.toUpperCase().equals(compare));
        // scanner.close();
        return order;
    }

    // Removes FoodItem Items from the order
    // input: order - Order to be modified
    public static void removeFoodItemFromOrder(Order order) {
        Scanner scanner = new Scanner(System.in);

        int opt;
        int setIndex;

        // Sanity check for menu
        if (order.getOrderItems().size() < 1) {
            System.out.println("There are no items in this order");
            // scanner.close();
            return;
        }
        // Removal of items
        else {
            while ((order.getOrderItems().size() > 0) && (order.getOrderPromo().size() > 0)) {
                String choice = "", compare = "Y";
                do {
                    // Prompt user
                    System.out.println(
                            "Which food would you like to [remove] from the [" + order.getName() + "] Invoice?");

                    // UI Display removable item
                    System.out.println("====================== ALL REMOVABLE FOOD =====================");
                    int index = 0;

                    // A' La carte
                    System.out.println("\t========== A' LA CARTE ==========\t");
                    for (FoodItem item : order.getOrderItems()) {
                        System.out.println("[" + (index++) + "] : " + item.getFoodName());
                    }
                    // Placeholder to identify from which index onwards are setPromo
                    setIndex = index;

                    // Set Meal
                    System.out.println("\t=========== SET MEAL ============\t");
                    for (SetPromo set : PromoItemList) {
                        System.out.println((index++) + ". " + set.getPromoName());
                    }

                    System.out.println("================================================================\n");
                    System.out.println("Input your choice of removable food: ");
                    // Error Checking: Ask user to input an options within the given range
                    do {
                        opt = scanner.nextInt();
                    } while (opt < 0 || opt > index);

                    // Removing the foodItem / setPromo to the arrayList
                    if (opt >= setIndex) {
                        order.removePromo(opt); // Remove set promo
                    } else {
                        order.removeItem(opt); // Remove a' la carte
                    }

                    // Repeater
                    System.out.println("Do you want to [remove] more food from the order? (Y/N)");
                    choice = scanner.nextLine();
                } while (choice.toUpperCase().equals(compare));

                // scanner.close();
                // To break the while Loop
                return;
            }
        }
        // scanner.close();
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
        Scanner scanner = new Scanner(System.in);
        Order completedOrder = orderList.get(index);

        // During checkout, prompt user if he/she is a member for member discount
        System.out.println("Is the customer a member (Y/N) ?");
        String choice = scanner.nextLine().toUpperCase();
        Boolean membership = (choice == "Y") ? true : false; // ternary operator / conditional operator
        completedOrder.setMemberDiscount(membership);

        // Update the table status to "available"
        completedOrder.getTable().setAvailStatus();

        // Printing of invoice
        String removedOrderName = completedOrder.getName();
        System.out.println("Successfully completed [" + removedOrderName + "] Order");
        printOrderDetails(completedOrder);

        // Shift order to invoice arraylist
        invoiceList.add(completedOrder);
        orderList.remove(index);

        // scanner.close();
    }
}

/**
 * Find the total revenue made for a reporting month
 * 
 * @param month Month for statistics to be reported
 * @return Total revenue for reporting period
 */