package com.cg.ams.login.exception;

/**
 * @author Arpan Adhikary AADHIKAR
 * Class to handle chef not found exception
 *
 */

public class UserLoginNotFoundException extends Exception {

	private static final long serialVersionUID = 2482565105193456017L;

	@Override
	public String getMessage() {
		return "No User found";
	}
}
