package ru.otus.homework16;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import ru.otus.homework16.sms.ChatData;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/sms.json";
        File file = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        ChatData chatData = mapper.readValue(file, ChatData.class);

        Converter converter = new Converter();
        NewStruct newStruct = converter.convert(chatData);

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        File newStructFile = new File("src/main/resources/new_struct.json");
        writer.writeValue(newStructFile, newStruct);

        NewStruct newStruct2 = mapper.readValue(newStructFile, NewStruct.class);
        System.out.println(newStruct2);

    }
}