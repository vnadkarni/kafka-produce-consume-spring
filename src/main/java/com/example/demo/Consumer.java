package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import io.confluent.developer.User;

@Component
public class Consumer {
	
	@Value("${topic.name}")
	private String topicName;
	
	private final Logger logger = LogManager.getLogger(Consumer.class);

	public Consumer() {
		// TODO Auto-generated constructor stub
	}
    @KafkaListener(topics = "users", groupId = "my-microservice")
    public void consume(ConsumerRecord<String, User> record) {
        logger.info(String.format("Consumed message -> %s", record.value()));
    }
}
