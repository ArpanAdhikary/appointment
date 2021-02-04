package com.cg.ams.appointment.rest.api;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.ams.appointment.entity.Appointment;
import com.cg.ams.appointment.entity.AppointmentRequest;
import com.cg.ams.appointment.entity.AppointmentRequestUserId;
import com.cg.ams.appointment.entity.AppointmentUpdateRequest;
import com.cg.ams.appointment.exception.AppointmentException;


/**
 * @author Arpan Adhikary
 * Interface for Appointment controller
 *
 */
public interface AppointmentRestController {

	/***
	 * Request to fetch all Appointment details.
	 * 
	 * @requestBody AppointmentRequestUserId
	 * @return ResponseEntity
	 * @throws AppointmentException 
	 * 
	 */
	public ResponseEntity<List<Appointment>> getAppointmentByUserId(
			@RequestBody AppointmentRequestUserId request) throws AppointmentException;
	
	/***
	 * Request to fetch all Appointment details.
	 * 
	 * @requestBody AppointmentRequest
	 * @return ResponseEntity
	 * @throws AppointmentException 
	 */
	
	public ResponseEntity<List<Appointment>> getAppointmentByDateAndTime(
			@RequestBody AppointmentRequest request) throws AppointmentException;
	
	/***
	 * Request to book  Appointment.
	 * 
	 * @requestBody Appointment
	 * @return ResponseEntity
	 * @throws AppointmentException 
	 */
	
	public ResponseEntity<Boolean> bookAppointment(
			@RequestBody Appointment request) throws AppointmentException;
	
	/***
	 * Request to update Appointment.
	 * 
	 * @requestBody AppointmentUpdateRequest
	 * @return ResponseEntity
	 * @throws AppointmentException 
	 */
	
	public ResponseEntity<Boolean> updateAppointment(
			@RequestBody AppointmentUpdateRequest request) throws AppointmentException;
	
	/***
	 * Request to delete  Appointment.
	 * 
	 * @requestBody AppointmentRequestUserId
	 * @return ResponseEntity
	 * @throws AppointmentException 
	 */
	
	public ResponseEntity<Boolean> deleteAppointmentById(
			@RequestBody AppointmentRequestUserId request) throws AppointmentException;
	
}
