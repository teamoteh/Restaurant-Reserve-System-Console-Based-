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

/**
 * Represents the class which manages anything related to the tables in the
 * restaurant.
 * 
 * @author Jovian Nursan Ng
 * @version 1.0
 * @since 2021-11-12
 */
public class TableMgr {

    /**
     * The array list containing all the tables and their attributes in the
     * restaurant.
     */
    protected static ArrayList<Table> tables = new ArrayList<Table>();

    /**
     * Reads the file Table.txt and inputs the data in the text file into the
     * ArrayList tables.
     * 
     * @param tables The array list containing all the tables and their attributes
     *               in the restaurant.
     * @throws FileNotFoundException
     */
    public static void readTables(ArrayList<Table> tables) throws FileNotFoundException {
        File file = new File("RestaurantReserveSystem/datatxt/Table.txt");
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\s*,\\s*");

        while (sc.hasNextLine()) {
            int tableID = sc.nextInt();
            int tableMaxSeats = sc.nextInt();
            boolean availStatus = Boolean.parseBoolean(sc.next());

            Table table = new Table(tableID, tableMaxSeats, availStatus);
            tables.add(table);
        }
    }

    /**
     * Adds Tables into the array list tables.
     * 
     * @param num The number of Tables that will be added into the array list
     *            tables.
     */
    public static void addRestTables(int num) {
        for (int i = 0; i < num; i++) {
            int nseats;

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number of seats: ");
            nseats = sc.nextInt();
            tables.add(new Table(i, nseats, true));
        }
    }

    /**
     * Finds all the available Tables in the array list tables and input them into
     * the array list t.
     * 
     * @param t The array list containing all the available Tables in the
     *          restaurant.
     * @return The array list t.
     */
    public static ArrayList<Table> findAvailTables(ArrayList<Table> t) {
        for (Table table : tables) {
            if (table.getAvailStatus() == true) {
                t.add(table);
            }
        }
        return t;
    }

    /**
     * Deletes the Table with the specific index number from the array list tables.
     * 
     * @param index The index number of the Table which will be removed from the
     *              array list.
     */
    public static void deleteRestTables(int index) {
        tables.remove(index - 1);
        System.out.println("Table %f has been removed.");
    }

    
    /** 
     * @return ArrayList<Table>
     */
    public static ArrayList<Table> getTableList() {
        return tables;
    }

    /**
     * Assign a suitable available Table to a customer according to the number of
     * people.
     * 
     * @param pax The number of people.
     * @return The index of the assigned Table.
     */
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

    /**
     * Unassign a Table which was previously assigned to a customer. Sets the
     * availability status of the Table to available.
     * 
     * @param tableNum The index number of the Table that is to be unassigned.
     */
    public static void unassignTable(int tableNum) {
        tables.get(tableNum - 1).setAvailStatus();
    }
}
