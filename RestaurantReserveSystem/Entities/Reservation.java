package Entities;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a Reservation in the restaurant.
 * 
 * @author Shannen Lee
 * @version 1.0
 * @since 2021-11-12
 */

public class Reservation {

	/**
	 * The number of pax of the Reservation.
	 */
	private int numOfPax;

	/**
	 * The customer name of the Reservation.
	 */
	private String custName;

	/**
	 * The customer contact of the Reservation.
	 */
	private int custContact;

	/**
	 * The reservation time of the Reservation.
	 */
	private LocalTime reserveTime;

	/**
	 * The reservation date of the Reservation.
	 */
	private LocalDate reserveDate;

	/**
	 * The table of the Reservation.
	 */
	private Table table;

	/**
	 * Creates a new Reservation with the given number of pax, customer name,
	 * customer contact, reservation time, reservation date and table.
	 * 
	 * @param reserveTime This Reservation's reservation time.
	 * @param reserveDate This Reservation's reservation date.
	 * @param numOfPax    This Reservation's number of pax.
	 * @param custName    This Reservation's customer name.
	 * @param custContact This Reservation's customer contact.
	 * @param table       This Reservation's table.
	 */
	public Reservation(LocalTime reserveTime, LocalDate reserveDate, int numOfPax, String custName, int custContact,
			Table table) {
		this.numOfPax = numOfPax;
		this.custName = custName;
		this.custContact = custContact;
		this.reserveTime = reserveTime;
		this.reserveDate = reserveDate;
		this.table = table;
	}

	/**
	 * Gets the reservation date of this Reservation.
	 * 
	 * @return this Reservation's reservation date.
	 */
	public LocalDate getReserveDate() {
		return this.reserveDate;
	}

	/**
	 * Gets the reservation time of this Reservation.
	 * 
	 * @return this Reservation's reservation time.
	 */
	public LocalTime getReserveTime() {
		return this.reserveTime;
	}

	/**
	 * Gets the number of pax of this Reservation.
	 * 
	 * @return this Reservation's number of pax.
	 */
	public int getNumOfPax() {
		return this.numOfPax;
	}

	/**
	 * Gets the reservation date of this Reservation.
	 * 
	 * @return this Reservation's reservation date.
	 */
	public String getCustName() {
		return this.custName;
	}

	/**
	 * Gets the customer name of this Reservation.
	 * 
	 * @return this Reservation's customer name.
	 */
	public int getCustContact() {
		return this.custContact;
	}

	/**
	 * Gets the table number of this Reservation by calling getTableNo() in Table
	 * class.
	 * 
	 * @return this Reservation's table number.
	 */
	public int getTableNo() {
		return this.table.getTableNo();
	}

	/**
	 * Changes the reservation date of this Reservation.
	 * 
	 * @param reserveDate This Reservation's new reservation date.
	 */
	public void setDate(LocalDate reserveDate) {
		this.reserveDate = reserveDate;
	}

	/**
	 * Changes the reservation time of this Reservation.
	 * 
	 * @param reserveTime This Reservation's new reservation time.
	 */
	public void setTime(LocalTime reserveTime) {
		this.reserveTime = reserveTime;
	}

	/**
	 * Changes the customer name of this Reservation.
	 * 
	 * @param custName This Reservation's new customer name.
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * Changes the number of pax of this Reservation.
	 * 
	 * @param numOfPax This Reservation's new number of pax.
	 */
	public void setNumOfPax(int numOfPax) {
		this.numOfPax = numOfPax;
	}

	/**
	 * Changes the customer contact of this Reservation.
	 * 
	 * @param custContact This Reservation's new customer contact.
	 */
	public void setCustContact(int custContact) {
		this.custContact = custContact;
	}

}
