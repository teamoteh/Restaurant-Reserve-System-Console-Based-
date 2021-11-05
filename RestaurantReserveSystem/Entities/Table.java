package Entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Table {
    private int TableNo;
    private int maxNumOfSeats;
    private boolean availStatus;

    public Table() {
        TableNo = 0;
        maxNumOfSeats = 0;
        availStatus = true;
    }

    public Table(int No, int maxSeats, boolean availStatus2) {
        this.TableNo = No;
        setMaxNumSeats(maxSeats);
        availStatus = availStatus2;
    }

    public int getTableNo() {
        return this.TableNo;
    }

    public int getMaxNumSeats() {
        return this.maxNumOfSeats;
    }

    public boolean getAvailStatus() {
        return this.availStatus;
    }

    public void setTableNo(int No) {
        this.TableNo = No;
    }

    public void setUnavailStatus() {
        this.availStatus = false;
    }

    public void setAvailStatus() {
        this.availStatus = true;
    }

    public void setMaxNumSeats(int maxSeats) {
        if (maxSeats % 2 == 1) {
            System.out.println("Please input an even number.");
        }

        else if (maxSeats % 2 == 0) {
            this.maxNumOfSeats = maxSeats;
        }
    }

    public void write(String address, String text) throws IOException {
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
}
