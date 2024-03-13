package com.shadril238.edakafkademo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class EdaKafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdaKafkaDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {
			for (int i = 0; i < 10000; i++) {
				kafkaTemplate.send("shadril238", "hello, Kafka - " + i);
			}
		};
	}
}
