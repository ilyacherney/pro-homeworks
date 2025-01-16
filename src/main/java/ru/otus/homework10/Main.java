package ru.otus.homework10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // ��������� ����������
        ApplicationContext context = SpringApplication.run(Main.class, args);

        // �������� bean CartApp �� ���������
        CartApp cartApp = context.getBean(CartApp.class);
        cartApp.run();
    }
}