package com.cg.ams.login.rest.impl;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ams.login.entity.UserLogin;
import com.cg.ams.login.entity.UserLoginRequest;
import com.cg.ams.login.exception.UserLoginNotFoundException;
import com.cg.ams.login.rest.api.UserLoginRestController;
import com.cg.ams.login.service.api.UserLoginService;


/**
 * @author ARPAN ADHIKARY AADHIKAR
 * class for User Login rest controller
 *
 */
@RestController
@RequestMapping(path = "/api/1.0")
@CrossOrigin
public class UserLoginRestControllerImpl implements UserLoginRestController {

	/**
	 * create logger object.
	 */
	private static final Logger LOGGER= LoggerFactory.getLogger(UserLoginRestControllerImpl.class);

	@Autowired
	private UserLoginService userLoginService;

	/***
	 * Request to fetch User details.
	 * 
	 * @requestBody UserLoginRequest
	 * @return ResponseEntity
	 * @throws UserLoginNotFoundException
	 * {@link localhost:8081/api/1.0/login}
	 */
	
	@GetMapping(path="/check")
	@Override
	public ResponseEntity<String> checking()  {
		return new ResponseEntity<String>("Hello",HttpStatus.OK);
	}
	
	@PostMapping(path = "/login")
	@Override
	public ResponseEntity<UserLogin> getUserLoginBySearchRequest(
			@Valid @RequestBody UserLoginRequest request) throws UserLoginNotFoundException {
		
		LOGGER.info("LOGIN operation is performing");
		return new ResponseEntity<UserLogin>(
				userLoginService.findAllUserLoginBySearchRequest(request), HttpStatus.OK);
	}

}
