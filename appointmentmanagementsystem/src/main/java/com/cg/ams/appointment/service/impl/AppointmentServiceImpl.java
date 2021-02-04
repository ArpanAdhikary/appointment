package com.cg.ams.appointment.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.ams.appointment.entity.Appointment;
import com.cg.ams.appointment.entity.AppointmentRequest;
import com.cg.ams.appointment.entity.AppointmentRequestUserId;
import com.cg.ams.appointment.entity.AppointmentUpdateRequest;
import com.cg.ams.appointment.exception.AppointmentException;
import com.cg.ams.appointment.repo.AppointmentRepository;
import com.cg.ams.appointment.service.api.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	
	@Autowired
	private AppointmentRepository appointmentRepo;

		/**
	 * create logger object.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentServiceImpl.class);
	
	/** function to find the appointments on the basis of user id provided 
	 *@param function take requestedUserId as input integer type
	 *@return return list of appointments
	 *@exception AppointmentException
	 **/
	
	@Override
	public List<Appointment> appointmentFindByUserIdProcess(Integer requestedUserId) throws AppointmentException {
			
		
		List<Appointment> listAppointmentById  = appointmentRepo.findAllByUserId(requestedUserId);
		List<Appointment> listOfRecord=new ArrayList<>();
		/* if the list is empty it will throw AppointmentException */
		
		if(listAppointmentById.isEmpty()) {
			LOGGER.info("No Appointment found");
			return null;
		}	
		for(Appointment data: listAppointmentById) {
			if(data.getFlag()==0)
				listOfRecord.add(data);
		}
		return listOfRecord;
	}

	/** function to find the appointments on the basis of date and time provided 
	 * function take request as input AppointmentRequest type
	 * return list of appointments
	 *
	 **/
	
	@Override
	public List<Appointment> appointmentFindByDateAndTimeProcess(AppointmentRequest request) throws AppointmentException {
		
		List<Appointment> listAppointmentById = appointmentRepo.findAllByDateAndTime(request.getRequestedDate(),request.getRequestedTime());
		List<Appointment> listOfRecord=new ArrayList<>();
		
		/* if the list is empty it will throw AppointmentException */
		
		if(listAppointmentById.isEmpty()) {
			LOGGER.info("No Appointment found");
			return null;
		}	
		for(Appointment data: listAppointmentById) {
			if(data.getFlag()==0)
				listOfRecord.add(data);
		}
		return listOfRecord;
	}

	/** function to update the appointment on the basis of appointment id provided 
	 * function take request as input AppointmentUpdateRequest type
	 * return true if update is successful else false
	 *
	 **/
	
	@Override
	public boolean appointmentUpdateProcess(AppointmentUpdateRequest request) throws AppointmentException {
		
		int counter=appointmentRepo.updateAppointment(request.getRequestedAppointmentId(),request.getRequestedUserId(),
													  request.getRequestedcreatorId(),
													  request.getRequestedDate(),
													  request.getRequestedTime(),request.getRequestedDescription());
		
		/** counter value will store the number of record present
		 *  if the counter is >0 then update is successful else not 
		 **/
		
		if(counter>0)
			return true;
		else
			return false;
	}

	/** function to delete the appointment on the basis of appointment id or user id or both provided 
	 * function take userId,appointmentId as  input integer,integer type
	 * return true if delete is successful else false
	 *
	 **/
	
	@Override
	public boolean appointmentDeleteProcess(AppointmentRequestUserId request) throws AppointmentException {
		int counter=0;
		int appointmentId;
		/** Appointment id if null or 0 then all the record of the user will get deleted 
		 * else only a certain appointment of the user will get deleted
		 */
		
			if(request.getRequestedAppointedId()==null) 
			{	appointmentId= -1;
				LOGGER.info("Assign appointment id with -1 if appointedId is null");
			}
			else
				appointmentId=request.getRequestedAppointedId();
			
			 counter=appointmentRepo.deleteByUserId(request.getRequestedUserId(),appointmentId);
		if(counter > 0)
			return true;
		else
			return false;
		}

	/** function to book/insert the appointment provided
	 * function take request as input Appointment type
	 * return true if booking is successful else false
	 *
	 **/
	
	@Override
	public boolean appointmentBookProcess(Appointment request) throws AppointmentException {
		int counter=appointmentRepo.insertAppointment(request.getCreatorId(), request.getDate(), request.getTime(), 
				    request.getDescription(), request.getUserId());
		
		/** If any appointment is present with the provided date & time for the user  
		 * then counter value will be > 0 and booking will not be taken
		 * else the booking will be taken 
		 */
		
		if(counter==0) {
			LOGGER.info("Appointment Booking is successful");
			return true;
		}
		else
		{
			LOGGER.info("The record is not saved in the database");
			return false;
		}
	}
}
