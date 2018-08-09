package com.relay42.axoncomplaints.bean;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author meetidnani
 *
 */
public class AxonBuilders {
	
	/**
	 * @return
	 */
	@Bean
	public static Queue queue() {
		return QueueBuilder.durable("ComplaintEvents").build();
	}
	
	/**
	 * @return
	 */
	@Bean
	public static Exchange exchange() {
		return ExchangeBuilder.fanoutExchange("ComplaintEvents").build();
	}
	
	/**
	 * @return
	 */
	@Bean
	public static Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with("*").noargs();
	}

}
