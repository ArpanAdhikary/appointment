package com.cg.ams.login.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ams.AppointmentmanagementsystemApplication;
import com.cg.ams.login.entity.UserLogin;
import com.cg.ams.login.entity.UserLoginRequest;
import com.cg.ams.login.exception.UserLoginNotFoundException;
import com.cg.ams.login.repo.UserLoginRepository;
import com.cg.ams.login.service.api.UserLoginService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppointmentmanagementsystemApplication.class)
public class LoginServiceImplTest {

	@Autowired
	private UserLoginService service;
	
	@MockBean
	private UserLoginRepository loginRepo;
	
	UserLogin login=new UserLogin(7,"Arpan13@","Arpanq","8296758379",
									"arpanadhikary123@gmail.com","User","Qwerty123@");
	
	@Test
	public void loginTest() throws UserLoginNotFoundException{
		
		UserLoginRequest request;
		request = new UserLoginRequest("Arpan13@","Qwerty123@");
		Mockito.when(loginRepo.findAllByUsernameAndPassword(request.getRequestedUserName(),
						request.getRequestedPassword())).thenReturn(login);
		
		Assert.assertEquals(service.findAllUserLoginBySearchRequest(request),login);
		
	}
	
	@Test
	public void failedLoginTest() throws UserLoginNotFoundException{
		
		UserLoginRequest request;
		request = new UserLoginRequest("Arpan13@","Qwerty1@");
		Mockito.when(loginRepo.findAllByUsernameAndPassword(request.getRequestedUserName(),
						request.getRequestedPassword())).thenReturn(null);
		
		Assert.assertEquals(service.findAllUserLoginBySearchRequest(request),null);
		
	}
}
