public class Table {
    private int TableNo;
    private int maxNumOfSeats;
    private Boolean availStatus;
    private String reserverName;

    public Table(){
        TableNo = 0;
        maxNumOfSeats = 0;
        availStatus = 0;
        reserverName = null;
    }

    public Table(int No, int maxSeats){
        this.TableNo = No;
        this.maxNumOfSeats = maxSeats;
        this.availStatus = 0;
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

    public String getReserveName(){
        return this.reserverName;
    }

    public void setTableNo(int No){
        this.TableNo = No;
    }

    public void setMaxNumSeats(int maxSeats){
        this.maxNumOfSeats = maxSeats;
    }

}
