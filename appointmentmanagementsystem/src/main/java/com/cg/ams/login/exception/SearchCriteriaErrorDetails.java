package com.cg.ams.login.exception;

import java.util.Date;
import java.util.List;

/**
 * @author Arpan Adhikary AADHIKAR
 * Class to check if search criteria doesnot match
 *
 */

public class SearchCriteriaErrorDetails {

	private Date timestamp;
	private String details;
	private List<String> messages;

	public SearchCriteriaErrorDetails() {
		super();
	}

	public SearchCriteriaErrorDetails(Date timestamp, String details, List<String> messages) {
		super();
		this.timestamp = timestamp;
		this.details = details;
		this.messages = messages;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "SearchCriteriaErrorDetails [timestamp=" + timestamp + ", details=" + details + ", messages=" + messages
				+ "]";
	}

}
