package ru.otus;

import ru.otus.TestingClasses.MethodHasMultipleAnnotationsException;
import ru.otus.TestingClasses.MultipleAnnotationUsesException;
import ru.otus.TestingClasses.TestRunner;
import ru.otus.TestingClasses.TestSuite;

import java.lang.reflect.InvocationTargetException;

public class Application {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, MultipleAnnotationUsesException, MethodHasMultipleAnnotationsException {
        TestRunner.run(TestSuite.class);
    }
}