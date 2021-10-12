package RestaurantReserveSystem;
//import java.util.Date;

public class Reservation {

	private int numOfPax;
	private String custName;
	private int custContact;
	private String reserveTime;
	private String reserveDate;
	
public Reservation ()
	{
		reserveDate = null;
		reserveTime = null;
		numOfPax = 0;
		custName = null;
		custContact = 0;
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



}
