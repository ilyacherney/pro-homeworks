package ru.otus.homework8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = generateTasks();
    }

    public static List<Task> generateTasks() {
        List<Task> tasks = new ArrayList<Task>();
        tasks.add(new Task(1, "Полить цветы", "To do"));
        tasks.add(new Task(2, "Сходить за продуктами", "In progress"));
        tasks.add(new Task(3, "Написать отчет", "Done"));
        tasks.add(new Task(4, "Постирать вещи", "To do"));
        tasks.add(new Task(5, "Убраться в комнате", "In review"));
        tasks.add(new Task(6, "Позвонить родителям", "Done"));
        tasks.add(new Task(7, "Прочитать книгу", "To do"));
        tasks.add(new Task(8, "Приготовить ужин", "In progress"));
        tasks.add(new Task(9, "Проверить почту", "Done"));
        tasks.add(new Task(10, "Посмотреть сериал", "To do"));
        tasks.add(new Task(11, "Написать письмо коллеге", "In review"));
        tasks.add(new Task(12, "Сделать зарядку", "Done"));
        tasks.add(new Task(13, "Спланировать поездку", "To do"));
        tasks.add(new Task(14, "Починить велосипед", "In progress"));
        tasks.add(new Task(15, "Сходить к врачу", "To do"));
        tasks.add(new Task(16, "Сделать резервное копирование", "In review"));
        tasks.add(new Task(17, "Оплатить счета", "Done"));
        tasks.add(new Task(18, "Подготовить презентацию", "In progress"));
        tasks.add(new Task(19, "Купить подарок", "To do"));
        tasks.add(new Task(20, "Проверить обновления программ", "Done"));
        return tasks;
    }
}