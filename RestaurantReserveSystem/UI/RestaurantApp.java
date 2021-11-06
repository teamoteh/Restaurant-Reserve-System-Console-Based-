package UI;

import java.io.FileNotFoundException;
import java.util.Scanner;
import Manager.MenuMgr;
// import java.text.DateFormat;
// import java.text.SimpleDateFormat;
// import java.time.LocalDate;
//import java.util.Date;
import Manager.TableMgr;
import Manager.StaffMgr;
import Manager.PromoMgr;
import Manager.MenuMgr;;

public class RestaurantApp {
    public static void main(String[] args) throws FileNotFoundException {

        
        TableMgr.readTables(TableMgr.getTableList());
        StaffMgr.readStaffs(StaffMgr.getStaffList());
        PromoMgr.readPromo(PromoMgr.getPromoList());
        MenuMgr.getMenu();

        Scanner sc = new Scanner(System.in);

        // System.out.println("Enter today's date in the format of YYYY-MM-DD: ");
        // LocalDate date = LocalDate.parse(sc.nextLine());
        int choice;
        do {
            System.out.println("What would you like to do? ");
            System.out.println("1. Menu\n" + "2. Order\n" + "3. Reservations\n" + "4. SalesReport\n" + "5. Exit\n");
            System.out.println("Input a choice:");
            choice = sc.nextInt();

            switch (choice) {
            case 1:
                UI.MenuUI.displayMenu_UI();
                break;

            case 2:
                UI.OrderUI.displayOrder_UI();
                break;

            case 3:
                UI.ReservationUI.displayReservationUI();
                break;

            case 4:
                UI.SalesReportUI.displaysalesInvoiceUI();
                break;
            }
        } while (choice > 0 && choice < 5);

        System.out.println("App terminated.");
        sc.close();
    }
}