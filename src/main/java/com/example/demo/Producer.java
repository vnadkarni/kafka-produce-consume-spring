package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import io.confluent.developer.User;

@Component
public class Producer {
	
	@Value("${topic.name}")
	private String topicName;
	
	private final Logger logger = LogManager.getLogger(Producer.class);
	
	private final KafkaTemplate<String, User> kafkaTemplate;

	@Autowired
	public Producer(KafkaTemplate<String, User> kafkaTemplate) {
		// TODO Auto-generated constructor stub
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(User user) {
		// TODO Auto-generated method stub
		logger.info("Sending: "+user);
		this.kafkaTemplate.send(topicName, user.getName(), user);
		
	}

}
