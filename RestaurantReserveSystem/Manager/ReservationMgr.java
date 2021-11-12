package Manager;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import Entities.Reservation;
import Entities.Table;
import datatxt.FileReaderWriter;
import java.io.*;
import java.util.Scanner;

/**
 * Represents the class which manages anything related to the reservations in
 * the restaurant.
 * 
 * @author Shannen Lee
 * @version 1.0
 * @since 2021-11-12
 */
public class ReservationMgr {

    /**
     * The array list containing all the reservations and their attributes in the
     * restaurant.
     */
    protected static ArrayList<Reservation> r = new ArrayList<Reservation>();

    public ReservationMgr() throws FileNotFoundException {

    }

    /**
     * 
     * Reads the reservations from the Reservation.txt file.
     * 
     * @return ArrayList<Reservation>
     */
    public static ArrayList<Reservation> readReservation() {
        FileReaderWriter fi = new FileReaderWriter();
        try {
            fi.getReservation(r);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return r;
    }

    /**
     * Checks the expired reservations by checking if it is 30 minutes past the
     * current time.
     * 
     */
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

    /**
     * Adds reservation bookings into the array list r.
     * 
     * @param r1 The reservation that will be added into the array list of
     *           reservations
     */
    public static void addReservationBooking(Reservation r1) {
        checkReservationExpiry();
        r.add(r1);
        System.out.println("Reservation Confirmed. Table allocated is table " + r1.getTableNo());
        System.out.println();

        try {
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

    /**
     * Removes the reservation booking with the specific customer contact number
     * from the array list of reservations.
     * 
     * @param number The customer contact of the reservation which will be removed
     *               from the array list.
     */
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
        }
        System.out.println("Reservation does not exist!\n");

    }

    /**
     * Checks the reservation booking with the specific customer contact number from
     * the array list of reservations. If it is valid, the reservation details will
     * be printed. If it is not valid, it will print that the reservation does not
     * exist.
     * 
     * @param number The customer contact of the reservation which will be checked
     *               with the array list.
     */
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

        }
        System.out.println("Reservation does not exist!");
        System.out.println();
    }

    /**
     * Displays the current reservations and the reservation details
     * 
     * @throws FileNotFoundException
     */
    // "%d. %s :$%.2f\n"
    public static void displayReservation() throws FileNotFoundException {
        // FileReaderWriter.getReservation(r);
        // String spaceNeeded = " ";
        /*
         * System.out.printf("%d. %s :$%.2f\n", (index++), String.format("%-20s",
         * item.getFoodName()), item.getFoodPrice()); sum += item.getFoodPrice();
         */
        System.out.printf("%s %s %s %s %s %s", String.format("%-20s", "Date"), String.format("%-20s", "Time"),
                String.format("%-20s", "Name"), String.format("%-20s", "Pax"), String.format("%-20s", "Contact"),
                String.format("%-20s", "TableNo."));
        // System.out.printf("Date", "%-20s", "Time", "%-20s", "Name", "%-20s", "Pax",
        // "%-20s", "Contact", "%-20s",
        // "TableNo");
        System.out.println();

        for (int i = 0; i < r.size(); i++) {
            /*
             * System.out.printf("%s %s %s %s %s", r.get(i).getReserveDate(), "%-20s",
             * r.get(i).getReserveTime(), "%-20s", r.get(i).getCustName(), "%-20s",
             * r.get(i).getNumOfPax(), "%-20s", r.get(i).getCustContact(), "%-20s",
             * r.get(i).getTableNo());
             */
            System.out.printf("%s %s %s %s %s %s", String.format("%-20s", r.get(i).getReserveDate().toString()),
                    String.format("%-20s", r.get(i).getReserveTime().toString()),
                    String.format("%-20s", r.get(i).getCustName().toString()),
                    String.format("%-20s", Integer.toString(r.get(i).getNumOfPax())),
                    String.format("%-20s", Integer.toString(r.get(i).getCustContact())),
                    String.format("%-20s", Integer.toString(r.get(i).getTableNo())));
            System.out.println();
        }

    }
}