package com.relay42.axoncomplaints.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComplaintsQueryObject {
	
	@Id
	private String complaintId;

	private String company;
	
	private String description;

	public ComplaintsQueryObject() {
		
	}
	
	public ComplaintsQueryObject(String complaintId, String company, String description) {
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

	@Override
	public String toString() {
		return "ComplaintsQueryObject [complaintId=" + complaintId + ", company=" + company + ", description="
				+ description + "]";
	}
	
	

}
