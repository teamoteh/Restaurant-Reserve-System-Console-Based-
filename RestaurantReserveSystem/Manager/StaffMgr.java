package Manager;
import java.util.ArrayList;

import Entities.Staff;
public class StaffMgr{
    private static ArrayList<Staff> staffList = new ArrayList<Staff>();

    public Staff getStaffIdentity(int id ){
        for (Staff staff : this.staffList){
            staff = new Staff();
            if(staff.getStaffId() == id){
                return staff;
            }
        }
    }
}
