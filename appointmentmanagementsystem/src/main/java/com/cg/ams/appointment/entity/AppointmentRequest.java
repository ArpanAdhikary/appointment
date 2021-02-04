package com.cg.ams.appointment.entity;


/**
 * @author Arpan Adhikary AADHIKAR
 * class for Appointment Request generation having fields date and time
 *
 */

public class AppointmentRequest {
		
			
		
		private String requestedDate;
		
		private String requestedTime;

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

		public AppointmentRequest(String requestedDate, String requestedTime) {
			super();
			this.requestedDate = requestedDate;
			this.requestedTime = requestedTime;
		}

		@Override
		public String toString() {
			return "AppointmentRequest [requestedDate=" + requestedDate + ", requestedTime=" + requestedTime + "]";
		}
		
}
		
		