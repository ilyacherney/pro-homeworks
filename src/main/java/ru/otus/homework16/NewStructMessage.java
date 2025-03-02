package ru.otus.homework16;

public class NewStructMessage {
    private String chatSessionsMessagesBelongNumber;
    private String chatSessionsMessagesSendDate;
    private String chatSessionsMessagesText;
    private String chatSessionsChatIdentifier;
    private String chatSessionsMembersLast;

    public String getChatSessionsMessagesBelongNumber() {
        return chatSessionsMessagesBelongNumber;
    }

    public void setChatSessionsMessagesBelongNumber(String chatSessionsMessagesBelongNumber) {
        this.chatSessionsMessagesBelongNumber = chatSessionsMessagesBelongNumber;
    }

    public String getChatSessionsMessagesSendDate() {
        return chatSessionsMessagesSendDate;
    }

    public void setChatSessionsMessagesSendDate(String chatSessionsMessagesSendDate) {
        this.chatSessionsMessagesSendDate = chatSessionsMessagesSendDate;
    }

    public String getChatSessionsMessagesText() {
        return chatSessionsMessagesText;
    }

    public void setChatSessionsMessagesText(String chatSessionsMessagesText) {
        this.chatSessionsMessagesText = chatSessionsMessagesText;
    }

    public String getChatSessionsChatIdentifier() {
        return chatSessionsChatIdentifier;
    }

    public void setChatSessionsChatIdentifier(String chatSessionsChatIdentifier) {
        this.chatSessionsChatIdentifier = chatSessionsChatIdentifier;
    }

    public String getChatSessionsMembersLast() {
        return chatSessionsMembersLast;
    }

    public void setChatSessionsMembersLast(String chatSessionsMembersLast) {
        this.chatSessionsMembersLast = chatSessionsMembersLast;
    }

    @Override
    public String toString() {
        return "NewStructMessage{" +
                "chatSessionsMessagesBelongNumber='" + chatSessionsMessagesBelongNumber + '\'' +
                ", chatSessionsMessagesSendDate='" + chatSessionsMessagesSendDate + '\'' +
                ", chatSessionsMessagesText='" + chatSessionsMessagesText + '\'' +
                ", chatSessionsChatIdentifier='" + chatSessionsChatIdentifier + '\'' +
                ", chatSessionsMembersLast='" + chatSessionsMembersLast + '\'' +
                '}';
    }
}
