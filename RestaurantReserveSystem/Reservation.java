package RestaurantReserveSystem;
//import java.util.Date;

public class Reservation {
	//private date; // not sure what data type to use for date n time
	//private time; // convert the int input to string? idk
	private int numOfPax;
	private String custName;
	private int custContact;
	
public Reservation ()
	{
		//date = ;
		//time = ;
		numOfPax = 0;
		custName = null;
		custContact = 0;
	}

// get methods

//public getDate() {
//	return this.date;
//}

//public getTime()
//{
//	return this.time;
//} 

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

//public void setDate( date){
//  this.date = date;
//}

//public void setTime( time){
//this.time = time;
//}


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
