package RestaurantReserveSystem;

import java.util.List;
import java.util.ArrayList;

public class OrderInvoice {
    private List<String> orderItems;
    private String staffName;
    private int tableNo;
    private String timeStamp;
    private String dateStamp;
    private double salesTax;
    private double serviceCharge;
    private double totalSum;
    // added staffgender, employee id and job title
    private String staffGender;
    private int staffID;
    private String jobTitle;


    public OrderInvoice(int tableNum, String timeStamp, String dateStamp, String staffName) {
        this.orderItems = new ArrayList<String>();
        this.tableNo = tableNum; // Added these 3 because I think it would be neccesary when creating a new
                                 // invoice
        this.timeStamp = timeStamp;
        this.dateStamp = dateStamp;
        this.staffName = staffName;

        // as prof replied in the email that needed to add staff info (gender,employee id and job title)
        this.staffGender = staffGender;
        this.staffID = staffID;
        this.jobTitle = jobTitle;


    };

    public List<String> getOrderItems() {
        return this.orderItems;
    };

    // Add items
    public void addOrderItems(String OrderItems) {
        this.orderItems.add(OrderItems);
    };
    // Remove items
    public void removeOrderItems(String OrderItems) {
        this.orderItems.remove(OrderItems);
    };

    public String getStaffName() {
        return this.staffName;
    };

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    };


    // added this part
    public String getStaffGender() {
        return this.staffGender;
    };

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
    };

    public String getStaffID() {
        return this.staffID;
    };

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    };


    public void getJobTitle(String jobTitle)
    {
        return this.jobTitle;
    };

    public void setJobTitle(String jobTitle)
    {
        this.jobTitle = jobTitle;
    };
    // to here

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

    public double getTotalSum() {
        // Add all the values
        totalSum = 0.0;
        for(int i = 0; i < this.orderItems.size(); i++){
            totalSum += orderItems.get(i).get??price();
        return this.totalSum;
    }
}
