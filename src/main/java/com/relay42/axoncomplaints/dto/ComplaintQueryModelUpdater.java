package com.relay42.axoncomplaints.dto;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.relay42.axoncomplaints.domain.ComplaintFiledEvent;
import com.relay42.axoncomplaints.domain.ComplaintsQueryObject;
import com.relay42.axoncomplaints.repository.ComplaintsQueryObjectRepository;

@Component
public class ComplaintQueryModelUpdater {
	
	private final ComplaintsQueryObjectRepository repository;
	
	
	public ComplaintQueryModelUpdater(ComplaintsQueryObjectRepository repository) {
		this.repository = repository;
	}

	/**
	 * Event handler to update the repository with new complaint
	 * @param event
	 */
	@EventHandler
	public void updateRepository(ComplaintFiledEvent event) {
		repository.save(new ComplaintsQueryObject(event.getComplaintId(), event.getCompany(), event.getDescription()));
	}

}
