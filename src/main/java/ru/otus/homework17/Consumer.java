package ru.otus.homework17;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "hw17", containerFactory = "topicListenerFactory")
    public void consume(Message message) {
        System.out.println("Consumed: " + message);
    }
}
