package ru.otus.homework16;


import java.io.Serializable;
import java.util.List;

public class NewStruct implements Serializable {
    private List<NewStructMessage> messages;

    public List<NewStructMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<NewStructMessage> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "NewStruct{" +
                "messages=" + messages +
                '}';
    }
}
