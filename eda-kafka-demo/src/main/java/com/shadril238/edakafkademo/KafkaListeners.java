package com.shadril238.edakafkademo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaListeners {
    @KafkaListener(
            topics = "shadril238",
            groupId = "groupId"
    )
    void listener(String data){
        System.out.println("Listener received: "+ data);
    }
}
