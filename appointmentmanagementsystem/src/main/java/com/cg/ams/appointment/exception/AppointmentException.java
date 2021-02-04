package com.cg.ams.appointment.exception;

/**
 * @author Arpan Adhikary AADHIKAR
 * Class to handle chef not found exception
 *
 */

public class AppointmentException extends Exception {

	
	@Override
	public String getMessage() {
		return "No Appointment found";
	}
}
