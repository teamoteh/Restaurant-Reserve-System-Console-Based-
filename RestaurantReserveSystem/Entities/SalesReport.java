package Entities;

import java.util.List;
import java.util.ArrayList;

public class SalesReport {
    private List<OrderInvoice> allOrderInvoices;
    private String startDate;
    private String endDate;

    SalesReport() {
    }

    // Todo: When prices are updated
    public double generateTotalRevenue() {
        double totalRevenue = 0;
        for (int i = 0; i < allOrderInvoices.size(); i++) {
            totalRevenue += allOrderInvoices.get(i).getTotalSum();
        }
        return totalRevenue;
    }
    // Cake : 6
    // Coke : 10

    // public void generateIndividualItems() {
    // for (int i = 0; i < allOrderInvoices.size(); i++){
    // System.out.println();
    // }
    // }
}
