package RestaurantReserveSystem;

public class Staff {
	private String staffName;
	private String staffGender;
	private int staffId;
	private String jobTitle;

//constructor
public Staff () {
	staffName = null;
	staffGender = null; 
	staffId = 0;
	jobTitle = null;
}

//get methods
public String getStaffName()
{
	return this.staffName;
}

public String getStaffGender()
{
	return this.staffGender;
}

public int getStaffId()
{
	return this.staffId;
}

public String getJobTitle()
{
	return this.jobTitle;
}


//set methods
public void setStaffName(String staffName){
    this.staffName = staffName;
}

public void setStaffGender(String staffGender){
    this.staffGender = staffGender;
}

public void setStaffId(int staffId){
    this.staffId = staffId;
}

public void setJobTitle(String jobTitle){
    this.jobTitle = jobTitle;
}


}