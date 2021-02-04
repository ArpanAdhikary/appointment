package com.cg.ams.registration.entity;

import javax.validation.constraints.NotNull;

import com.cg.validation.message.ValidationMessage;

/**
 * @author Arpan Adhikary AADHIKAR
 * class for validator of User Login
 *
 */

public class UserUnRegisterRequest {
		
		@NotNull(message = ValidationMessage.NULLUSERID)
		private int requestedUserId;

		public UserUnRegisterRequest(int requestedUserId) {
			super();
			this.requestedUserId = requestedUserId;
		}

		public UserUnRegisterRequest() {
			super();
		}

		public int getRequestedUserId() {
			return requestedUserId;
		}

		public void setRequestedUserId(int requestedUserId) {
			this.requestedUserId = requestedUserId;
		}

		@Override
		public String toString() {
			return "UserUnRegisterRequest [requestedUserId=" + requestedUserId + "]";
		}

}


