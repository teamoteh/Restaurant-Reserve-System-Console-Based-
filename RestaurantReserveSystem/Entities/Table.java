package Entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Represents a Table in the restaurant.
 * 
 * @author Jovian Nursan Ng
 * @version 1.0
 * @since 2021-11-12
 */
public class Table {

    /**
     * The index number of the Table.
     */
    private int TableNo;

    /**
     * The number of seats of the Table.
     */
    private int maxNumOfSeats;

    /**
     * The availability status of the Table. When the availStatus is true, the Table
     * is available. When the availStatus is false, the Table is unavailable.
     */
    private boolean availStatus;

    /**
     * Creates a new Table.
     */
    public Table() {
        TableNo = 0;
        maxNumOfSeats = 0;
        availStatus = true;
    }

    /**
     * Creates a new Table with the given table number, number of seats and
     * availability status.
     * 
     * @param No           This Table's table number.
     * @param maxSeats     This Table's number of seats.
     * @param availStatus2 This Table's availability status.
     */
    public Table(int No, int maxSeats, boolean availStatus2) {
        this.TableNo = No;
        setMaxNumSeats(maxSeats);
        availStatus = availStatus2;
    }

    /**
     * Gets the table number of this Table.
     * 
     * @return this Table's table number.
     */
    public int getTableNo() {
        return this.TableNo;
    }

    /**
     * Gets the number of seats of this Table.
     * 
     * @return this Table's number of seats.
     */
    public int getMaxNumSeats() {
        return this.maxNumOfSeats;
    }

    /**
     * Gets the availability status of this Table.
     * 
     * @return this Table's availability status.
     */
    public boolean getAvailStatus() {
        return this.availStatus;
    }

    /**
     * Changes the table number of this Table.
     * 
     * @param No This Table's new table number.
     */
    public void setTableNo(int No) {
        this.TableNo = No;
    }

    /**
     * Changes the availability status of this Table from available to unavailable.
     */
    public void setUnavailStatus() {
        this.availStatus = false;
    }

    /**
     * Changes the availability status of this Table from unavailable to available.
     */
    public void setAvailStatus() {
        this.availStatus = true;
    }

    /**
     * Changes the number of seats of this Table. If the new value for the number of
     * seats is odd, it will ask the user to input an even number.
     * 
     * @param maxSeats This Table's new value for number of seats.
     */
    public void setMaxNumSeats(int maxSeats) {
        if (maxSeats % 2 == 1) {
            System.out.println("Please input an even number.");
        }

        else if (maxSeats % 2 == 0) {
            this.maxNumOfSeats = maxSeats;
        }
    }

}
