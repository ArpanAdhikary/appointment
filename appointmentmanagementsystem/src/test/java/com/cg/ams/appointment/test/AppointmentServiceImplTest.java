package com.cg.ams.appointment.test;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ams.AppointmentmanagementsystemApplication;
import com.cg.ams.appointment.entity.Appointment;
import com.cg.ams.appointment.entity.AppointmentRequest;
import com.cg.ams.appointment.entity.AppointmentRequestUserId;
import com.cg.ams.appointment.entity.AppointmentUpdateRequest;
import com.cg.ams.appointment.exception.AppointmentException;
import com.cg.ams.appointment.repo.AppointmentRepository;
import com.cg.ams.appointment.service.api.AppointmentService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppointmentmanagementsystemApplication.class)
class AppointmentServiceImplTest {

	/**
	 * @author aadhikar Arpan Adhikary
	 */
	
	
	
	@Autowired
	private AppointmentService service;

	@MockBean
	private AppointmentRepository appointmentRepo;

	private  List<Appointment> listOfAppointments = new ArrayList<>();
	private  List<Appointment> listOfAppointment = new ArrayList<>();
	Appointment appointment= new Appointment(37,7,7,"22-01-2022","10:47 pm","");
	Appointment appointments= new Appointment(37,7,7,"22-01-2022","10:47 pm","",0);
	
	
	
	@Test
	public void findAppointmentByIdSuccess()
			throws AppointmentException {
		
		AppointmentRequestUserId request = new AppointmentRequestUserId(7);
		listOfAppointment.add(appointments);
		
		
		System.out.println(Mockito.when(appointmentRepo.findAllByUserId(request.getRequestedUserId())).thenReturn(listOfAppointment));
		
		assertEquals(service.appointmentFindByUserIdProcess(request.getRequestedUserId()), listOfAppointment);
	}

	@Test
	public void findAppointmentByDateTime() throws AppointmentException {
		
		AppointmentRequest request;
		
		request = new AppointmentRequest("22-01-2022","10:47 pm");
		
		
		
		listOfAppointment.add(appointments);
		
		Mockito.when(appointmentRepo.findAllByDateAndTime(request.getRequestedDate(),request.getRequestedTime())).thenReturn(listOfAppointment);
		
		assertEquals(service.appointmentFindByDateAndTimeProcess(request), listOfAppointment);
	}
	
	@Test
	public void bookAppointment() throws AppointmentException {
		
		Appointment request;
		
		
		request = new Appointment(40,7,7,"22-02-2022","10:47 pm","");
		
		
		Mockito.when(appointmentRepo.insertAppointment(request.getCreatorId(), request.getDate(), request.getTime(), request.getDescription(), request.getUserId())).thenReturn(0);
		
		assertEquals(service.appointmentBookProcess(request),true);
	}
	
	@Test
	public void updateAppointment() throws AppointmentException {
		
		AppointmentUpdateRequest request;
		
		
		request = new AppointmentUpdateRequest(40,7,7,"22-02-2022","11:47 pm","");
		
		
		Mockito.when(appointmentRepo.updateAppointment(request.getRequestedAppointmentId(),request.getRequestedUserId(),request.getRequestedcreatorId(), request.getRequestedDate(), request.getRequestedTime(), request.getRequestedDescription())).thenReturn(1);
		
		Assert.assertEquals(service.appointmentUpdateProcess(request),true);
	}
	
	@Test
	public void deleteAppointment() throws AppointmentException {
		
		AppointmentRequestUserId request;
		
		
		request = new AppointmentRequestUserId(7,40);
		
		
		Mockito.when(appointmentRepo.deleteByUserId(request.getRequestedUserId(),request.getRequestedAppointedId())).thenReturn(1);
		
		Assert.assertEquals(service.appointmentDeleteProcess(request),true);
	}

	@Test
	public void bookAppointmentFailure() throws AppointmentException {
		
		Appointment request;
		
		
		request = new Appointment(40,1,7,"22-02-2022","10:47 pm","");
		
		
		Mockito.when(appointmentRepo.insertAppointment(request.getCreatorId(), request.getDate(), request.getTime(), request.getDescription(), request.getUserId())).thenReturn(1);
		
		assertEquals(service.appointmentBookProcess(request),false);
	}
	
	@Test
	public void updateAppointmentFailure() throws AppointmentException {
		
		AppointmentUpdateRequest request;
		
		
		request = new AppointmentUpdateRequest(40,7,7,"22-03-2022","11:47 pm","");
		
		
		Mockito.when(appointmentRepo.updateAppointment(request.getRequestedAppointmentId(),request.getRequestedUserId(),request.getRequestedcreatorId(), request.getRequestedDate(), request.getRequestedTime(), request.getRequestedDescription())).thenReturn(0);
		
		Assert.assertEquals(service.appointmentUpdateProcess(request),false);
	}

	@Test
	public void deleteAppointmentFailure() throws AppointmentException {
		
		AppointmentRequestUserId request;
		
		
		request = new AppointmentRequestUserId(8,40);
		
		
		Mockito.when(appointmentRepo.deleteByUserId(request.getRequestedUserId(),request.getRequestedAppointedId())).thenReturn(0);
		
		Assert.assertEquals(service.appointmentDeleteProcess(request),false);
	}
	
	@Test
	public void findAppointmentByIdFailure()
			throws AppointmentException {
		
		AppointmentRequestUserId request = new AppointmentRequestUserId(8);
		listOfAppointment.add(appointments);
		
		
		Mockito.when(appointmentRepo.findAllByUserId(request.getRequestedUserId())).thenReturn(listOfAppointment);
		
		Assert.assertEquals(service.appointmentFindByUserIdProcess(request.getRequestedUserId()), listOfAppointment);
	}
	
	@Test
	public void findAppointmentByDateTimeFailure() throws AppointmentException {
		
		AppointmentRequest request;
		
		request = new AppointmentRequest("02-02-2022","10:47 pm");
		
		
		
		listOfAppointment.add(appointments);
		
		Mockito.when(appointmentRepo.findAllByDateAndTime(request.getRequestedDate(),request.getRequestedTime())).thenReturn(listOfAppointment);
		
		assertEquals(service.appointmentFindByDateAndTimeProcess(request), listOfAppointment);
	}
	
}
