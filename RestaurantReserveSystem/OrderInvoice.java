package RestaurantReserveSystem;

import java.util.List;
import java.util.ArrayList;

public class OrderInvoice {
    // private String[] orderItems;
    private List<String> orderItems;
    private String staffName;
    private int tableNo;
    private String timeStamp;
    private String dateStamp;
    private double salesTax;
    private double serviceCharge;

    public OrderInvoice(int tableNum, String timeStamp, String dateStamp, String staffName) {
        this.orderItems = new ArrayList<String>();
        this.tableNo = tableNum; // Added these 3 because I think it would be neccesary when creating a new
                                 // invoice
        this.timeStamp = timeStamp;
        this.dateStamp = dateStamp;
        this.staffName = staffName;
    };

    public String getOrderItems() {
        return this.getOrderItems(); // What is this doing?
    };

    // Consider list instead of array?
    public void setOrderItems(String OrderItems) {
        this.orderItems.add(OrderItems);
    };

    public String getStaffName() {
        return this.staffName;
    };

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    };

    public int getTableNo() {
        return this.tableNo;
    };

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    };

    public String getTimeStamp() {
        return this.timeStamp;
    };

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    };

    public String getDateStamp() {
        return this.dateStamp;
    };

    public void setDateStamp(String dateStamp) {
        this.dateStamp = dateStamp;
    };

    public double getSalesTax() {
        return this.salesTax;
    };

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    };

    public double getServiceCharge() {
        return this.serviceCharge;
    };

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    };

}
