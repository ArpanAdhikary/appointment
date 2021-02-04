package com.cg.ams.login.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.ams.login.entity.UserLogin;
import com.cg.ams.login.entity.UserLoginRequest;
import com.cg.ams.login.exception.UserLoginNotFoundException;
import com.cg.ams.login.repo.UserLoginRepository;
import com.cg.ams.login.service.api.UserLoginService;



@Service
public class UserLoginServiceImpl implements UserLoginService {

	
	@Autowired
	private UserLoginRepository userRepo;

	
	/**
	 * create logger object.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginServiceImpl.class);

	
	/***
	 * Service method to login useradmin db.
	 * 
	 * @param UserLoginRequest
	 * @return UserLogin
	 * @throws UserLoginNotFoundException 
	 */
	
	@Override
	public UserLogin findAllUserLoginBySearchRequest(UserLoginRequest request) throws UserLoginNotFoundException {
			
			UserLogin user = userRepo.findAllByUsernameAndPassword(
					request.getRequestedUserName(), request.getRequestedPassword());
				
		
			return user;
		
	}
	
}
