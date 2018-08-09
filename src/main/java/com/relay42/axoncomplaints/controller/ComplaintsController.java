package com.relay42.axoncomplaints.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relay42.axoncomplaints.domain.ComplaintsQueryObject;
import com.relay42.axoncomplaints.domain.FileComplaintCommand;
import com.relay42.axoncomplaints.repository.ComplaintsQueryObjectRepository;

/**
 * @author meetidnani
 *
 */
@RestController
public class ComplaintsController {
	
	private final ComplaintsQueryObjectRepository repository;
	private final CommandGateway commandGateway;
	
	public ComplaintsController(ComplaintsQueryObjectRepository repository, CommandGateway commandGateway) {
		super();
		this.repository = repository;
		this.commandGateway = commandGateway;
	}

	/**
	 * Get Mapping to get All Complaints
	 * @return
	 */
	@GetMapping(value = "/api/complaints/v1/getAllComplaints")
	public List<ComplaintsQueryObject> getAllComplaints(){
		return repository.findAll();
	}
	
	
	/**
	 * Get Mapping to get complaints by Id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/api/complaints/v1/getComplaintById/{id}")
	public Optional<ComplaintsQueryObject> getComplaintById(
			@PathVariable String id){
		return repository.findById(id);
	}
	
	/**
	 * Post mapping to file complaint/send to queue
	 * @param complaintData
	 * @return
	 */
	@PostMapping(value ="/api/complaints/v1/fileComplaint")
	public CompletableFuture<String> fileComplaint(
			@RequestBody Map<String, String> complaintData) {
		String id = UUID.randomUUID().toString();
		return commandGateway.send(new FileComplaintCommand(id, complaintData.get("company"), complaintData.get("description")));
	}

}
