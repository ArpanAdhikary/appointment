package com.cg.ams.login.rest.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.ams.login.entity.UserLogin;
import com.cg.ams.login.entity.UserLoginRequest;
import com.cg.ams.login.exception.UserLoginNotFoundException;


/**
 * @author Arpan Adhikary
 * Interface for User Login Rest controller
 *
 */
public interface UserLoginRestController {

	/***
	 * Request to login.
	 * 
	 * @requestBody UserLoginRequest
	 * @return ResponseEntity
	 * @throws UserLoginNotFoundException 
	 * 
	 */
	public ResponseEntity<String> checking();
	public ResponseEntity<UserLogin> getUserLoginBySearchRequest(
			@RequestBody UserLoginRequest request) throws UserLoginNotFoundException;

}
