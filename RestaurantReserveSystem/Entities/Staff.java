package Entities;

/**
 * Staff Class which represents the Staff working in the Restaurant.
 * 
 * @author Timothy Lim
 * @version 1.0
 * @since 2021-11-12
 */

public class Staff {

	/**
	 * The name of the Staff.
	 */
	private String staffName;

	/**
	 * The gender of the Staff.
	 */
	private String staffGender;

	/**
	 * The ID of the Staff.
	 */
	private int staffId;

	/**
	 * The Job title of the Staff.
	 */
	private String jobTitle;

	/**
	 * Default constructor.
	 */
	public Staff() {
		staffName = null;
		staffGender = null;
		staffId = 0;
		jobTitle = null;
	}

	/**
	 * Creates a new Staff with the given Staff Name, Staff Gender, Staff ID and the
	 * Job Title of the Staff
	 *
	 * @param name   The name of the Staff.
	 * @param gender The gender of the Staff.
	 * @param id     The ID of the Staff.
	 * @param title  The job title of the Staff.
	 */
	public Staff(String name, String gender, int id, String title) {
		this.staffName = name;
		this.staffGender = gender;
		this.staffId = id;
		this.jobTitle = title;
	}

	/**
	 * Gets the name of this Staff.
	 * 
	 * @return this Staff's name.
	 */
	public String getStaffName() {
		return this.staffName;
	}

	/**
	 * Gets the gender of this Staff.
	 * 
	 * @return this Staff's gender.
	 */
	public String getStaffGender() {
		return this.staffGender;
	}

	/**
	 * Gets the ID of this Staff.
	 * 
	 * @return this Staff's ID.
	 */
	public int getStaffId() {
		return this.staffId;
	}

	/**
	 * Gets the Job Title of this Staff.
	 * 
	 * @return this Staff's Job Title.
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * Changes the name of this Staff.
	 * 
	 * @param staffName This Staff's new name.
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	/**
	 * Changes the gender of this Staff.
	 * 
	 * @param staffGender This Staff's new gender.
	 */
	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}

	/**
	 * Changes the ID of this Staff.
	 * 
	 * @param staffId This Staff's new name.
	 */
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	/**
	 * Changes the Job title of this Staff.
	 * 
	 * @param jobTitle This Staff's new Job Title.
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}