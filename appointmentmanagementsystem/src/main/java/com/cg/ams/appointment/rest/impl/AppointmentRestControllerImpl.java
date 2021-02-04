package com.cg.ams.appointment.rest.impl;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ams.appointment.entity.Appointment;
import com.cg.ams.appointment.entity.AppointmentRequest;
import com.cg.ams.appointment.entity.AppointmentRequestUserId;
import com.cg.ams.appointment.entity.AppointmentUpdateRequest;
import com.cg.ams.appointment.exception.AppointmentException;
import com.cg.ams.appointment.rest.api.AppointmentRestController;
import com.cg.ams.appointment.service.api.AppointmentService;


/**
 * @author ARPAN ADHIKARY AADHIKAR
 * class for Appointment controller
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/api/1.0")
public class AppointmentRestControllerImpl implements AppointmentRestController {

	/**
	 * create logger object.
	 */
	private static final Logger LOGGER= LoggerFactory.getLogger(AppointmentRestControllerImpl.class);


	@Autowired
	private AppointmentService appointmentService;

	/***
	 * Request to fetch all Appointment details.
	 * 
	 * @requestBody AppointmentRequestUserId
	 * @return ResponseEntity
	 * @throws AppointmentException 
	 * @link localhost:8081/api/1.0/appointment/search/userid 
	 */
	
	
	@PostMapping(path = "/appointment/search/userid")
	@Override
	public ResponseEntity<List<Appointment>> getAppointmentByUserId(@RequestBody AppointmentRequestUserId request) throws AppointmentException {
		LOGGER.info("Rest service to find appointment");
		System.out.println(request);
		return new ResponseEntity<List<Appointment>>(appointmentService.appointmentFindByUserIdProcess(request.getRequestedUserId()), HttpStatus.OK);
	}
	
	/***
	 * Request to fetch all Appointment details.
	 * 
	 * @requestBody AppointmentRequest
	 * @return ResponseEntity
	 * @throws AppointmentException 
	 * @link localhost:8081/api/1.0/appointment/search/dateandtime
	 */
	
	
	@PostMapping(path = "/appointment/search/dateandtime")
	@Override
	public ResponseEntity<List<Appointment>> getAppointmentByDateAndTime(@Valid @RequestBody AppointmentRequest request)
			throws AppointmentException {
		LOGGER.info("Rest service to find appointment bydate and time");
		return new ResponseEntity<List<Appointment>>(appointmentService.appointmentFindByDateAndTimeProcess(request), HttpStatus.OK);
	}

	/***
	 * Request to book  Appointment.
	 * 
	 * @requestBody Appointment
	 * @return ResponseEntity
	 * @throws AppointmentException 
	 * @link localhost:8081/api/1.0/appointment/book
	 */
	
	@PostMapping(path = "/appointment/book")
	@Override
	public ResponseEntity<Boolean> bookAppointment(@Valid @RequestBody Appointment request) throws AppointmentException {
		LOGGER.info("Rest service to book appointment");
		return new ResponseEntity<Boolean>(appointmentService.appointmentBookProcess(request), HttpStatus.OK);
	}

	/***
	 * Request to update Appointment.
	 * 
	 * @requestBody AppointmentUpdateRequest
	 * @return ResponseEntity
	 * @throws AppointmentException 
	 * @link localhost:8081/api/1.0/appointment/update
	 */
	
	@PostMapping(path = "/appointment/update")
	@Override
	public ResponseEntity<Boolean> updateAppointment(@RequestBody AppointmentUpdateRequest request) throws AppointmentException {
		System.out.println("request");
		LOGGER.info("Rest service to update appointment");
		return  new ResponseEntity<Boolean>(appointmentService.appointmentUpdateProcess(request),HttpStatus.OK);
	}

	/***
	 * Request to delete  Appointment.
	 * 
	 * @requestBody AppointmentRequestUserId
	 * @return ResponseEntity
	 * @throws AppointmentException 
	 * @link localhost:8081/api/1.0/appointment/delete
	 */
	
	@PostMapping(path = "/appointment/delete")
	@Override
	public ResponseEntity<Boolean> deleteAppointmentById(@Valid @RequestBody AppointmentRequestUserId request) throws AppointmentException {
		LOGGER.info("Rest service to delete appointment");
		return new ResponseEntity<Boolean>(appointmentService.appointmentDeleteProcess(request), HttpStatus.OK);
	}
	

}
