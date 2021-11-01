import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.ArrayList;

public class ReservationUI {

    protected ArrayList<Table> tableArr;

    public ReservationUI() 
    {
        this.tableArr = new ArrayList<Table>();
    }

	public static void CreateReservation() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter date of reservation in the format of YYYY-MM-DD: ");
		LocalDate date	= LocalDate.parse(sc.nextLine());
		LocalDate today = LocalDate.now();

		//Check reservation date is not in the past
		if(date.isBefore(today)) {
			System.out.println("Invalid Date");
			return;
		}
		
		System.out.println("Enter time of arrival in the format of hh:mm");
		LocalTime time = LocalTime.parse(sc.nextLine());
		

		System.out.println("Enter number of pax:");
		int pax = sc.nextInt();
		
		int choice=0;
		
		do{
			if(choice==1) {
				System.out.println("Enter date of reservation in the format of YYYY-MM-DD: ");
				date = LocalDate.parse(sc.nextLine());
				
				//Check reservation date is not in the past
				if(date.isBefore(today)) {
					System.out.println("Invalid Date");
					return;
				}
				
				System.out.println("Enter time of arrival in the format of hh:mm");
				time = LocalTime.parse(sc.nextLine());
			}
			
		
			for(int i=0; i< tableArr.size;i++) {
				if(tableArr.get(i).getMaxNumOfSeats()>=pax && tableArr.get(i).getAvailStatus()==false) {
					System.out.println("Enter customer contact number: \n");
					String number = sc.nextLine();
		/////////////////////////////////////////////////////////////////////////////////////////////// 
					Reservation r = new Reservation(date, time, pax, name, number, tableArr[i]);
					Manager.ReservationMgr.update(date, session, tableArr[i].tableNo, r);
					Manager.ReservationMgr.refreshSessionReservations();
					System.out.println("Reservation successfully created!");
					return;
				}
			}
			
			System.out.println("Unable to make reservation, no available table. ");
			System.out.println("Enter your choice: 1) Choose another date and time 2) Exit");
			choice = sc.nextInt();
			
		} while(choice<2);
	}
	
	
	public static void removeReservationBooking() {
		Scanner sc = new Scanner(System.in);
		LocalDate date;
		int session;
		String number; 
		
		System.out.println("Enter date of reservation to remove in format YYYY-MM-DD:");
		date = LocalDate.parse(sc.nextLine());

		System.out.println("Enter number used to confirm reservation:");
		number = sc.nextLine();


		for(int i=0;i<tableArr.length;i++) {
			if(tableArr[i].tableReservation != null) {
				if(tableArr[i].tableReservation.getCustContact().equals(number)) {
					mgr.ReservationMgr.update(date, session, tableArr[i].tableReservation.tab.tableId, null);
					mgr.ReservationMgr.refreshSessionReservations();
					System.out.println("Reservation successfully removed!");
					return;
				}
			}
		}
		System.out.println("Reservation invalid");
	}
	
	public static void displayReservations() {
		Scanner sc = new Scanner(System.in);
		LocalDate date;
		int session;
		
		System.out.println("Enter date of reservation to display in format YYYY-MM-DD:");
		date = LocalDate.parse(sc.nextLine());

		System.out.println("Current reservations:");

		for(int i=0;i<tableArr.length;i++) {
			if(tableArr[i].tableReservation != null) {
				Reservation r = tableArr[i].tableReservation;
				System.out.printf("Reservation at %s, %s for %d pax.\nTable number: %d\nCreator: %s\nNumber: %s\n\n", r.reserveTime.toString(), r.reserveDate.toString(), r.numOfPax, r.tab.tableId, r.getName(), r.getNum());

			}
		}

		System.out.println("Reservations displayed");
	}


    public static void checkReservationBooking(){
    Scanner sc = new Scanner(System.in);
		LocalDate date;
		int session;
		String number; 
		
		System.out.println("Enter date of reservation to check in format YYYY-MM-DD:");
		date = LocalDate.parse(sc.nextLine());
		
		
		System.out.println("Enter number used to confirm reservation:");
		number = sc.nextLine();
		
        
		for(int i=0;i<tableArr.length;i++) {
			if(tableArr[i].tableReservation != null) {
				if(tableArr[i].tableReservation.getNum().equals(number)) {
					System.out.println("Reservation valid!");
					return;
				}
			}
		}
		System.out.println("Reservation invalid!");
    }
}