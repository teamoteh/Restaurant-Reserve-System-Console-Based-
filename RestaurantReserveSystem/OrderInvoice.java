package RestaurantReserveSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.ArrayList;

public class OrderInvoice {
    // Pre-checkout: Used to track user order
    // Post-checkout: Used to print the receipt
    private boolean checkOut;

    // TimeStamp - Real-time
    private String timeStamp;

    // User orders
    private List<FoodItem> orderItems;
    private int tableNo;

    // Payment
    private double salesTax;
    private double serviceCharge;
    private double totalSum;

    // Staff Object
    private String staffName;
    private String staffGender;
    private String jobTitle;
    private int staffID;

    public OrderInvoice(int tableNum, Staff staff) {
        this.checkOut = false;
        this.timeStamp = getTimeStamp();

        this.orderItems = new ArrayList<FoodItem>();
        this.tableNo = tableNum;

        // Payment
        this.salesTax = 0.10;
        this.serviceTax = 0.10;
        this.totalSum = 0;

        // Staff info (gender, employee, id and job title) requested by prof
        this.staffName = staff.getStaffName();
        this.staffGender = staff.getStaffGender();
        this.jobTitle = staff.getJobTitle();
        this.staffID = staff.getStaffID();
    };

    public boolean getCheckOut() {
        return this.checkOut;
    }
    
    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
        this.timeStamp = getTimeStamp();
    }
    
    public String getTimeStamp() {
        return this.timeStamp;
    }
    
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    // Add items
    public void addOrderItems(FoodItem OrderItems) {
        this.orderItems.add(OrderItems);
    };

    // Remove items
    public void removeOrderItems(FoodItem OrderItems) {
        this.orderItems.remove(OrderItems);
    };

    public void printOrderItems() {
        for (int i = 0; i < this.orderItems.size(); i++) {
            FoodItem item = orderItems.get(i);
            System.out.println((i+1) +  " : " + item.getFoodName());;
        }
    };

    public int getTableNo() {
        return this.tableNo;
    };

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    };

    public double getTotalSum() {
        // Add all the values
        for (int i = 0; i < this.orderItems.size(); i++) {
            FoodItem item = orderItems.get(i);
            this.totalSum += item.getprice();
        }
        return this.totalSum;
    }

    public String currentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void printInvoice(){
        // list the order details (eg, table number, timestamp)
        // a complete breakdown of order items details with taxes details.
        System.out.println("############ Invoice ###########");
        System.out.println("Time      : " + currentTime());
        System.out.println("Table No  : " + getTableNo());
        System.out.println("Served By : " + getStaffName());
        System.out.println("################################");
        for (int i = 0; i < this.orderItems.size(); i++) {
            FoodItem item = orderItems.get(i);
            System.out.println(item.getFoodName() + " : " + item.getFoodPrice());
        }
        System.out.println("SubTotal  : " + getTotalSum());
        double tax = (salesTax + serviceCharge) * getTotalSum();
        System.out.println("Tax       : " + tax);
        System.out.println("Total     : " + getTotalSum() + tax);
        System.out.println("###### End of Transaction ######");
        System.out.println("################################");
    }
    // public double getSalesTax() {
    //     return this.salesTax;
    // };

    // public void setSalesTax(double salesTax) {
    //     this.salesTax = salesTax;
    // };

    // public double getServiceCharge() {
    //     return this.serviceCharge;
    // };

    // public void setServiceCharge(double serviceCharge) {
    //     this.serviceCharge = serviceCharge;
    // };

    // public void setTotalSum(double totalSum) {
    //     this.totalSum = totalSum;
    // }

    // Ambiguous, don't think we should do this 
    // This should be initialize in constructo using staff object

    // public String getStaffName() {
    //     return staffName;
    // }

    // public void setStaffName(String staffName) {
    //     this.staffName = staffName;
    // }

    // public String getStaffGender() {
    //     return staffGender;
    // }

    // public void setStaffGender(String staffGender) {
    //     this.staffGender = staffGender;
    // }

    // public String getJobTitle() {
    //     return jobTitle;
    // }

    // public void setJobTitle(String jobTitle) {
    //     this.jobTitle = jobTitle;
    // }

    // public int getStaffID() {
    //     return staffID;
    // }

    // public void setStaffID(int staffID) {
    //     this.staffID = staffID;
    // }

}
