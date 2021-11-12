package Entities;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Order entity, for instantiation of Restaurant's Order
 * 
 * @author KaiSheng Lim
 * @version 1.0
 * @since 2021-11-12
 */

public class Order {
    /**
     * Contains all A'la Carte FoodItems (entity) ordered
     */
    private ArrayList<FoodItem> orderItems;
    /**
     * Contains all Promotion SetItems (entity) ordered
     */
    private ArrayList<SetPromo> orderPromo;
    /**
     * Staff who created the order
     */
    private Staff staff;
    /**
     * Table assigned to the order
     */
    private Table table;
    /**
     * Date the order was made
     */
    private String timestamp;
    /**
     * Name of the order (Auto-generated ID)
     */
    private String name;
    /**
     * Membership status for MemberDiscount
     */
    private boolean MemberDiscount;

    /**
     * Constructor for Order
     * 
     * @param staff Staff who keys in the Order
     * @param table Table assigned to the order
     * @param date  Date assigned to the order
     */
    public Order(Staff staff, Table table, String date) {
        this.staff = staff; // from param
        this.setTable(table); // from param
        this.orderItems = new ArrayList<FoodItem>();
        this.orderPromo = new ArrayList<SetPromo>();
        this.timestamp = date;
        this.setName("Table: " + getTable().getTableNo() + " - Date: " + this.timestamp);
        this.setMemberDiscount(false);
    }

    /**
     * Add an A'la Carte FoodItem to the Order
     */
    public void addItem(FoodItem item) {
        this.orderItems.add(item);
    }

    /**
     * Add a Promotion SetItem to the Order
     */
    public void addPromo(SetPromo item) {
        this.orderPromo.add(item);
    }

    /**
     * Remove an A'la Carte FoodItem from the Order
     */
    public void removeItem(int index) {
        String removedItemName = this.orderItems.get(index).getFoodName();
        this.orderItems.remove(index);
        System.out.println(removedItemName + " was successfully removed from the " + this.getName() + " Order");
    }

    /**
     * Remove a Promotion SetItem from the Order
     */
    public void removePromo(int index) {
        String removedItemName = this.orderPromo.get(index).getPromoName();
        this.orderPromo.remove(index);
        System.out.println(removedItemName + " was successfully removed from the " + this.getName() + " Order");
    }

    /**
     * Get all the ordered A'la Carte FoodItem in the Order
     * 
     * @return ArrayList of A'la Carte FoodItem
     */
    public ArrayList<FoodItem> getOrderItems() {
        return orderItems;
    }

    /**
     * Get all the ordered Promotion SetItem in the Order
     * 
     * @return ArrayList of Promotion SetItem
     */
    public ArrayList<SetPromo> getOrderPromo() {
        return orderPromo;
    }

    /**
     * Get the Order Name from the Order Instance
     * 
     * @return Order Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set a Order Name to the Order Instance
     * 
     * @param name Order Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the Staff from the Order Instance
     * 
     * @return Order Name
     */
    public Staff getStaff() {
        return staff;
    }

    /**
     * Set the Staff to the Order Instance
     * 
     * @param staff Staff who created the order.
     */
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /**
     * Get the Date the order was made from the Order Instance.
     * 
     * @return The Date the order was made.
     */
    public String getTimeStamp() {
        return timestamp;
    }

    /**
     * Set the Date the order was made to the Order Instance.
     * 
     * @param timestamp The Date the order was made.
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Get the Table that was assigned to the Order Instance.
     * 
     * @return Table that was assigned to the Order Instance.
     */
    public Table getTable() {
        return table;
    }

    /**
     * Set the Table assigned to the Order Instance
     * 
     * @param table Table assgned to the Order Instance
     */
    public void setTable(Table table) {
        this.table = table;
    }

    /**
     * Get the Member Discount from the Order Instance
     * 
     * @return Member Discount
     */
    public boolean getMemberDiscount() {
        return this.MemberDiscount;
    }

    /**
     * Set the Member Discount to the Order Instance
     * 
     * @param MemberDiscount Member Discount
     */
    public void setMemberDiscount(boolean MemberDiscount) {
        this.MemberDiscount = MemberDiscount;
    }

}
