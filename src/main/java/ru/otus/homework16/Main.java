package ru.otus.homework16;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.otus.homework16.sms.ChatData;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\ilyac\\IdeaProjects\\pro-homeworks\\src\\main\\resources\\sms.json";
        File file = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        ChatData chatData = mapper.readValue(file, ChatData.class);
        System.out.println(chatData);
    }
}