/**
 * 
 */
package com.globant.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.globant.model.Employee;

/**
 * @author jose.luna
 *
 */
@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${globant.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${globant.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Employee company) {
		rabbitTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);
		System.out.println("Send exchange = " + exchange);
		System.out.println("Send routingkey = " + routingkey);
	}

}
