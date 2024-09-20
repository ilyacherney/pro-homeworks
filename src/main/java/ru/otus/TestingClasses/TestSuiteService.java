package ru.otus.TestingClasses;

import ru.otus.TestingInterfaces.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestSuiteService {

    public static List<Method> getMethodsWithAnnotation(Class<?> testSuiteClass, Class<? extends Annotation> annotationClass) throws MethodHasMultipleAnnotationsException {
        List<Method> methods = new ArrayList<>();
        for (Method method : testSuiteClass.getDeclaredMethods()) {
            if (TestChecker.hasMultipleAnnotations(method)) throw new MethodHasMultipleAnnotationsException("Method has multiple annotations.");
            if (method.isAnnotationPresent(annotationClass)) methods.add(method);
        }
        return methods;
    }
}
