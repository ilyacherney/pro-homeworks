package ru.otus.homework13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Set;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        ClientService clientService = context.getBean(ClientService.class);

        // Создаем адрес с телефонами
        Address address = new Address();
        address.setStreet("Lenina 1");

        Phone phone1 = new Phone();
        phone1.setNumber("123-456-789");
        phone1.setAddress(address);

        Phone phone2 = new Phone();
        phone2.setNumber("987-654-321");
        phone2.setAddress(address);

        address.setPhones(Set.of(phone1, phone2));

        // Создаем клиента с адресом
        Client client = new Client();
        client.setFirstName("Ivan");
        client.setAddress(address);

        // Сохраняем клиента
        clientService.save(client);
    }
}