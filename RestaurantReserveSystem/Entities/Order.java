package Entities;

import java.util.ArrayList;

// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.time.LocalDate;
import java.util.Scanner;

// Order class object to represent Restaurant Orders
public class Order {
    private ArrayList<FoodItem> orderItems;
    private ArrayList<SetPromo> orderPromo;
    private Staff staff;
    private Table table;
    private String timestamp;
    private String name;
    private boolean MemberDiscount;

    // Constructor for Order
    public Order(Staff staff, Table table, String date) {

        this.staff = staff; // from param
        this.setTable(table); // from param
        this.orderItems = new ArrayList<FoodItem>();
        this.orderPromo = new ArrayList<SetPromo>();
        // this.timestamp = new Date(); // Wed Nov 03 02:50:54 GMT 2021 => Date
        this.timestamp = date;
        this.setName("Table: " + getTable().getTableNo() + " - Date: " + this.timestamp);
        this.setMemberDiscount(false);
    }

    // Add a FoodItem Item to the Order
    public void addItem(FoodItem item) {
        this.orderItems.add(item);
    }

    // Add a Promo Item to the Order
    public void addPromo(SetPromo item) {
        this.orderPromo.add(item);
    }

    // Removes a FoodItem Item from the Order
    public void removeItem(int index) {
        String removedItemName = this.orderItems.get(index).getFoodName();
        this.orderItems.remove(index);
        System.out.println(removedItemName + " was successfully removed from the " + this.getName() + " Invoice");
    }

    public void removePromo(int index) {
        String removedItemName = this.orderPromo.get(index).getPromoName();
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

    public ArrayList<SetPromo> getOrderPromo() {
        return orderPromo;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getTimeStamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
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
