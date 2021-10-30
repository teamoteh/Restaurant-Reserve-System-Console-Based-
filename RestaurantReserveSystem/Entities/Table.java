package Entities;

public class Table {
    private int TableNo;
    private int maxNumOfSeats;
    private Boolean availStatus;
    private String contactNo;

    public Table(){
        TableNo = 0;
        maxNumOfSeats = 0;
        availStatus = 0;
        contactNo = null;
    }

    public Table(int No, int maxSeats){
        this.TableNo = No;
        this.maxNumOfSeats = maxSeats;
        this.availStatus = 0;
        this.contactNo = null;
    }

    public int getTableNo(){
        return this.TableNo;
    }

    public int getMaxNumSeats(){
        return this.maxNumOfSeats;
    }

    public String getAvailStatus(){
        return this.availStatus;
    }

    public String getContactNo(){
        return this.contactNo;
    }

    public void setTableNo(int No){
        this.TableNo = No;
    }

    public void setMaxNumSeats(int maxSeats){
        this.maxNumOfSeats = maxSeats;
    }

}
