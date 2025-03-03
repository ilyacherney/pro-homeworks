package ru.otus.homework17;

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
    public void jms(@RequestBody String message) {}
}
