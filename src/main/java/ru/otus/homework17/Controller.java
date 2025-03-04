package ru.otus.homework17;

import jakarta.jms.TextMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final Producer producer;
    private final JmsTemplate jmsTemplate;

    public Controller(Producer producer, JmsTemplate jmsTemplate) {
        this.producer = producer;
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/jms")
    public ResponseEntity<?> jms(@RequestBody Message message) {
        try {
            producer.produce(message);
            return new ResponseEntity<>("Message sent", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Message not sent", HttpStatus.BAD_REQUEST);
        }
    }
}
