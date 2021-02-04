package com.cg.ams.appointment.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cg.validation.message.ValidationMessage;


/**
 * @author Arpan Adhikary AADHIKAR
 * class for Appointment Request generation for updating
 *
 */

public class AppointmentUpdateRequest {
	
	@NotNull(message=ValidationMessage.NULLAPPOINTMENTID)
	private int requestedAppointmentId;
	
	@NotNull(message = ValidationMessage.NULLUSERID)
	private int requestedUserId;
	
	
	@NotBlank(message = ValidationMessage.NULLAPPOINTMENTID)
	private int requestedcreatorId;
	
	@NotBlank(message = ValidationMessage.BLANKDATE)
	private String requestedDate;
	
	@NotBlank(message = ValidationMessage.BLANKTIME)
	private String requestedTime;
	
	
	private String requestedDescription;


	public int getRequestedAppointmentId() {
		return requestedAppointmentId;
	}


	public void setRequestedAppointmentId(int requestedAppointmentId) {
		this.requestedAppointmentId = requestedAppointmentId;
	}


	public int getRequestedUserId() {
		return requestedUserId;
	}


	public void setRequestedUserId(int requestedUserId) {
		this.requestedUserId = requestedUserId;
	}


	public int getRequestedcreatorId() {
		return requestedcreatorId;
	}


	public void setRequestedcreatorId(int requestedcreatorId) {
		this.requestedcreatorId = requestedcreatorId;
	}


	public String getRequestedDate() {
		return requestedDate;
	}


	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}


	public String getRequestedTime() {
		return requestedTime;
	}


	public void setRequestedTime(String requestedTime) {
		this.requestedTime = requestedTime;
	}


	public String getRequestedDescription() {
		return requestedDescription;
	}


	public void setRequestedDescription(String requestedDescription) {
		this.requestedDescription = requestedDescription;
	}


	public AppointmentUpdateRequest(
			 int requestedAppointmentId,
			 int requestedUserId,
			 int requestedcreatorId,
			 String requestedDate,
			 String requestedTime,
			String requestedDescription) {
		super();
		this.requestedAppointmentId = requestedAppointmentId;
		this.requestedUserId = requestedUserId;
		this.requestedcreatorId = requestedcreatorId;
		this.requestedDate = requestedDate;
		this.requestedTime = requestedTime;
		this.requestedDescription = requestedDescription;
	}


	@Override
	public String toString() {
		return "AppointmentUpdateRequest [requestedAppointmentId=" + requestedAppointmentId + ", requestedUserId="
				+ requestedUserId + ", requestedcreatorId=" + requestedcreatorId + ", requestedDate=" + requestedDate
				+ ", requestedTime=" + requestedTime + ", requestedDescription=" + requestedDescription + "]";
	}

	
}
