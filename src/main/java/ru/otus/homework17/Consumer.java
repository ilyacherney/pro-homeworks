package ru.otus.homework17;

import org.springframework.jms.annotation.JmsListener;

public class Consumer {

    @JmsListener(destination = "hw17", containerFactory = "topicListenerFactory")
    public void consume(String message) {
        System.out.println("Consumed: " + message);
    }
}
