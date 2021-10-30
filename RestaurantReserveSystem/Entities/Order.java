package Entities;

import java.util.ArrayList;
import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Date;

// Order class object to represent Restaurant Orders
public class Order {
    private ArrayList<Menu> listOfItems;
    private Staff staffAssigned;
    private Table table;
    private Date date;
    private String name;
    private boolean checkOut;

    // Constructor
    public Order(Staff staffAssigned, Table table) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.staffAssigned = staffAssigned;
        this.setTable(table);
        this.listOfItems = new ArrayList<Menu>();
        this.date = new Date();
        this.setName(this.staffAssigned.getStaffName() + ", " + dateFormat.format(this.date));
        this.setCheckOut(false);
    }

    // Add a Menu Item to the Order
    public void addFood(Menu menuItem) {
        this.listOfItems.add(menuItem);
    }

    // Removes a Menu Item from the Order
    public void removeFood(int option) {
        String removedItemName = this.listOfItems.get(option).getName();
        this.listOfItems.remove(option);
        System.out.println(removedItemName + " was successfully removed from the " + this.getName() + " Invoice");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Menu> getListOfItems() {
        return listOfItems;
    }

    public Staff getStaffAssigned() {
        return staffAssigned;
    }

    public void setStaffAssigned(Staff staffAssigned) {
        this.staffAssigned = staffAssigned;
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
