package UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import Manager.MenuMgr;
import java.time.LocalDate;
import Manager.TableMgr;
import Manager.StaffMgr;
import Manager.PromoMgr;
import Manager.MenuMgr;
import Manager.ReservationMgr;
import Manager.CloseApp;

/**
 * Overall Restaurant App
 * 
 * @author KaiSheng Lim
 * @version 1.0
 * @since 2021-11-12
 */
public class RestaurantApp {

    
    /** 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        /**
         * Intialize all Array Lists in the various Managers
         */
        TableMgr.readTables(TableMgr.getTableList());
        StaffMgr.readStaffs(StaffMgr.getStaffList());
        PromoMgr.readPromo(PromoMgr.getPromoList());
        MenuMgr.readMenu();
        ReservationMgr.readReservation();

        Scanner sc = new Scanner(System.in);

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

        CloserUI.closeRestaurant();
        System.out.println("App terminated.");
        sc.close();
    }
}