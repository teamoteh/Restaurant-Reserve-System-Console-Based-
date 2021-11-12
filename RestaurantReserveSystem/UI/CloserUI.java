package UI;

import java.io.IOException;

import Manager.CloseApp;

/**
 * Closing Restaurant UI to terminate app and write back to data files
 * 
 * @author Timothy Lim
 * @version 1.0
 * @since 2021-11-12
 */
public class CloserUI {

    /**
     * Calls on each Write back functions
     */
    public static void closeRestaurant() {
        try {
            CloseApp.closeMenu();
            CloseApp.closeSetPromo();
            CloseApp.closeTable();
            CloseApp.closeReservation();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
