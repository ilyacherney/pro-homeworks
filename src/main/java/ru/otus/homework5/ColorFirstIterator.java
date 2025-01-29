package ru.otus.homework5;

import java.util.Iterator;

public class ColorFirstIterator implements Iterator {

    int redIndex = 0;
    int greenIndex = 0;
    int blueIndex = 0;
    int magentaIndex = 0;
    private Box box;

    public ColorFirstIterator(Box box) {
        this.box = box;
    }

    @Override
    public boolean hasNext() {
        return redIndex < 10 || greenIndex < 10 || blueIndex < 10 || magentaIndex < 10;
    }

    @Override
    public Object next() {
        if (redIndex < 10) {
            String nextMatryoshka = box.getRed().getItems().get(redIndex);
            redIndex++;
            return nextMatryoshka;
        }
        if (greenIndex < 10) {
            String nextMatryoshka = box.getGreen().getItems().get(greenIndex);
            greenIndex++;
            return nextMatryoshka;
        }
        if (blueIndex < 10) {
            String nextMatryoshka = box.getBlue().getItems().get(blueIndex);
            blueIndex++;
            return nextMatryoshka;
        }
        if (magentaIndex < 10) {
            String nextMatryoshka = box.getMagenta().getItems().get(magentaIndex);
            magentaIndex++;
            return nextMatryoshka;
        }
        return null;
    }
}
