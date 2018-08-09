package com.relay42.axoncomplaints.domain;

public class FileComplaintCommand {
	
	private final String id;
	private final String company;
	private final String description;
	
	public FileComplaintCommand(String id, String company, String description) {
		super();
		this.id = id;
		this.company = company;
		this.description = description;
	}

	public String getId() {
		return id;
	}
	
	public String getCompany() {
		return company;
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "FileComplaintCommand [id=" + id + ", company=" + company + ", description=" + description + "]";
	}
	
	

}
