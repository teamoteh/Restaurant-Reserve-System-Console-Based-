package UI;
import java.io.IOException;

import Manager.CloseApp;

public class CloserUI {
    public static void closeRestaurant(){
        try{
            CloseApp.closeMenu();
            CloseApp.closeSetPromo();
            CloseApp.closeTable();
            CloseApp.closeReservation();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
