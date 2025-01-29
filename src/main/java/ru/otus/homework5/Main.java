package ru.otus.homework5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание списков для каждого цвета
        List<String> redItems = new ArrayList<>();
        List<String> greenItems = new ArrayList<>();
        List<String> blueItems = new ArrayList<>();
        List<String> magentaItems = new ArrayList<>();

        // Заполнение списков элементами для каждого цвета
        for (int i = 0; i < 10; i++) {
            redItems.add("red" + i);
            greenItems.add("green" + i);
            blueItems.add("blue" + i);
            magentaItems.add("magenta" + i);
        }

        // Создание объектов Matryoshka для каждого цвета с соответствующими списками
        Matryoshka redMatryoshka = new Matryoshka(redItems);
        Matryoshka greenMatryoshka = new Matryoshka(greenItems);
        Matryoshka blueMatryoshka = new Matryoshka(blueItems);
        Matryoshka magentaMatryoshka = new Matryoshka(magentaItems);

        // Создание объекта Box с этими матрешками
        Box box = new Box(redMatryoshka, greenMatryoshka, blueMatryoshka, magentaMatryoshka);
//        System.out.println(redMatryoshka.getItems());

        Iterator<String> iterator = box.getColorFirstIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}