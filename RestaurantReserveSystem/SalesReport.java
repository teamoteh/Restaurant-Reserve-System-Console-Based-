package RestaurantReserveSystem;

public class SalesReport {
    // Consider as string instead. Easier to append
    private OrderInvoice[] allOrderInvoices;
    private String startDate;
    private String endDate;

    SalesReport() {
    }

    public double generateTotalRevenue() {
        return 0;
    }
    // public String[] generateIndividualItems() {
    // this.allOrderInvoices;
    // return this.allOrderInvoices;
    // }
}

/*
 * Should we have another class that acts like a database to keep all the
 * orderInvoices that way we can initialise a SalesReport object with a start
 * date and end date. This will prevent confusion in my opinion what do you
 * thinK?
 */
