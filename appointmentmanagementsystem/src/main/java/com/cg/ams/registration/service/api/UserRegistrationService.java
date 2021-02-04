package com.cg.ams.registration.service.api;

import com.cg.ams.login.exception.UserLoginNotFoundException;
import com.cg.ams.registration.entity.UserRegistration;
import com.cg.ams.registration.entity.UserUnRegisterRequest;
import com.cg.ams.registration.exception.UserRegistrationFailedException;

public interface UserRegistrationService {

	
	/***
	 * Service method to fetch all Online Chefs db.
	 * 
	 * @param SearchOnlineChefRequest
	 * @return List<OnlineChef>
	 * @throws UserLoginNotFoundException 
	 */
	
	public Boolean userRegistrationProcess(UserRegistration request) throws UserRegistrationFailedException;
	
	public Boolean userUnRegistrationProcess(UserUnRegisterRequest request) throws UserRegistrationFailedException;
	
}
