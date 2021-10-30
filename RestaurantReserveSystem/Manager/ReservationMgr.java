public class ReservationMgr {

public static void checkReservationExpiry(Reservation r) {
    if(LocalTime.now().isAfter(r.rTime.plusMinutes(30))) {
        cancelReservation(r);	//Free up table
    }
}

public static void clearExpiredReservations(ArrayList<Table> t) {
    for(int i=0;i<t.size();i++) {
        if(t.get(i).tableReservation != null) {
            checkReservationExpiry(t.get(i).tableReservation);
        }
    }
    System.out.println("Expired reservations removed!");
}


public static void refreshSessionReservations() {
    entities.Restaurant.initReservations();
}

public static void update(LocalDate date, int session, int tableID, Reservation r) {
    //String sessionStr = (session == 1?"AM":"PM");
    //String fileName = "reservation"+date+sessionStr+".dat";
    //Table[] temp = db.fileIO.readReservation(fileName);
    for(int i=0;i<temp.length;i++) {
        if(temp[i].tableId == tableID) {
            temp[i].tableReservation = r;
        }
    }
    db.fileIO.write(temp, fileName);
}

public static void removeReservationBooking(Reservation r) {
    for(int i=0;i<entities.Restaurant.sessionReservations.size();i++) {
        if(entities.Restaurant.sessionReservations.get(i).tableId == r.tab.tableId) {
            entities.Restaurant.sessionReservations.get(i).tableReservation = null;
        }
    }
}
}
