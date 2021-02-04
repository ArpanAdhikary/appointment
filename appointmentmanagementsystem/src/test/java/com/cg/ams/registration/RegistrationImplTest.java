package com.cg.ams.registration;

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
import com.cg.ams.registration.entity.UserRegistration;
import com.cg.ams.registration.exception.UserRegistrationFailedException;
import com.cg.ams.registration.repo.UserRegistrationRepository;
import com.cg.ams.registration.service.api.UserRegistrationService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppointmentmanagementsystemApplication.class)
public class RegistrationImplTest {

	@Autowired
	private UserRegistrationService service;
	
	@MockBean
	private UserRegistrationRepository registrationRepo;
	

	UserRegistration userRegistration=new UserRegistration(7,"Arpan13@","Arpanq","8296758379",
			"arpanadhikary123@gmail.com","User","Qwerty123@");

	UserRegistration userRegistrations=new UserRegistration(8,"Arpan13@","Arpanq","8296758379",
			"arpanadhikary123@gmail.com","User","Qwerty123@");

	
	@Test
	public void registerTest() throws UserRegistrationFailedException{
		
		Mockito.when(registrationRepo.insertUsers(userRegistration.getEmailId(),userRegistration.getMobileNo(),userRegistration.getName(),userRegistration.getUsername(),userRegistration.getRole(),userRegistration.getPassword())).thenReturn(0);
		
		Assert.assertEquals(service.userRegistrationProcess(userRegistration),true);
		
	}
	@Test
	public void unRegisterTest() throws UserRegistrationFailedException{
		
		Mockito.when(registrationRepo.deleteUsers(userRegistration.getId())).thenReturn(1);
		
		Assert.assertEquals(service.userRegistrationProcess(userRegistration),true);
		
	}
	@Test
	public void failedUnRegisterTest() throws UserRegistrationFailedException{
		
		Mockito.when(registrationRepo.deleteUsers(userRegistration.getId())).thenReturn(0);
		
		Assert.assertEquals(service.userRegistrationProcess(userRegistrations),false);
		
	}
}
