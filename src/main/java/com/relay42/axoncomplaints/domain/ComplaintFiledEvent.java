package com.relay42.axoncomplaints.domain;

/**
 * @author meetidnani
 *
 */
public class ComplaintFiledEvent {

	private final String complaintId;
	
	private final String company;
	
	private final String description;

	
	public ComplaintFiledEvent(String complaintId, String company, String description) {
		super();
		this.complaintId = complaintId;
		this.company = company;
		this.description = description;
	}


	public String getComplaintId() {
		return complaintId;
	}


	public String getCompany() {
		return company;
	}


	public String getDescription() {
		return description;
	}
	
	
	
	
	
}
