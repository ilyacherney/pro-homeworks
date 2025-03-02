package ru.otus.homework16;

import ru.otus.homework16.sms.ChatData;
import ru.otus.homework16.sms.Message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Converter {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

    public NewStruct convert(ChatData chatData) {
        NewStruct newStruct = new NewStruct();

        String chatSessionsChatIdentifier = chatData.getChat_sessions().getFirst().getChat_identifier();
        String chatSessionsMembersLast = chatData.getChat_sessions().getFirst().getMembers().getFirst().getLast();

        List<Message> chatDataMessages = chatData.getChat_sessions().get(0).getMessages();

        // Сортируем сообщения по sendDate (от старых к новым)
        chatDataMessages.sort(Comparator.comparing(
                message -> parseSendDate(message.getSend_date())
        ));

        List<NewStructMessage> messagesToSet = new ArrayList<>();
        for (Message message : chatDataMessages) {
            NewStructMessage newStructMessage = messageToNewStructMessage(message, chatSessionsChatIdentifier, chatSessionsMembersLast);
            messagesToSet.add(newStructMessage);
        }
        newStruct.setMessages(messagesToSet);
        return newStruct;
    }

    private NewStructMessage messageToNewStructMessage(Message message, String chatSessionsChatIdentifier, String chatSessionsMembersLast) {
        NewStructMessage newStructMessage = new NewStructMessage();
        newStructMessage.setChatSessionsChatIdentifier(chatSessionsChatIdentifier);
        newStructMessage.setChatSessionsMembersLast(chatSessionsMembersLast);
        newStructMessage.setChatSessionsMessagesBelongNumber(message.getBelong_number());
        newStructMessage.setChatSessionsMessagesSendDate(message.getSend_date());
        newStructMessage.setChatSessionsMessagesText(message.getText());
        return newStructMessage;
    }

    // Метод для преобразования sendDate в LocalDateTime
    private LocalDateTime parseSendDate(String sendDate) {
        return LocalDateTime.parse(sendDate, DATE_FORMATTER);
    }
}
