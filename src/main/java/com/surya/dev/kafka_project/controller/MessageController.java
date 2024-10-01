package com.surya.dev.kafka_project.controller;

import com.surya.dev.kafka_project.Kafka.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    // http:localhost:8080/api/v1/kafka/publish?message= hello world
    @GetMapping("/publish")
    ResponseEntity<String > publish(@RequestParam("message") String message){
kafkaProducer.sendMessage(message);
return new ResponseEntity<>("Message sent to topic", HttpStatus.OK );
    }
}
