package com.cg.ams.registration.exception;

/**
 * @author Arpan Adhikary AADHIKAR
 * Class to handle chef not found exception
 *
 */

public class UserRegistrationFailedException extends Exception {

	private static final long serialVersionUID = 2482565105193456017L;

	@Override
	public String getMessage() {
		return "Registration Failed";
	}
}
