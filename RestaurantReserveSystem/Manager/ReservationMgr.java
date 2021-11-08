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

    }

    public static ArrayList<Reservation> readReservation() {
        FileReaderWriter fi = new FileReaderWriter();
        try {
            fi.getReservation(r);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return r;
    }

    public static void checkReservationExpiry() {
        for (int i = 0; i < r.size(); i++) {
            if (LocalDate.now().isEqual(r.get(i).getReserveDate())) {
                if (LocalTime.now().isAfter(r.get(i).getReserveTime().plusMinutes(30))) {
                    r.remove(i); // Free up table
                    // remove from txt file;
                }
            }

        }
    }

    public static void addReservationBooking(Reservation r1) {
        checkReservationExpiry();
        r.add(r1);
        System.out.println("Reservation Confirmed. Table allocated is table " + r1.getTableNo());
        System.out.println();

        try {

            // RestaurantReserveSystem/datatxt/MainCourse.txt
            String fileName = "RestaurantReserveSystem/datatxt/Reservation.txt";
            Scanner sc = new Scanner(fileName);
            sc.useDelimiter("\\s*,\\s*");
            FileWriter reservationWriter = new FileWriter(fileName, true);
            PrintWriter reservationPrinter = new PrintWriter(reservationWriter);
            if (r.size() == 1) {
                reservationPrinter.print(r1.getReserveTime() + ", " + r1.getReserveDate() + "," + r1.getNumOfPax() + ","
                        + r1.getCustName() + "," + r1.getCustContact() + "," + r1.getTableNo());
                reservationPrinter.close();
            } else {
                reservationPrinter
                        .print("\n," + r1.getReserveTime() + ", " + r1.getReserveDate() + "," + r1.getNumOfPax() + ","
                                + r1.getCustName() + "," + r1.getCustContact() + "," + r1.getTableNo());
                reservationPrinter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void removeReservationBooking(int number) {
        checkReservationExpiry();
        for (int i = 0; i < r.size(); i++) {
            if (r.get(i).getCustContact() == number) {
                TableMgr.unassignTable(r.get(i).getTableNo());
                r.remove(i);
                System.out.println("Reservation successfully removed!");
                System.out.println();
                return;
            }
        }  System.out.println("Reservation does not exist!\n");

    }

    public static void checkReservationBooking(int number) {
        checkReservationExpiry();
        for (int i = 0; i < r.size(); i++) {
            if (r.get(i).getCustContact() == number) {
                System.out.println("Reservation valid under " + r.get(i).getCustName() + " at "
                        + r.get(i).getReserveTime() + " on " + r.get(i).getReserveDate() + " for "
                        + r.get(i).getNumOfPax() + " pax, table number is " + r.get(i).getTableNo());
                        System.out.println();
                return;
            }
                
        } System.out.println("Reservation does not exist!");
        System.out.println();
    }

    public static void displayReservation() throws FileNotFoundException {
        // FileReaderWriter.getReservation(r);
        String spaceNeeded = "            ";
        System.out.println("Date            Time            Name            Pax            Contact            TableNo");
        for (int i = 0; i < r.size(); i++) {
            System.out.println(r.get(i).getReserveDate() + spaceNeeded.substring(0, spaceNeeded.length() - Integer.toString(i).length()) + r.get(i).getReserveTime() + spaceNeeded.substring(0, spaceNeeded.length() - Integer.toString(i).length())
                    + r.get(i).getCustName() + spaceNeeded.substring(0, spaceNeeded.length() - Integer.toString(i).length()) + r.get(i).getNumOfPax() + spaceNeeded.substring(0, spaceNeeded.length() - Integer.toString(i).length()) + r.get(i).getCustContact()
                    + spaceNeeded.substring(0, spaceNeeded.length() - Integer.toString(i).length()) + r.get(i).getTableNo());
        }
        System.out.println();
    }
}