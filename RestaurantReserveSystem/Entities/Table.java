package Entities;

public class Table {
    private int TableNo;
    private int maxNumOfSeats;
    private Boolean availStatus;
    private String contactNo;

    public Table(){
        TableNo = 0;
        maxNumOfSeats = 0;
        availStatus = true;
        contactNo = null;
    }

    public Table(int No, int maxSeats){
        this.TableNo = No;
        setMaxNumSeats(maxSeats);
        this.availStatus = true;
        this.contactNo = null;
    }

    public int getTableNo(){
        return this.TableNo;
    }

    public int getMaxNumSeats(){
        return this.maxNumOfSeats;
    }

    public boolean getAvailStatus(){
        return this.availStatus;
    }

    public String getContactNo(){
        return this.contactNo;
    }

    public void setTableNo(int No){
        this.TableNo = No;
    }

    public void setUnavailStatus(){
        this.availStatus = false;
    }

    public void setContact(String contact){
        this.contactNo = contact;
    }
    
    public void setMaxNumSeats(int maxSeats){
        if(maxSeats % 2 == 1){
            System.out.println("Please input an even number.");
        }

        else if(maxSeats % 2 == 0){
            this.maxNumOfSeats = maxSeats;
        }
    }

}
