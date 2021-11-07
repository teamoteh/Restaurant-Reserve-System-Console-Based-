package Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.Staff;

public class StaffMgr {
	public static ArrayList<Staff> staffList = new ArrayList<Staff>();

	public static void getStaffIdentity(int id) {
		for (Staff staff : staffList) {
			if (staff.getStaffId() == id) {
				System.out.println("The Staff's Name is:" + staff.getStaffName());
				System.out.println("The Staff's Job Title is:" + staff.getJobTitle());
				System.out.println("The Staff's Gender' is:" + staff.getStaffGender());
				System.out.println("The Staff's ID' is:" + staff.getStaffId());
			}
		}
	}

	public static void readStaffs(ArrayList<Staff> staffs) throws FileNotFoundException {
		File file = new File("RestaurantReserveSystem/datatxt/Staff.txt");
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\s*,\\s*");

		do {
			String staffName = sc.next();
			String staffGender = sc.next();
			int staffID = Integer.parseInt(sc.next());
			String staffTitle = sc.next();
			Staff staffPerson = new Staff(staffName, staffGender, staffID, staffTitle);
			staffs.add(staffPerson);
		} while (sc.hasNextLine());
		// sc.close();
	}

	public static ArrayList<Staff> getStaffList() {
		return staffList;
	}
}
