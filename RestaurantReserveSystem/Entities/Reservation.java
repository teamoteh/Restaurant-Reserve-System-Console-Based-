package Entities;
//import java.util.Date;

public class Reservation {

	private int numOfPax;
	private String custName;
	private int custContact;
	private String reserveTime;
	private String reserveDate;
	private int tableNo;
	private ArrayList<Table> table;
	
/*public Reservation ()
	{
		reserveDate = null;
		reserveTime = null;
		numOfPax = 0;
		custName = null;
		custContact = 0;
		tableNo = 0;
	}*/

public Reservation (int numOfPax, String custName, int custContact, String reserveTime, String reserveDate, ArrayList<Table> table)
{
	this.numOfPax=numOfPax;
	this.custName=custName;
	this.custContact=custContact;
	this.reserveTime=reserveTime;
	this.reserveDate=reserveDate;
	this.table=table;
}

// get methods

public String getReserveDate() {
	return this.reserveDate;
}

public String getReserveTime()
{
	return this.reserveTime;
} 

public int getNumOfPax()
{
	return this.numOfPax;
}

public String getCustName()
{
	return this.custName;
}

public int getCustContact()
{
	return this.custContact;
}



//set methods

public void setDate(String reserveDate)
{
  	this.reserveDate = reserveDate;
}

public void setTime(String reserveTime)
{
	this.reserveTime = reserveTime;
}


public void setCustName(String custName){
    this.custName = custName;
}

public void setNumOfPax(int numOfPax){
    this.numOfPax = numOfPax;
}

public void setCustContact(int custContact){
    this.custContact = custContact;
}


public void bookTable(int tableNo)
{
	//Changed it from Table.availStatus to Table.getAvailStatus() since availStatus is private to Table
	// availStatus is boolean as well
	// and by the way I don't think you can directly do this because it is not a static method as well.
	// maybe use a table variable?
	if (Table.getAvailStatus() == true)
	{
		Table.getAvailStatus() = false;
		System.out.printf("Table" + table.TableNo + " has been successfully reserved." );
	}
	
	else
	{
		System.out.printf("Table" + table.TableNo + " has been reserved already. Please choose another table" );
	}
}

public void unbookTable(int tableNo)
{
	Table.getAvailStatus() = true;
	System.out.printf("Table" + tableNo + " has been unreserved." );
}

}
