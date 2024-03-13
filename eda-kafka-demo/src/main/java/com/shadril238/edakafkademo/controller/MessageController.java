package com.shadril238.edakafkademo.controller;

import com.shadril238.edakafkademo.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MessageController(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publishMessage(@RequestBody MessageRequest request){
        kafkaTemplate.send("shadril238", request.message());
    }
}
