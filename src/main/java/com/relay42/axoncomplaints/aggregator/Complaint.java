package com.relay42.axoncomplaints.aggregator;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.relay42.axoncomplaints.domain.ComplaintFiledEvent;
import com.relay42.axoncomplaints.domain.FileComplaintCommand;


/**
 * @author meetidnani
 *
 */
@Aggregate
public class Complaint{

		/** The identifier. */
		@AggregateIdentifier
		private String identifier;
		

		/**
		 * Instantiates a new complaint.
		 *
		 * @param command the command
		 */
		@CommandHandler
		public Complaint(FileComplaintCommand command) {
			AggregateLifecycle.apply(new ComplaintFiledEvent(command.getId(), command.getCompany(), command.getDescription()));
		}
		
		/**
		 * On.
		 *
		 * @param event the event
		 */
		@EventSourcingHandler
		public void on(ComplaintFiledEvent event) {
			this.identifier = event.getComplaintId();
		}
		
}
