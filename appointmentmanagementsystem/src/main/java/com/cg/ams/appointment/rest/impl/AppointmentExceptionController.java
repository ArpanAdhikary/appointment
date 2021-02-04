package com.cg.ams.appointment.rest.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.ams.appointment.exception.AppointmentException;
import com.cg.ams.login.exception.SearchCriteriaErrorDetails;


/**
 * @author Arpan Adhikary AADHIKAR
 * class for exception controller
 *
 */
@ControllerAdvice
public class AppointmentExceptionController {

	/***
	 * advice exception handler for OnlineChefsNotFoundException
	 * 
	 * @param OnlineChefsNotFoundException exception
	 * @return ResponseEntity<String>
	 */
	@ExceptionHandler(value = AppointmentException.class)
	public ResponseEntity<String> exception(AppointmentException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
	}

	/***
	 * advice exception handler for AppointmentException
	 * 
	 * @param MethodArgumentNotValidException ex
	 * @return ResponseEntity<SearchCriteriaErrorDetails>
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<SearchCriteriaErrorDetails> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

		List<String> errormessages = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());

		SearchCriteriaErrorDetails errorDetails = new SearchCriteriaErrorDetails(new Date(), "search paramters invalid",
				errormessages);
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
