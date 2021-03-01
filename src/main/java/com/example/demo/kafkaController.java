package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.confluent.developer.User;

@RestController
@RequestMapping("/user")
public class kafkaController {
	private Producer producer;

	private final Logger logger = LogManager.getLogger(kafkaController.class);

	@Autowired
	public kafkaController(Producer producer) {
		// TODO Auto-generated constructor stub
		this.producer = producer;
	}
	
	@RequestMapping("/publish")
	private void publish(@RequestParam String name,
			@RequestParam Integer age) {
		User user = new User(name, age);
		logger.info("Publishing: "+user);
		producer.send(user);
	}

}
