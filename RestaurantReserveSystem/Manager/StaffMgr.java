package Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.Staff;

/**
 * Represents the class which manages anything related to the Staffs in the
 * restaurant.
 * 
 * @author Timothy Lim
 * @version 1.0
 * @since 2021-11-12
 */
public class StaffMgr {
	/**
	 * An ArrayList of all the Restaurant Staff
	 */
	protected static ArrayList<Staff> staffList = new ArrayList<Staff>();

	/**
	 * Gets the Staff's Name, Job Title, Gender and ID
	 * @param id 
	 */
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

	/**
	 * File Reader function to read data in the Staff txt file and stores the values
	 * and its relative attributes in the Array List
	 * 
	 * @param staffs The Array List to store attributes.
	 */
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

	/**
	 * Gets the Array List of Staffs
	 * 
	 * @return ArrayList<Staff>
	 */
	public static ArrayList<Staff> getStaffList() {
		return staffList;
	}
}
