package ru.otus.homework16.sms;

import java.util.List;

public class ChatData {
    private List<ChatSession> chat_sessions;

    // Геттеры и сеттеры
    public List<ChatSession> getChat_sessions() {
        return chat_sessions;
    }

    public void setChat_sessions(List<ChatSession> chat_sessions) {
        this.chat_sessions = chat_sessions;
    }

    @Override
    public String toString() {
        return "ChatData{" +
                "chat_sessions=" + chat_sessions +
                '}';
    }
}
