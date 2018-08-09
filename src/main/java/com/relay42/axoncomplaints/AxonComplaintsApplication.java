package com.relay42.axoncomplaints;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.relay42.axoncomplaints.bean.AxonBuilders;


@SpringBootApplication
public class AxonComplaintsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxonComplaintsApplication.class, args);
		System.out.println("Axon is Up");
	}
	
	/**
	 * Configure.
	 *
	 * @param admin the admin
	 */
	@Autowired
	public void configure(AmqpAdmin admin) {
		admin.declareQueue(AxonBuilders.queue());
		admin.declareExchange(AxonBuilders.exchange());
		admin.declareBinding(AxonBuilders.binding());
	}
}
