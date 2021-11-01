package Manager;

import db.Restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.Staff;
public class StaffMgr{
    public static ArrayList<Staff> staffList = new ArrayList<Staff>();

    public void getStaffIdentity(int id ){
        for (Staff staff : this.staffList){
            if(staff.getStaffId() == id){
                System.out.println("The Staff's Name is:" + staff.getStaffName());
                System.out.println("The Staff's Job Title is:" + staff.getJobTitle());
                System.out.println("The Staff's Gender' is:" + staff.getStaffGender());
                System.out.println("The Staff's ID' is:" + staff.getStaffId());
            }
        }
    }

    public void getStaffs(ArrayList<Staff> staffs) throws FileNotFoundException
	      {
      		  File file = new File("/Users/pranwanth/eclipse-workspace/assignmentTest/src/assignmentTest/drinks.txt");
      		  Scanner sc = new Scanner(file);
		      sc.useDelimiter("\\s*,\\s*");
	
		      do{
		    	  	String staffName = sc.next();
		          	String staffGender = sc.next();
		          	int staffID = Integer.parseInt(sc.next());
		            String staffTitle = sc.next();
		            Staff staffPerson = new Staff(staffName, staffGender, staffID, staffTitle);
		            staffs.add(staffPerson);
		      }
		      while(sc.hasNextLine());     
		     sc.close();
	      }
}
