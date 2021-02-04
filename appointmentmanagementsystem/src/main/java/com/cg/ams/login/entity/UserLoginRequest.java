package com.cg.ams.login.entity;

import javax.validation.constraints.NotBlank;

import com.cg.validation.message.ValidationMessage;

/**
 * @author Arpan Adhikary AADHIKAR
 * class for User Login request data member username and password
 *
 */

public class UserLoginRequest {
		
		@NotBlank(message = ValidationMessage.BLANKUSERNAME)
		private String requestedUserName;
		
		@NotBlank(message = ValidationMessage.BLANKPASSWORD)
		private String requestedPassword;

		public UserLoginRequest(String requestedUserName, String requestedPassword) {
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


