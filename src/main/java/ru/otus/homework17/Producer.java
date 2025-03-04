package ru.otus.homework17;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private final JmsTemplate jmsTemplate;

    public Producer(JmsTemplate jmsTemplate) {this.jmsTemplate = jmsTemplate;}

    public void produce(Message message) {
        jmsTemplate.convertAndSend("hw17", message);
    }
}
