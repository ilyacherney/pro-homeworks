package ru.otus.TestingClasses;

import ru.otus.TestingInterfaces.AfterSuite;
import ru.otus.TestingInterfaces.BeforeSuite;
import ru.otus.TestingInterfaces.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class TestSuiteMetadataFactory {
    public static TestSuiteMetadata create(Class<?> testSuiteClass) throws NoSuchMethodException, MultipleAnnotationUsesException, MethodHasMultipleAnnotationsException {
        Constructor<?> constructor = testSuiteClass.getDeclaredConstructor();
        List<Method> testMethods = TestSuiteService.getMethodsWithAnnotation(testSuiteClass, Test.class);
        Method beforeSuiteMethod = getSingleUseMethodWithAnnotation(testSuiteClass, BeforeSuite.class);
        Method afterSuiteMethod = getSingleUseMethodWithAnnotation(testSuiteClass, AfterSuite.class);
        return new TestSuiteMetadata(testSuiteClass, constructor, testMethods, beforeSuiteMethod, afterSuiteMethod);
    }

    public static Method getSingleUseMethodWithAnnotation(Class<?> testSuiteClass, Class<? extends Annotation> annotationClass) throws MultipleAnnotationUsesException, MethodHasMultipleAnnotationsException {
        Method[] allMethods = testSuiteClass.getDeclaredMethods();
        if (TestChecker.countAnnotationUses(allMethods, annotationClass) == 0) return null;
        if (TestChecker.countAnnotationUses(allMethods, annotationClass) > 1) throw new MultipleAnnotationUsesException(">1 " + annotationClass.getSimpleName());
        return TestSuiteService.getMethodsWithAnnotation(testSuiteClass, annotationClass).getFirst();
    }
}
