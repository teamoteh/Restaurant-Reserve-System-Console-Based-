package Entities;

import java.util.ArrayList;
import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Date;

// Order class object to represent Restaurant Orders
public class Order {
    private ArrayList<FoodItem> orderItems;
    private Staff staff;
    private Table table;
    private Date timestamp;
    private String name;
    private boolean checkOut;

    // Constructor for Order
    public Order(Staff staff, Table table) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.staff = staff; // from param
        this.setTable(table); // from param
        this.orderItems = new ArrayList<FoodItem>();
        this.timestamp = new Date(); // Wed Nov 03 02:50:54 GMT 2021 => Date
        this.setName("Table: " + getTable().tableID + " - Date:" + dateFormat.format(this.timestamp)); // 2021-11-03 02:50:54 => String
        this.setCheckOut(false);
    }

    // Add a FoodItem Item to the Order
    public void addItem(FoodItem item) {
        this.orderItems.add(item);
    }

    // Removes a FoodItem Item from the Order
    public void removeItem(int index) {
        String removedItemName = this.orderItems.get(index).getName();
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

    public Date getTimestamp() {
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

    public boolean getCheckOut() {
        return this.checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

}
