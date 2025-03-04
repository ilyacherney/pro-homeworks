package ru.otus.homework17;

import java.io.Serializable;
import java.util.UUID;

public class Message implements Serializable {
    UUID id;
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Message() {}

    public Message(UUID id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
