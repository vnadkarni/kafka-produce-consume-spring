package com.example.demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringKafkaProducerConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaProducerConsumerApplication.class, args);
	}

	@Value("${topic.partitions-num}")
	private Integer partitions;
	
	@Value("${topic.replication-factor}")
	private Short replicationFactor;

	@Value("${topic.name}")
	private String topicName;
	
	@Bean
	NewTopic newTopic() {
		return new NewTopic(topicName, partitions, replicationFactor);
	}

}
