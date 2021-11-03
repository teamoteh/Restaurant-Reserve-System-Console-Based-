package Manager;
import java.time.LocalTime;
import java.util.ArrayList;
//import datatxt.FileReaderWriter;
import Entities.Reservation;
//import Entities.Table;

public class ReservationMgr {

     protected static ArrayList<Reservation> r;
    
    public ReservationMgr(){
 
        r = new ArrayList<Reservation>();
    }

    public static void checkReservationExpiry() {

        for (int i=0 ; i<r.size() ; i++)
        {
            if (LocalTime.now().isAfter(r.get(i).getReserveTime().plusMinutes(30))) {
                r.remove(i); // Free up table
            }
        }
        
    }


    public static void addReservationBooking(Reservation r1)
    {
        checkReservationExpiry();
        r.add(r1);
    }


    public static void removeReservationBooking(int number) {
        checkReservationExpiry();
        for (int i = 0; i < r.size(); i++) {
			
				if (r.get(i).getCustContact()==number) {
                    r.remove(i);
					System.out.println("Reservation successfully removed!");
					return;
				}
			}
    }

    public static void checkReservationBooking(int number)
    {
        for (int i = 0; i < r.size(); i++) {
			
            if (r.get(i).getCustContact()==number) {
                System.out.println("Reservation valid under" + r.get(i).getCustName() + "at" + r.get(i).getReserveTime() + "on" + r.get(i).getReserveDate());
                return;
            }

            else
                 System.out.println("Reservation does not exist!");
        }
    }


    public static void displayReservation ()
    {
        System.out.println("Date    Time      Name     Pax      Contact      TableNo");
        for (int i = 0; i < r.size(); i++) {
            System.out.println(r.get(i).getReserveDate() + "    " + r.get(i).getReserveTime()+ "    " + r.get(i).getCustName() + "    " + r.get(i).getNumOfPax()+ "    " + r.get(i).getCustContact()+ "    " + r.get(i).getTableNo());
    }
    }
}
