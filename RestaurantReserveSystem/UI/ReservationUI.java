package UI;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import Entities.Reservation;
import Entities.Table;
import Manager.ReservationMgr;
import Manager.TableMgr;

/**
 * Reservation Console UI to display Reservation options
 * 
 * @author Shannen
 * @version 1.0
 * @since 2021-11-12
 */

public class ReservationUI {

	/**
	 * Displays all the Reservation console UI options
	 * 
	 * @throws FileNotFoundException
	 */
	public static void displayReservationUI() throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int user_choice;

		do {

			System.out.println("What would you like to do?");
			System.out.println("1. Create Reservation\n" + "2. Check Reservation\n" + "3. Remove Reservation\n"
					+ "4. Display Reservation\n" + "5. Exit\n");

			System.out.println("Input a choice:");
			user_choice = Integer.parseInt(sc.nextLine());

			while (!(user_choice > 0 && user_choice < 6)) {
				System.out.println("Invalid Option. Please key try again!\n");
				System.out.println("What would you like to do?");
				System.out.println("1. Create Reservation\n" + "2. Check Reservation\n" + "3. Remove Reservation\n"
						+ "4. Display Reservation\n" + "5. Exit\n");
				System.out.println("Input a choice:");
				user_choice = Integer.parseInt(sc.nextLine());
			}

			switch (user_choice) {
			case 1:
				int choice;
				System.out.println("Enter name: ");
				String name = sc.nextLine();
				do {
					System.out.println("Enter date of reservation in the format of YYYY-MM-DD: ");
					LocalDate date = LocalDate.parse(sc.nextLine());
					LocalDate today = LocalDate.now();
					// Check reservation date is not in the past
					while (date.isBefore(today)) {
						System.out.println("Invalid Date. Please key try again:");
						date = LocalDate.parse(sc.nextLine());
					}
					System.out.println("Enter time of arrival in the format of hh:mm");
					LocalTime time = LocalTime.parse(sc.nextLine());
					System.out.println("Enter number of pax:");
					int pax = Integer.parseInt(sc.nextLine());
					Table table = TableMgr.assignTable(pax);
					if (table == null) {
						System.out.println("Unable to make reservation, no available table. ");
						System.out.println("Enter your choice: \n1. Choose another date and time \n2. Exit");
						choice = Integer.parseInt(sc.nextLine());
					} else {
						System.out.println("Enter contact number:");
						int number = Integer.parseInt(sc.nextLine());
						Reservation r = new Reservation(time, date, pax, name, number, table);
						ReservationMgr.addReservationBooking(r);
						break;
					}
				} while (choice < 2);
				break;

			case 2:
				System.out.println("Enter contact number:");
				int number = Integer.parseInt(sc.nextLine());
				ReservationMgr.checkReservationBooking(number);
				break;

			case 3:
				System.out.println("Enter contact number:");
				int number2 = Integer.parseInt(sc.nextLine());
				ReservationMgr.removeReservationBooking(number2);
				break;

			case 4:
				ReservationMgr.displayReservation();
				break;

			}
		} while (user_choice > 0 && user_choice < 5);
		// sc.close();
	}
}