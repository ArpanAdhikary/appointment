package com.cg.ams.registration.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.ams.registration.entity.UserRegistration;
import com.cg.ams.registration.entity.UserUnRegisterRequest;
import com.cg.ams.registration.exception.UserRegistrationFailedException;
import com.cg.ams.registration.repo.UserRegistrationRepository;
import com.cg.ams.registration.service.api.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	
	@Autowired
	private UserRegistrationRepository userRepo;

	/***
	 * Service method to save record of user into db.
	 * 
	 * @param 
	 * @return 
	 * @throws UserRegistrationFailedException 
	 */
	
	/**
	 * create logger object.
	 */
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);

	@Override
	public  Boolean userRegistrationProcess(UserRegistration request) throws UserRegistrationFailedException {
	
		
		LOGGER.info("Role set to User");
		LOGGER.info("Checking if datas like user name email and mobile number is duplicated or not");
		int counter=userRepo.insertUsers(request.getEmailId(), request.getMobileNo(),request.getName(),
				request.getUsername(), request.getRole(), request.getPassword());
		if(counter==0)
			return true;
		else
			return false;
	}

	@Override
	public Boolean userUnRegistrationProcess(UserUnRegisterRequest request) throws UserRegistrationFailedException {
		int counter=userRepo.deleteUsers(request.getRequestedUserId());
		if(counter>0)
			return true;
		else
			return false;
	}

		

}
