package Manager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import Entities.Table;
//import db.Restaurant;

public class TableMgr {

    protected static ArrayList<Table> tables = new ArrayList<Table>();

    // FileReader for Tables
    public static void readTables(ArrayList<Table> tables) throws FileNotFoundException {
        File file = new File("RestaurantReserveSystem/datatxt/Table.txt");
        // RestaurantReserveSystem/datatxt/Table.txt
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\s*,\\s*");

        while (sc.hasNextLine()) {
            // System.out.println(sc.nextInt());
            // System.out.println(sc.nextInt());
            // .getClass().getName() -> to check class type
            // System.out.println(sc.nextBoolean());
            int tableID = sc.nextInt();
            int tableMaxSeats = sc.nextInt();
            boolean availStatus = Boolean.parseBoolean(sc.next());

            Table table = new Table(tableID, tableMaxSeats, availStatus);
            tables.add(table);
            // System.out.println("prawn");
        }
        // sc.close();
    }

    public static void write(String address, String text) throws IOException {
        try {
            FileWriter fw = new FileWriter(address, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(text);
            out.close();
            // more code
        } catch (IOException e) {
            // exception handling left as an exercise for the reader
        }
    }

    // not sure if need addRestTables
    public static void addRestTables(int num) {
        for (int i = 0; i < num; i++) {
            int nseats;

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number of seats: ");
            nseats = sc.nextInt();
            tables.add(new Table(i, nseats, true));
            // sc.close();
        }
    }

    public static ArrayList<Table> findAvailTables(ArrayList<Table> t) {
        for (Table table : tables) {
            if (table.getAvailStatus() == true) {
                t.add(table);
            }
        }
        return t;
    }

    public static void deleteRestTables(int index) {
        tables.remove(index - 1);
        System.out.println("Table %f has been removed.");
    }

    public static ArrayList<Table> getTableList() {
        return tables;
    }

    // May need optimisation if have time
    public static Table assignTable(int pax) {
        for (int i = 0; i < tables.size(); i++) {
            if (tables.get(i).getAvailStatus() == true) {
                if (tables.get(i).getMaxNumSeats() == pax) {
                    tables.get(i).setUnavailStatus();
                    return tables.get(i);
                } else if (tables.get(i).getMaxNumSeats() - pax == 1) {
                    tables.get(i).setUnavailStatus();
                    return tables.get(i);
                } else if (tables.get(i).getMaxNumSeats() > pax) {
                    tables.get(i).setUnavailStatus();
                    return tables.get(i);
                }
            }
        }
        return null;
    }

    public static void unassignTable(int tableNum){
        tables.get(tableNum - 1).setAvailStatus();
    }
}
