package Manager;

import db.Restaurant;
import java.util.ArrayList;
import Entities.Staff;
public class StaffMgr{
    private static ArrayList<Staff> staffList = Restaurant.staffs;

    public void getStaffIdentity(int id ){
        for (Staff staff : this.staffList){
            staff = new Staff();
            if(staff.getStaffId() == id){
                System.out.println("The Staff's Name is:" + staff.getStaffName());
                System.out.println("The Staff's Job Title is:" + staff.getJobTitle());
                System.out.println("The Staff's Gender' is:" + staff.getStaffGender());
                System.out.println("The Staff's ID' is:" + staff.getStaffId());
            }
        }
    }
}
