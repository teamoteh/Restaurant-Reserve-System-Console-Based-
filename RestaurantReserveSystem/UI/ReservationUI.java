package UI;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import Entities.Reservation;
import Entities.Table;
import Manager.ReservationMgr;
import Manager.TableMgr;


public class ReservationUI {
	public static void displayReservationUI() throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int user_choice;

		do {
			
		System.out.println("What would you like to do?");
		System.out.println("1. Create Reservation\n" + "2. Check Reservation\n" + "3. Remove Reservation\n"
				+ "4. Display Reservation\n" + "5. Exit\n");
		
		System.out.println("Input a choice:");
		user_choice = sc.nextInt();
		
		
		switch (user_choice) {
		case 1:
			int choice;
			System.out.println("Enter name: ");
			String name = sc.next();
			do {
				System.out.println("Enter date of reservation in the format of YYYY-MM-DD: ");
				LocalDate date = LocalDate.parse(sc.next());
				LocalDate today = LocalDate.now();
				// Check reservation date is not in the past
				if (date.isBefore(today)) {
					System.out.println("Invalid Date");
					break;
				}
				System.out.println("Enter time of arrival in the format of hh:mm");
				LocalTime time = LocalTime.parse(sc.next());
				System.out.println("Enter number of pax:");
				int pax = sc.nextInt();
				Table table = TableMgr.assignTable(pax);
				if (table == null) {
					System.out.println("Unable to make reservation, no available table. ");
						System.out.println("Enter your choice: \n1) Choose another date and time \n2) Exit");
						choice = sc.nextInt();
					}
					else {
						System.out.println("Enter contact number:");
						int number = sc.nextInt();
						Reservation r = new Reservation(time, date, pax, name, number, table);
						ReservationMgr.addReservationBooking(r);
						System.out.println("Reservation Confirmed");
						// choice = 2;
						break;
					}
				} while (choice < 2);
				break;
			
			
			case 2:
				System.out.println("Enter contact number:");
				int number = sc.nextInt();
				ReservationMgr.checkReservationBooking(number);
				break;
			
			
			case 3:
				System.out.println("Enter contact number:");
				int number2 = sc.nextInt();
				ReservationMgr.removeReservationBooking(number2);
				break;
			
			
			case 4:
				ReservationMgr.displayReservation();
				break;
			}
		} while (user_choice > 0 && user_choice < 5);
	}
}