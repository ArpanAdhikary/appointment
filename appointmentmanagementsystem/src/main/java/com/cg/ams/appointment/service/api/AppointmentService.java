package com.cg.ams.appointment.service.api;

import java.util.List;

import com.cg.ams.appointment.entity.Appointment;
import com.cg.ams.appointment.entity.AppointmentRequest;
import com.cg.ams.appointment.entity.AppointmentRequestUserId;
import com.cg.ams.appointment.entity.AppointmentUpdateRequest;
import com.cg.ams.appointment.exception.AppointmentException;

public interface AppointmentService {

	
	/***
	 * Interface for Appointment Service  
	 */	
	public List<Appointment> appointmentFindByUserIdProcess(Integer request) throws AppointmentException;
	
	public List<Appointment> appointmentFindByDateAndTimeProcess(AppointmentRequest request) throws AppointmentException;
	
	public boolean appointmentUpdateProcess(AppointmentUpdateRequest request) throws AppointmentException;
	
	public boolean appointmentDeleteProcess(AppointmentRequestUserId request) throws AppointmentException;
	
	public boolean appointmentBookProcess(Appointment request) throws AppointmentException;
	
}
