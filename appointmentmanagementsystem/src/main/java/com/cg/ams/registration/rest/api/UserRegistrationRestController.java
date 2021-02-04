package com.cg.ams.registration.rest.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.cg.ams.registration.entity.UserRegistration;
import com.cg.ams.registration.entity.UserUnRegisterRequest;
import com.cg.ams.registration.exception.UserRegistrationFailedException;


/**
 * @author Arpan Adhikary
 * Interface for chef controller
 *
 */
public interface UserRegistrationRestController {

	/***
	 * Request to .
	 * 
	 * @requestBody
	 * @return ResponseEntity
	 * @throws  
	 * 
	 */
	public ResponseEntity<Boolean> userRegistration(
			@RequestBody UserRegistration request) throws UserRegistrationFailedException;

	public ResponseEntity<Boolean> userUnRegister(
			@RequestBody UserUnRegisterRequest request) throws UserRegistrationFailedException;

}
