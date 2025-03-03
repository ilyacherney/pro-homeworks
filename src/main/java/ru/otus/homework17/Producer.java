package ru.otus.homework17;

import org.springframework.jms.core.JmsTemplate;

public class Producer {
    private final JmsTemplate jmsTemplate;

    public Producer(JmsTemplate jmsTemplate) {this.jmsTemplate = jmsTemplate;}

    public void produce(String message) {
        jmsTemplate.convertAndSend("hw17", message);
    }
}
