package com.cg.ams.registration.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cg.validation.message.ValidationMessage;

/**
 * @author Arpan Adhikary AADHIKAR
 * class for validator of User Login
 *
 */

public class UserRegistrationRequest {
		
		@NotBlank(message = ValidationMessage.BLANKUSERNAME)
		private String requestedUserName;
		
		@NotBlank(message = ValidationMessage.BLANKPASSWORD)
		private String requestedPassword;

		public UserRegistrationRequest(String requestedUserName, String requestedPassword) {
			super();
			this.requestedUserName = requestedUserName;
			this.requestedPassword = requestedPassword;
		}

		public String getRequestedUserName() {
			return requestedUserName;
		}

		public void setRequestedUserName(String requestedUserName) {
			this.requestedUserName = requestedUserName;
		}

		public String getRequestedPassword() {
			return requestedPassword;
		}

		public void setRequestedPassword(String requestedPassword) {
			this.requestedPassword = requestedPassword;
		}

		@Override
		public String toString() {
			return "UserLoginRequest [requestedUserName=" + requestedUserName + ", requestedPassword="
					+ requestedPassword + "]";
		}

		
				}


