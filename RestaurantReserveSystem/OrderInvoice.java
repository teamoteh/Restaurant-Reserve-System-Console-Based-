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

    public OrderInvoice() {
        this.orderItems = new ArrayList<String>();
    };

    public String getOrderItems() {
        return this.getOrderItems();
    };
    // Consider list instead of array?
    public void setOrderItems(String OrderItems){
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
