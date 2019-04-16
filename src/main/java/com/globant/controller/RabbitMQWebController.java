/**
 * 
 */
package com.globant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.model.Employee;
import com.globant.service.RabbitMQSender;

/**
 * @author jose.luna
 *
 */
@RestController
@RequestMapping(value = "/globant-rabbitmq/")
public class RabbitMQWebController {
	
	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {
	
	Employee emp=new Employee();
	emp.setEmpId(empId);
	emp.setEmpName(empName);
		rabbitMQSender.send(emp);

		return "Message sent to the Globant RabbitMQ Successfully";
	}
}
