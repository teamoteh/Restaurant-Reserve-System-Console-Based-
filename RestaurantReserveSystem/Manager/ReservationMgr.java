package Manager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
//import datatxt.FileReaderWriter;
import Entities.Reservation;
import Entities.Table;
import datatxt.FileReaderWriter;
//import Entities.Table;
import java.io.*;
import java.util.Scanner;

public class ReservationMgr {
    protected static ArrayList<Reservation> r = new ArrayList<Reservation>();

    public ReservationMgr() throws FileNotFoundException {

        /*
         * File file = new File( // RestaurantReserveSystem/datatxt/Reservation.txt ->
         * Relative path
         * "Users/ASUS/OneDrive/Documents/GitHub/Restaurant-Reserve-System-Console-Based-/RestaurantReserveSystem/datatxt/Reservation.txt"
         * ); Scanner sc = new Scanner(file); int i = 0; sc.useDelimiter("\\s*,\\s*");
         * 
         * while (sc.hasNextLine()) { Reservation res = new
         * Reservation(LocalTime.parse(sc.next()), LocalDate.parse(sc.next()),
         * sc.nextInt(), sc.next(), sc.nextInt()) r.add(res) r.get(i).setNumOfPax();
         * r.get(i).setCustName(); r.get(i).setCustContact(); r.get(i).setTime();
         * r.get(i).setDate()); i++; }
         * 
         * sc.close();
         * 
         * FileReaderWriter fi = new FileReaderWriter(); try { fi.getReservation(r); }
         * catch (FileNotFoundException e) { e.printStackTrace(); }
         */

    }

    public static void checkReservationExpiry() {
        for (int i = 0; i < r.size(); i++) {
            if (LocalDate.now().isEqual(r.get(i).getReserveDate())) {
                if (LocalTime.now().isAfter(r.get(i).getReserveTime().plusMinutes(30))) {
                    r.remove(i); // Free up table
                }
            }

        }
    }

    public static void addReservationBooking(Reservation r1) {
        checkReservationExpiry();
        r.add(r1);
        System.out.println("Reservation Confirmed. Table allocated is table " + r1.getTableNo());

        // have to write in to txt file

    }

    public static void removeReservationBooking(int number) {
        checkReservationExpiry();
        for (int i = 0; i < r.size(); i++) {
            if (r.get(i).getCustContact() == number) {
                r.remove(i);
                System.out.println("Reservation successfully removed!");
                return;
            }
        }
    }

    public static void checkReservationBooking(int number) {
        for (int i = 0; i < r.size(); i++) {
            if (r.get(i).getCustContact() == number) {
                System.out.println("Reservation valid under " + r.get(i).getCustName() + " at "
                        + r.get(i).getReserveTime() + " on " + r.get(i).getReserveDate());
                return;
            } else
                System.out.println("Reservation does not exist!");
        }
    }

    public static void displayReservation() throws FileNotFoundException {
        // FileReaderWriter.getReservation(r);
        System.out.println("Date         Time            Name          Pax           Contact      TableNo");
        for (int i = 0; i < r.size(); i++) {
            System.out.println(r.get(i).getReserveDate() + "    " + r.get(i).getReserveTime() + "    "
                    + r.get(i).getCustName() + "    " + r.get(i).getNumOfPax() + "    " + r.get(i).getCustContact()
                    + "    " + r.get(i).getTableNo());
        }
    }
}