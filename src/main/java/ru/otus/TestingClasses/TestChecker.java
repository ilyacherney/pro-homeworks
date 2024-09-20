package ru.otus.TestingClasses;

import ru.otus.TestingInterfaces.AfterSuite;
import ru.otus.TestingInterfaces.BeforeSuite;
import ru.otus.TestingInterfaces.Disabled;
import ru.otus.TestingInterfaces.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestChecker {

    public static boolean checkBeforeRunning(Class<?> testSuiteClass) {
        if (testSuiteClass.isAnnotationPresent(Disabled.class)) {
            System.out.println(testSuiteClass.getName() + " is disabled. Reason: " + testSuiteClass.getAnnotation(Disabled.class));
            return false;
        }
        return true;
    }

    public static int countAnnotationUses(Method[] methods, Class<? extends Annotation> annotationClass) {
        int usageCount = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) usageCount++;
        }
        return usageCount;
    }

    public static boolean checkMethod(Method method) {
        if (method.isAnnotationPresent(Disabled.class)) {
            System.out.println(method.getName() + " disabled. Reason: " + method.getAnnotation(Disabled.class).reason());
            return false;
        }
        return true;
    }

    public static boolean hasMultipleAnnotations(Method method) {
        try {
            int counter = 0;

            if (method.isAnnotationPresent(Test.class)) counter++;
            if (method.isAnnotationPresent(AfterSuite.class)) counter++;
            if (method.isAnnotationPresent(BeforeSuite.class)) counter++;

            if (counter > 1) throw new MultipleAnnotationUsesException("multiple annotation uses");
            return counter > 1;
        } catch (MultipleAnnotationUsesException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
