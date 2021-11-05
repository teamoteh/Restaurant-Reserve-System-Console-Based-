package Entities;

import java.util.ArrayList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java.text.ParseException;

// Order class object to represent Restaurant Orders
public class Order {
    private ArrayList<FoodItem> orderItems;
    private Staff staff;
    private Table table;
    private Date timestamp;
    private String name;
    private boolean MemberDiscount;

    // Constructor for Order
    public Order(Staff staff, Table table) {
        // Date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Ask for Date input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Date (yyyy-MM-dd):");
        String input_date = scanner.next();
        Date date = null;
        try {
            // Parsing the String
            date = dateFormat.parse(input_date);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }

        this.staff = staff; // from param
        this.setTable(table); // from param
        this.orderItems = new ArrayList<FoodItem>();
        // this.timestamp = new Date(); // Wed Nov 03 02:50:54 GMT 2021 => Date
        this.timestamp = date;
        this.setName("Table: " + getTable().getTableNo() + " - Date:" + dateFormat.format(this.timestamp)); // 2021-11-03
                                                                                                            // 02:50:54
                                                                                                            // => String
        this.setMemberDiscount(false);
    }

    // Add a FoodItem Item to the Order
    public void addItem(FoodItem item) {
        this.orderItems.add(item);
    }

    // Removes a FoodItem Item from the Order
    public void removeItem(int index) {
        String removedItemName = this.orderItems.get(index).getFoodName();
        this.orderItems.remove(index);
        System.out.println(removedItemName + " was successfully removed from the " + this.getName() + " Invoice");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<FoodItem> getOrderItems() {
        return orderItems;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Date getTimeStamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public boolean getMemberDiscount() {
        return this.MemberDiscount;
    }

    public void setMemberDiscount(boolean MemberDiscount) {
        this.MemberDiscount = MemberDiscount;
    }

}
