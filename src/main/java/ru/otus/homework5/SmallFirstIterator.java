package ru.otus.homework5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SmallFirstIterator implements Iterator<String> {
    private final Box box;
    private int currentSizeIndex = 0; // Индекс размера от 0 до 9
    private int colorIndex = 0;       // Индекс цвета (0 - red, 1 - green, 2 - blue, 3 - magenta)

    private final List<Matryoshka> matryoshkas;

    public SmallFirstIterator(Box box) {
        this.box = box;
        this.matryoshkas = List.of(box.getRed(), box.getGreen(), box.getBlue(), box.getMagenta());
    }

    @Override
    public boolean hasNext() {
        return currentSizeIndex < 10; // Всего 10 размеров
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        String value = matryoshkas.get(colorIndex).getItems().get(currentSizeIndex);

        colorIndex++;
        if (colorIndex == matryoshkas.size()) { // Переход к следующему размеру
            colorIndex = 0;
            currentSizeIndex++;
        }

        return value;
    }
}
