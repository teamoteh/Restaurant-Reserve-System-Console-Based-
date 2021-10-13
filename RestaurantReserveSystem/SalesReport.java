package RestaurantReserveSystem;

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
        return 0;
    }
    // Cake : 6
    // Coke : 10

    // public void generateIndividualItems() {
    //     for (int i = 0; i < allOrderInvoices.size(); i++){
    //         System.out.println();
    //     }
    // }
}

/*
 * Should we have another class that acts like a database to keep all the
 * orderInvoices that way we can initialise a SalesReport object with a start
 * date and end date. This will prevent confusion in my opinion what do you
 * thinK?
 */
