package com.cg.ams.login.service.api;

import com.cg.ams.login.entity.UserLogin;
import com.cg.ams.login.entity.UserLoginRequest;
import com.cg.ams.login.exception.UserLoginNotFoundException;

public interface UserLoginService {

	
	/***
	 * Service method to login useradmin db.
	 * 
	 * @param UserLoginRequest
	 * @return UserLogin
	 * @throws UserLoginNotFoundException 
	 */
	
	public UserLogin findAllUserLoginBySearchRequest(UserLoginRequest request) throws UserLoginNotFoundException;
}
