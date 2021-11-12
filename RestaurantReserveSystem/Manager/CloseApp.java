package Manager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Entities.SetPromo;

/**
 * A File Writing App that only writes back to data file upon termination of
 * App.
 * 
 * @author Timothy Lim
 * @version 1.0
 * @since 2021-11-12
 */
public class CloseApp {

    /**
     * File Write Back for Set Promo data.
     */
    public static void closeSetPromo() throws IOException {
        FileWriter menuWriter = new FileWriter("RestaurantReserveSystem/datatxt/SetPromo.txt");
        PrintWriter menuPrinter = new PrintWriter(menuWriter);

        for (int i = 0; i < PromoMgr.setPromoList.size(); i++) {
            menuPrinter.print(PromoMgr.setPromoList.get(i).getPromoName() + ",");
            menuPrinter.print(PromoMgr.setPromoList.get(i).getPromoPrice() + ",");
            menuPrinter.print(PromoMgr.setPromoList.get(i).getPromoDesc() + ",");
            menuPrinter.print("\n");
            for (int j = 0; j < PromoMgr.setPromoList.get(i).foodList.size(); j++) {
                menuPrinter.print(PromoMgr.setPromoList.get(i).foodList.get(j).getFoodType().toString() + ",");
                menuPrinter.print(PromoMgr.setPromoList.get(i).foodList.get(j).getFoodName() + ",");
                menuPrinter.print(PromoMgr.setPromoList.get(i).foodList.get(j).getFoodPrice() + ",");
                menuPrinter.print(PromoMgr.setPromoList.get(i).foodList.get(j).getFoodDesc() + ",");
                menuPrinter.print("\n");
            }
            if ((i + 1) == PromoMgr.setPromoList.size()) {
                menuPrinter.print("End");
            } else {
                menuPrinter.print("End,");
                menuPrinter.print("\n");
            }

        }
        menuPrinter.close();
    }

    /**
     * File Write Back for Menu Items data.
     */
    public static void closeMenu() throws IOException {
        FileWriter menuWriter = new FileWriter("RestaurantReserveSystem/datatxt/Appetizer.txt");
        PrintWriter menuPrinter = new PrintWriter(menuWriter);

        for (int i = 0; i < MenuMgr.appet.size(); i++) {
            menuPrinter.print(MenuMgr.appet.get(i).getFoodName() + ",");
            menuPrinter.print(MenuMgr.appet.get(i).getFoodPrice() + ",");
            if ((i + 1) != MenuMgr.appet.size()) {
                menuPrinter.print(MenuMgr.appet.get(i).getFoodDesc() + ",");
                menuPrinter.print("\n");
            } else {
                menuPrinter.print(MenuMgr.appet.get(i).getFoodDesc());
            }
        }
        menuWriter.flush();
        menuPrinter.flush();

        menuWriter = new FileWriter("RestaurantReserveSystem/datatxt/MainCourse.txt");
        menuPrinter = new PrintWriter(menuWriter);

        for (int i = 0; i < MenuMgr.mainCourse.size(); i++) {
            menuPrinter.print(MenuMgr.mainCourse.get(i).getFoodName() + ",");
            menuPrinter.print(MenuMgr.mainCourse.get(i).getFoodPrice() + ",");
            if ((i + 1) != MenuMgr.mainCourse.size()) {
                menuPrinter.print(MenuMgr.mainCourse.get(i).getFoodDesc() + ",");
                menuPrinter.print("\n");
            } else {
                menuPrinter.print(MenuMgr.mainCourse.get(i).getFoodDesc());
            }
        }

        menuWriter.flush();
        menuPrinter.flush();

        menuWriter = new FileWriter("RestaurantReserveSystem/datatxt/Drinks.txt");
        menuPrinter = new PrintWriter(menuWriter);

        for (int i = 0; i < MenuMgr.drinks.size(); i++) {
            menuPrinter.print(MenuMgr.drinks.get(i).getFoodName() + ",");
            menuPrinter.print(MenuMgr.drinks.get(i).getFoodPrice() + ",");
            if ((i + 1) != MenuMgr.drinks.size()) {
                menuPrinter.print(MenuMgr.drinks.get(i).getFoodDesc() + ",");
                menuPrinter.print("\n");
            } else {
                menuPrinter.print(MenuMgr.drinks.get(i).getFoodDesc());
            }
        }

        menuWriter.flush();
        menuPrinter.flush();

        menuWriter = new FileWriter("RestaurantReserveSystem/datatxt/Dessert.txt");
        menuPrinter = new PrintWriter(menuWriter);

        for (int i = 0; i < MenuMgr.dessert.size(); i++) {
            menuPrinter.print(MenuMgr.dessert.get(i).getFoodName() + ",");
            menuPrinter.print(MenuMgr.dessert.get(i).getFoodPrice() + ",");
            if ((i + 1) != MenuMgr.dessert.size()) {
                menuPrinter.print(MenuMgr.dessert.get(i).getFoodDesc() + ",");
                menuPrinter.print("\n");
            } else {
                menuPrinter.print(MenuMgr.dessert.get(i).getFoodDesc());
            }
        }
        menuWriter.flush();
        menuPrinter.flush();
        menuWriter.close();
        menuPrinter.close();

    }

    /**
     * File Write Back for Tables data.
     */
    public static void closeTable() throws IOException {
        FileWriter menuWriter = new FileWriter("RestaurantReserveSystem/datatxt/Table.txt");
        PrintWriter menuPrinter = new PrintWriter(menuWriter);

        for (int i = 0; i < TableMgr.tables.size(); i++) {
            menuPrinter.print(TableMgr.tables.get(i).getTableNo() + ",");
            menuPrinter.print(TableMgr.tables.get(i).getMaxNumSeats() + ",");
            if ((i + 1) != TableMgr.tables.size()) {
                menuPrinter.print(TableMgr.tables.get(i).getAvailStatus() + ",");
                menuPrinter.print("\n");
            } else {
                menuPrinter.print(TableMgr.tables.get(i).getAvailStatus());
            }
        }
        menuPrinter.flush();
        menuPrinter.close();
    }

    /**
     * File Write Back for Reservation data.
     */
    public static void closeReservation() throws IOException {
        FileWriter menuWriter = new FileWriter("RestaurantReserveSystem/datatxt/Reservation.txt");
        PrintWriter menuPrinter = new PrintWriter(menuWriter);

        for (int i = 0; i < ReservationMgr.r.size(); i++) {
            menuPrinter.print(ReservationMgr.r.get(i).getReserveTime().toString() + ",");
            menuPrinter.print(ReservationMgr.r.get(i).getReserveDate().toString() + ",");
            menuPrinter.print(ReservationMgr.r.get(i).getNumOfPax() + ",");
            menuPrinter.print(ReservationMgr.r.get(i).getCustName() + ",");
            menuPrinter.print(ReservationMgr.r.get(i).getCustContact() + ",");
            if ((i + 1) != ReservationMgr.r.size()) {
                menuPrinter.print(ReservationMgr.r.get(i).getTableNo() + ",");
                menuPrinter.print("\n");
            } else {
                menuPrinter.print(ReservationMgr.r.get(i).getTableNo());
            }
        }
        menuPrinter.flush();
        menuPrinter.close();
    }
}
