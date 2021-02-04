package com.cg.ams.registration.rest.impl;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ams.registration.entity.UserRegistration;
import com.cg.ams.registration.entity.UserUnRegisterRequest;
import com.cg.ams.registration.exception.UserRegistrationFailedException;
import com.cg.ams.registration.rest.api.UserRegistrationRestController;
import com.cg.ams.registration.service.api.UserRegistrationService;


/**
 * @author ARPAN ADHIKARY AADHIKAR
 * class for chef controller
 *
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/api/1.0")
public class UserRegistrationRestControllerImpl implements UserRegistrationRestController {

	/**
	 * create logger object.
	 */
	private static final Logger LOGGER= LoggerFactory.getLogger(UserRegistrationRestControllerImpl.class);

	@Autowired
	private UserRegistrationService userRegistrationService;

	/***
	 * Request to fetch User details.
	 * 
	 * @requestBody 
	 * @return ResponseEntity
	 * @throws UserRegistrationFailedException
	 * {@link localhost:8081/api/1.0/registration}
	 */
	
	/* 
	 {
    "username": "Arpan1345@",
    "name": "Arunava",
    "mobileNo": "8296758979",
    "emailId": "arunava1234.com",
    "password": "Qwerty123@"
	} 
	*/
	
	@PostMapping(path = "/registration")
	@Override
	public ResponseEntity<Boolean> userRegistration(@Valid @RequestBody UserRegistration request) throws UserRegistrationFailedException {
		LOGGER.info("User Regisration logical operation");
		
		return new ResponseEntity<Boolean>(
				userRegistrationService.userRegistrationProcess(request), HttpStatus.OK);
	}

	@PostMapping(path = "/unregister")
	@Override
	public ResponseEntity<Boolean> userUnRegister(UserUnRegisterRequest request)
			throws UserRegistrationFailedException {
		return new ResponseEntity<Boolean>(
				userRegistrationService.userUnRegistrationProcess(request), HttpStatus.OK);
	}

	
}
