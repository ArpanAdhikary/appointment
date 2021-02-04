package com.cg.ams.appointment.entity;

import javax.validation.constraints.NotNull;

import com.cg.validation.message.ValidationMessage;


/**
 * @author Arpan Adhikary AADHIKAR
 * class for Appointment Request generation having fields user id and appointment id
 *
 */

public class AppointmentRequestUserId {

	@NotNull(message=ValidationMessage.NULLUSERID)
	private Integer requestedUserId;

	private Integer requestedAppointedId;
	
	public Integer getRequestedAppointedId() {
		return requestedAppointedId;
	}

	public void setRequestedAppointedId(Integer requestedAppointedId) {
		this.requestedAppointedId = requestedAppointedId;
	}

	public Integer getRequestedUserId() {
		return requestedUserId;
	}

	public void setRequestedUserId(Integer requestedUserId) {
		this.requestedUserId = requestedUserId;
	}

	
	public AppointmentRequestUserId(Integer requestedUserId) {
		super();
		this.requestedUserId = requestedUserId;
	}

	public AppointmentRequestUserId(Integer requestedUserId, Integer requestedAppointedId) {
		super();
		this.requestedUserId = requestedUserId;
		this.requestedAppointedId = requestedAppointedId;
	}

	@Override
	public String toString() {
		return "AppointmentRequestUserId [requestedUserId=" + requestedUserId + ", requestedAppointedId="
				+ requestedAppointedId + "]";
	}		
}
